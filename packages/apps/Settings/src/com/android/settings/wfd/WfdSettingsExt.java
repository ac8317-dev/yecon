/* Copyright Statement:
 *
 * This software/firmware and related documentation ("MediaTek Software") are
 * protected under relevant copyright laws. The information contained herein
 * is confidential and proprietary to MediaTek Inc. and/or its licensors.
 * Without the prior written permission of MediaTek inc. and/or its licensors,
 * any reproduction, modification, use or disclosure of MediaTek Software,
 * and information contained herein, in whole or in part, shall be strictly prohibited.
 *
 * MediaTek Inc. (C) 2010. All rights reserved.
 *
 * BY OPENING THIS FILE, RECEIVER HEREBY UNEQUIVOCALLY ACKNOWLEDGES AND AGREES
 * THAT THE SOFTWARE/FIRMWARE AND ITS DOCUMENTATIONS ("MEDIATEK SOFTWARE")
 * RECEIVED FROM MEDIATEK AND/OR ITS REPRESENTATIVES ARE PROVIDED TO RECEIVER ON
 * AN "AS-IS" BASIS ONLY. MEDIATEK EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NONINFRINGEMENT.
 * NEITHER DOES MEDIATEK PROVIDE ANY WARRANTY WHATSOEVER WITH RESPECT TO THE
 * SOFTWARE OF ANY THIRD PARTY WHICH MAY BE USED BY, INCORPORATED IN, OR
 * SUPPLIED WITH THE MEDIATEK SOFTWARE, AND RECEIVER AGREES TO LOOK ONLY TO SUCH
 * THIRD PARTY FOR ANY WARRANTY CLAIM RELATING THERETO. RECEIVER EXPRESSLY ACKNOWLEDGES
 * THAT IT IS RECEIVER'S SOLE RESPONSIBILITY TO OBTAIN FROM ANY THIRD PARTY ALL PROPER LICENSES
 * CONTAINED IN MEDIATEK SOFTWARE. MEDIATEK SHALL ALSO NOT BE RESPONSIBLE FOR ANY MEDIATEK
 * SOFTWARE RELEASES MADE TO RECEIVER'S SPECIFICATION OR TO CONFORM TO A PARTICULAR
 * STANDARD OR OPEN FORUM. RECEIVER'S SOLE AND EXCLUSIVE REMEDY AND MEDIATEK'S ENTIRE AND
 * CUMULATIVE LIABILITY WITH RESPECT TO THE MEDIATEK SOFTWARE RELEASED HEREUNDER WILL BE,
 * AT MEDIATEK'S OPTION, TO REVISE OR REPLACE THE MEDIATEK SOFTWARE AT ISSUE,
 * OR REFUND ANY SOFTWARE LICENSE FEES OR SERVICE CHARGE PAID BY RECEIVER TO
 * MEDIATEK FOR SUCH MEDIATEK SOFTWARE AT ISSUE.
 *
 * The following software/firmware and/or related documentation ("MediaTek Software")
 * have been modified by MediaTek Inc. All revisions are subject to any receiver's
 * applicable license agreements with MediaTek Inc.
 */

package com.android.settings.wfd;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.hardware.display.WifiDisplayStatus;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.settings.ProgressCategory;
import com.android.settings.R;

//import com.autochips.featureoption.FeatureOption;
import android.util.Log;


import java.util.ArrayList;
import java.util.Arrays;

public class WfdSettingsExt {
    private static final String TAG = "WfdSettingsExt";

    private Activity mContext;
    private DisplayManager mDisplayManager;
    //change resolution menu id
    private static final int MENU_ID_CHANGE_RESOLUTION = Menu.FIRST + 1;

