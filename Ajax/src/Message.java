

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	private String senderName;//���ͷ��ǳ�
	private String sendMsg;//���͵���Ϣ
	private Date sendTime;//���͵�ʱ��
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
	 * ��ȡָ����ʽ��ʱ��
	 * @return
	 */
	public String getTime(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getSendTime());
	}
	@Override
	public String toString() {
		return "Message [senderName=" + senderName + ", sendMsg=" + sendMsg + ", sendTime=" + sendTime + "]";
	}
	

}
