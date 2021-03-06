package com.can.parser.raise.domestic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.can.parser.DDef;
import com.can.parser.Protocol;
import com.can.parser.DDef.AirInfo;
import com.can.parser.DDef.BaseInfo;
import com.can.parser.DDef.E_CMD_TYPE;
import com.can.parser.DDef.WheelInfo;
import com.can.parser.DDef.WheelKeyInfo;
import com.can.services.CanProxy;
import com.can.services.CanTxRxStub;

/**
 * ClassName:ReChanaV7Parser
 * 
 * @function:长安锐翔V7
 * @author Kim
 * @Date: 2016-7-23上午11:42:31
 * @Copyright: Copyright (c) 2016
 * @version 1.0
 */
public class ReChanaV7Parser extends CanProxy {

	private Handler mObjHandler;
	private ReChanaV7Protocol mObjProtocol;

	private AirInfo mObjAirInfo;
	private BaseInfo mObjBaseInfo;
	private WheelInfo mObjWheelInfo;
	private WheelKeyInfo mObjWheelKeyInfo;

	public ReChanaV7Parser() {
		// TODO Auto-generated constructor stub
		mObjAirInfo = new AirInfo();
		mObjBaseInfo = new BaseInfo();
		mObjWheelInfo = new WheelInfo();
		mObjWheelKeyInfo = new WheelKeyInfo();
	}

	@Override
	public void start(Handler handler, Context context, String name,
			Protocol protocol) {
		// TODO Auto-generated method stub
		super.start(null, context, name, protocol);

		this.mObjHandler = handler;
		this.mObjProtocol = (ReChanaV7Protocol) protocol;
	}

	@Override
	public void Init(E_CMD_TYPE eCmdType) {
		// TODO Auto-generated method stub
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_AIR_INFO,
				ReChanaV7Protocol.DATA_TYPE_AIR_INFO);
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_BASE_INFO,
				ReChanaV7Protocol.DATA_TYPE_BASE_INFO);
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_WHEEL_KEY_INFO,
				ReChanaV7Protocol.DATA_TYPE_WHEEL_KEY_INFO);
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_WHEEL_INFO,
				ReChanaV7Protocol.DATA_TYPE_WHEEL_INFO);
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_VERSION_INFO,
				ReChanaV7Protocol.DATA_TYPE_VERSION_INFO);
		super.RegisterProxy(ReChanaV7Protocol.DATA_TYPE_PANEL_KEY_INFO,
				ReChanaV7Protocol.DATA_TYPE_PANEL_KEY_INFO);
	}

	@Override
	public void deInit() {
		// TODO Auto-generated method stub
		super.deInit();
	}

	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
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
			} else if (iCmdID == mObjProtocol.GetWheelKeyInfoCmdId()) {

				mObjWheelKeyInfo = mObjProtocol.parseWheelKeyInfo(packet,
						mObjWheelKeyInfo);
				objUImsg.what = DDef.CANKEY_CMD_ID;
				objUImsg.obj = mObjWheelKeyInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetPanelKeyCmdId()) {

				mObjWheelKeyInfo = mObjProtocol.parsePanelKeyInfo(packet,
						mObjWheelKeyInfo);
				objUImsg.what = DDef.CANKEY_CMD_ID;
				objUImsg.obj = mObjWheelKeyInfo;
				mObjHandler.sendMessage(objUImsg);
			} else if (iCmdID == mObjProtocol.GetWheelInfoCmdId()) {

				mObjWheelInfo = mObjProtocol.parseWheelInfo(packet,
						mObjWheelInfo);
				objUImsg.what = DDef.WHEEL_CMD_ID;
				objUImsg.obj = mObjWheelInfo;
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