    //720p device resolution 0: 720p 30fps off; 1:720p 60fps off; 3:720p 60fps on; 4:720p 30fps on
    public static final int DEVICE_720P_60FPS_RESOLUTION = 3;
    public static final int DEVICE_720P_30FPS_RESOLUTION = 4;
    public static final ArrayList<Integer> DEVICE_720P_RESOLUTION_LIST = new ArrayList(
            Arrays.asList(DEVICE_720P_60FPS_RESOLUTION, DEVICE_720P_30FPS_RESOLUTION));
    
    //1080p device resolution 2: 1080p off; 5:1080p on; 6:720p 60 fps on; 7:720p 30 fps on
    public static final int DEVICE_1080P_ON_RESOLUTION = 5;
    public static final int DEVICE_1080P_60FPS_RESOLUTION = 6;
    public static final int DEVICE_1080P_30FPS_RESOLUTION = 7;
    public static final ArrayList<Integer> DEVICE_1080P_RESOLUTION_LIST = new ArrayList(
            Arrays.asList(DEVICE_1080P_ON_RESOLUTION, DEVICE_1080P_60FPS_RESOLUTION, 
            DEVICE_1080P_30FPS_RESOLUTION));

    // WFD sink supported
    private static final String SINK_SURFACE_TAG = "WfdSinkSurface";
    private static final String KEY_WFD_SINK_GUIDE = "wifi_display_hide_guide";
    private WfdSinkSurfaceFragment mSinkFragment;
    private CheckBoxPreference mDevicePref;
    private WifiP2pDevice mP2pDevice;
    private Toast mSinkToast;
    private int mPreWfdState = -1;

    public WfdSettingsExt(Activity context) {
        mContext = context;
        mDisplayManager = (DisplayManager) mContext
                .getSystemService(Context.DISPLAY_SERVICE);
    }

