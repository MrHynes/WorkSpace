package pers.qiqcheng.onlinechat.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String senderName;//发送方昵称
	private String sendMsg;//发送的信息
	private Date sendTime;//发送的时间
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSendMsg() {
		return sendMsg;
	}
	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取指定格式的时间
	 * @return
	 */
	public String getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getSendTime());
	}
	

}
