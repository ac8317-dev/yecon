package com.can.parser.raise.domestic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.can.parser.DDef;
import com.can.parser.DDef.RadarInfo;
import com.can.parser.Protocol;
import com.can.parser.DDef.AirInfo;
import com.can.parser.DDef.BaseInfo;
import com.can.parser.DDef.E_CMD_TYPE;
import com.can.parser.DDef.WheelInfo;
import com.can.parser.DDef.WheelKeyInfo;
import com.can.services.CanProxy;
import com.can.services.CanTxRxStub;

/**
 * ClassName:ReGreatWallH2Parser
 * 
 * @function:长城哈弗H2
 * @author Kim
 * @Date:  2016-7-23上午11:32:11
 * @Copyright: Copyright (c) 2016
 * @version 1.0
 */
public class ReGreatWallH2Parser extends CanProxy{

	private Handler mObjHandler;
	private ReGreatWallH2Protocol mObjProtocol;

	private AirInfo mObjAirInfo;
	private BaseInfo mObjBaseInfo;
	private RadarInfo mObjRadarInfo;
	private WheelInfo mObjWheelInfo;
	private WheelKeyInfo mObjWheelKeyInfo;

	public ReGreatWallH2Parser() {
		// TODO Auto-generated constructor stub
		mObjAirInfo = new AirInfo();
		mObjBaseInfo = new BaseInfo();
		mObjRadarInfo = new RadarInfo();
		mObjWheelInfo = new WheelInfo();
		mObjWheelKeyInfo = new WheelKeyInfo();
	}

	@Override
	public void start(Handler handler, Context context, String name,
			Protocol protocol) {
		// TODO Auto-generated method stub
		super.start(null, context, name, protocol);

		this.mObjHandler = handler;
		this.mObjProtocol = (ReGreatWallH2Protocol) protocol;
	}

	@Override
	public void Init(E_CMD_TYPE eCmdType) {
		// TODO Auto-generated method stub
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_AIR_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_AIR_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_BASE_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_BASE_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_WHEEL_KEY_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_WHEEL_KEY_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_WHEEL_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_WHEEL_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_VERSION_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_VERSION_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_RADAR_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_RADAR_INFO);
		super.RegisterProxy(ReGreatWallH2Protocol.DATA_TYPE_PANEL_KEY_INFO,
				ReGreatWallH2Protocol.DATA_TYPE_PANEL_KEY_INFO);
	}

	@Override
	public void deInit() {
		// TODO Auto-generated method stub
		super.deInit();
	}

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what)
		{
		case CanTxRxStub.MSG_CAN_RX:
			byte[] packet = CanTxRxStub.getRxPacket(msg);

			if (packet != null) {
				// 回复Ack
				byte[] ack = { (byte) 0xFF };
				sendMsg2Can(CanTxRxStub.getTxMessage(0, 0, ack, null));
			}

			int iCmdID = mObjProtocol.ParseRegisterCmdId(packet, 0);
			Message objUImsg = mObjHandler.obtainMessage();

			if (iCmdID == mObjProtocol.GetAirInfoCmdId()) {
				
				mObjAirInfo = mObjProtocol.parseAirInfo(packet, mObjAirInfo);
				objUImsg.what = DDef.AIR_CMD_ID;
				objUImsg.obj = mObjAirInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetBaseInfoCmdId()) {

				mObjBaseInfo = mObjProtocol.parseBaseInfo(packet, mObjBaseInfo);
				objUImsg.what = DDef.BASE_CMD_ID;
				objUImsg.obj = mObjBaseInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetWheelInfoCmdId()) {
	
				mObjWheelInfo = mObjProtocol.parseWheelInfo(packet, mObjWheelInfo);
				objUImsg.what = DDef.WHEEL_CMD_ID;
				objUImsg.obj = mObjWheelInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetWheelKeyInfoCmdId()) {

				mObjWheelKeyInfo = mObjProtocol.parseWheelKeyInfo(packet,
						mObjWheelKeyInfo);
				objUImsg.what = DDef.CANKEY_CMD_ID;
				objUImsg.obj = mObjWheelKeyInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetPanelKeyInfoCmdId()) {

				mObjWheelKeyInfo = mObjProtocol.parsePanelKeyInfo(packet,
						mObjWheelKeyInfo);
				objUImsg.what = DDef.CANKEY_CMD_ID;
				objUImsg.obj = mObjWheelKeyInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetRadarInfoCmdId()) {

				mObjRadarInfo = mObjProtocol.parseRadarInfo(packet,
						mObjRadarInfo);
				objUImsg.what = DDef.RADAR_CMD_ID;
				objUImsg.obj = mObjRadarInfo;
				mObjHandler.sendMessage(objUImsg);
			}
			break;
		default:
			super.handleMessage(msg);
			break;
		}
	}

	@Override
	public void Finish() {
		// TODO Auto-generated method stub
		Message objUImsg = mObjHandler.obtainMessage();
		objUImsg.what = DDef.FINISH_BIND;
		objUImsg.obj = mObjProtocol;
		mObjHandler.sendMessage(objUImsg);
	}

	@Override
	public Object getData(int iwhat, int iVal) {
		// TODO Auto-generated method stub
		return null;
	}
}