    /**
     * add change resolution option menu
     * @param menu the menu that change resolution menuitem will be added to
     * @param status current wfd status
     */
    /*public void onCreateOptionMenu(Menu menu, WifiDisplayStatus status) {
        int currentResolution = Settings.Global.getInt(mContext.getContentResolver(), 
                Settings.Global.WIFI_DISPLAY_RESOLUTION, 0);///{lingling}
        Log.d(TAG, "current resolution is " + currentResolution);
        if(DEVICE_720P_RESOLUTION_LIST.contains(currentResolution) || 
                DEVICE_1080P_RESOLUTION_LIST.contains(currentResolution)) {
            menu.add(Menu.NONE, MENU_ID_CHANGE_RESOLUTION, 0 ,R.string.wfd_change_resolution_menu_title)
            .setEnabled(status.getFeatureState() == WifiDisplayStatus.FEATURE_STATE_ON)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
    }
    
    /**
     * called when the option menu is selected
     * @param item the selected menu item
     * @return true, change resolution item is selected, otherwise false
     */
    /*public boolean onOptionMenuSelected(MenuItem item, FragmentManager fragmentManager) {
        if(item.getItemId() == MENU_ID_CHANGE_RESOLUTION) {
            new WfdChangeResolutionFragment().show(
                    fragmentManager, "change resolution");
            return true;
        }
        return false;
    }*/

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.v(TAG, "receive action: " + action);
            if (DisplayManager.ACTION_WIFI_DISPLAY_STATUS_CHANGED
                    .equals(action)) {
                    Log.d(TAG, "[lingling]action = ACTION_WIFI_DISPLAY_STATUS_CHANGED ");
                handleWfdStatusChanged(mDisplayManager.getWifiDisplayStatus());
            } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION
                    .equals(action)) {
                    Log.d(TAG, "[lingling]action = WIFI_P2P_THIS_DEVICE_CHANGED_ACTION ");
                mP2pDevice = (WifiP2pDevice) intent
                        .getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE);
                updateDeviceName();
            }
        }
    };

    /**
     * Add additional preference exception default preferences
     * 
     * @param preferenceScreen
     * @param available
     *            WFD is available
     * @return True if new preference added
     */
    public boolean addAdditionalPreference(PreferenceScreen preferenceScreen,
            boolean available) {
        boolean added = false;
        if (available /*&& FeatureOption.MTK_WFD_SINK_SUPPORT*/) {
            if (mDevicePref == null) {
                mDevicePref = new CheckBoxPreference(mContext) {
                    @Override
                    protected void onClick() {
                    Log.d(TAG, "[lingling]addAdditionalPreference1");
                        boolean checked = mDevicePref.isChecked();
						Log.d(TAG, "[lingling]addAdditionalPreference2 checked"+checked);
                        if (!checked) {
							Log.d(TAG, "[lingling]addAdditionalPreference1  if (!checked)");
                            prepareWfdSinkConnection();
                        }
                        mDevicePref.setChecked(!checked);
                    }
                };
                if (mContext.getResources().getBoolean(com.android.internal.R.bool.config_voice_capable)) {
                   //mDevicePref.setIcon(R.drawable.ic_wfd_cellphone);    // for phones                
                //} else {
                    mDevicePref.setIcon(R.drawable.ic_wfd_laptop);   // for tablets, etc.
                }
                mDevicePref.setPersistent(false);
                mDevicePref.setSummary(R.string.wfd_sink_summary);
                mDevicePref.setOrder(2);
            }
            preferenceScreen.addPreference(mDevicePref);
            updateDeviceName();
            PreferenceCategory cat = new ProgressCategory(mContext, null, R.string.wifi_display_no_devices_found);
            cat.setOrder(3);
            cat.setTitle(R.string.wfd_device_category);
            preferenceScreen.addPreference(cat);
            added = true;
        }
        return added;
    }

    /**
     * Called when activity started
     */
    public void onResume() {
        Log.d(TAG, "[lingling]onResume");
        //if (FeatureOption.MTK_WFD_SINK_SUPPORT) {
            WifiDisplayStatus wfdStatus = mDisplayManager
                    .getWifiDisplayStatus();
		Log.d(TAG, "[lingling]onResume+handleWfdStatusChanged ");
            handleWfdStatusChanged(wfdStatus);
            IntentFilter filter = new IntentFilter();
            filter.addAction(DisplayManager.ACTION_WIFI_DISPLAY_STATUS_CHANGED);
            filter
                    .addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
            mContext.registerReceiver(mReceiver, filter);
        //}
    }

    /**
     * Called when activity stopped
     */
    public void onPause() {
        Log.d(TAG, "onPause");
        //if (FeatureOption.MTK_WFD_SINK_SUPPORT) {
            mContext.unregisterReceiver(mReceiver);
        //}
    }

    /**
     * Setup WFD sink connection, called when WFD sink surface is available
     */
    public void setupWfdSinkConnection() {
        Log.d(TAG, "[lingling]setupWfdSinkConnection");
        setWfdMode(true);
        waitWfdSinkConnection();
    }

    /**
     * Disconnect WFD sink connection, called when WFD sink surface will exit
     */
    public void disconnectWfdSinkConnection() {
        Log.d(TAG, "[lingling]disconnectWfdSinkConnection");
        mDisplayManager.disconnectWifiDisplay();
        Log.d(TAG, "[lingling]after disconnectWfdSinkConnection");
    }

    private void prepareWfdSinkConnection() {
        Log.d(TAG, "[lingling]prepareWfdSinkConnection in");
        if (mSinkFragment == null) {
            mSinkFragment = new WfdSinkSurfaceFragment(WfdSettingsExt.this);
        }
        if (mSinkFragment.isAdded()) {
            Log.d(TAG, "[lingling]prepareWfdSinkConnection fragment is added");
        } else {
            mSinkFragment.show(mContext.getFragmentManager(), SINK_SURFACE_TAG);
        }
    }

    private void updateDeviceName() {
        if (mP2pDevice != null && mDevicePref != null) {
            if (TextUtils.isEmpty(mP2pDevice.deviceName)) {
                mDevicePref.setTitle(mP2pDevice.deviceAddress);
            } else {
                mDevicePref.setTitle(mP2pDevice.deviceName);
            }
        }
    }

    private void handleWfdStatusChanged(WifiDisplayStatus status) {
        boolean bStateOn = (status != null && status.getFeatureState() == WifiDisplayStatus.FEATURE_STATE_ON);
        Log.d(TAG, "[lingling]handleWfdStatusChanged bStateOn: " + bStateOn);
        if (bStateOn) {
            int wfdState = status.getActiveDisplayState();
            Log.d(TAG, "[lingling]handleWfdStatusChanged wfdState: " + wfdState);
            if (mPreWfdState != wfdState) {
				Log.d(TAG, "[lingling]handleWfdStatusChanged if (mPreWfdState != wfdState) wfdState: " + wfdState);
                handleWfdStateChanged(wfdState, isSinkMode());
                mPreWfdState = wfdState;
            }
        } else {
            if (mPreWfdState != -1) {
                handleWfdStateChanged(
                        WifiDisplayStatus.DISPLAY_STATE_NOT_CONNECTED, true);
            }
            mPreWfdState = -1;
        }
    }

    private void handleWfdStateChanged(int wfdState, boolean sinkMode) {
		sinkMode = true;
		//wfdState = 0;
		Log.d(TAG, "[lingling]handleWfdStateChanged wfdState+sinkMode: " + wfdState+sinkMode);
        switch (wfdState) {
        case WifiDisplayStatus.DISPLAY_STATE_NOT_CONNECTED:
            if (sinkMode) {
				Log.d(TAG, "[lingling]handleWfdStateChanged  case WifiDisplayStatus.DISPLAY_STATE_NOT_CONNECTED:mSinkFragment : "+mSinkFragment );
                if (mSinkFragment != null) {
                    mSinkFragment.dismiss();
                }

				Log.d(TAG, "[lingling]handleWfdStateChanged mPreWfdState: " + mPreWfdState);
                if (mPreWfdState == WifiDisplayStatus.DISPLAY_STATE_CONNECTED) {
                    showToast(false);
                }
                setWfdMode(false);
                if (mDevicePref != null) {
                    mDevicePref.setChecked(false);
                }
            }
            break;
        case WifiDisplayStatus.DISPLAY_STATE_CONNECTING:
            break;
        case WifiDisplayStatus.DISPLAY_STATE_CONNECTED:
            if (sinkMode) {
                SharedPreferences preferences = mContext.getPreferences(Context.MODE_PRIVATE);
                boolean showGuide = preferences.getBoolean(KEY_WFD_SINK_GUIDE , true);
                if (showGuide) {
                    if (mSinkFragment != null) {
                        mSinkFragment.addWfdSinkGuide();
                        preferences.edit()
                                .putBoolean(KEY_WFD_SINK_GUIDE, false).commit();
                    }
                }
                showToast(true);
            }
            break;
        default:
            break;
        }
    }

    private void showToast(boolean connected) {
        if (mSinkToast != null) {
            mSinkToast.cancel();
        }
        mSinkToast = Toast.makeText(mContext,
                connected ? R.string.wfd_sink_toast_enjoy
                        : R.string.wfd_sink_toast_disconnect,
                connected ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        mSinkToast.show();
    }

    private boolean isSinkMode() {
		return true;
        //return mDisplayManager.getIfSinkEnabled();
    }

    private void setWfdMode(boolean sink) {
        Log.d(TAG, "[lingling]setWfdMode " + sink);
        mDisplayManager.requestEnableSink(sink);
    }

    private void waitWfdSinkConnection() {
        mDisplayManager.requestWaitConnection(mSinkFragment.getSinkSurface());
    }

    public void sendUibcEvent(String eventDesc) {
        mDisplayManager.sendUibcInputEvent(eventDesc);
    }

}
