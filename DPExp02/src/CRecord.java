
public class CRecord {
	private static int recordLenth;//��̬��������־�ļ��ļ�¼��
	private int id;//ÿ����¼�ı��
	private int recordType;//��¼����
	private int userNameLenth;//�û�������
	private String userName;//�û���
	private int dateLength;//ʱ�䳤��
	private String date;//ʱ��
	private int infoLength;//���ݳ���
	private String infomation;//����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecordLenth() {
		return recordLenth;
	}
	public void setRecordLenth(int recordLenth) {
		this.recordLenth = recordLenth;
	}
	public int getRecordType() {
		return recordType;
	}
	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}
	public int getUserNameLenth() {
		return userNameLenth;
	}
	public void setUserNameLenth(int userNameLenth) {
		this.userNameLenth = userNameLenth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getDateLength() {
		return dateLength;
	}
	public void setDateLength(int dateLength) {
		this.dateLength = dateLength;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getInfoLength() {
		return infoLength;
	}
	public void setInfoLength(int infoLength) {
		this.infoLength = infoLength;
	}
	public String getInfomation() {
		return infomation;
	}
	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}
	@Override
	public String toString() {
		return "CData [id=" + id + ", recordType=" + recordType + ", userNameLenth=" + userNameLenth + ", userName="
				+ userName + ", dateLength=" + dateLength + ", date=" + date + ", infoLength=" + infoLength
				+ ", infomation=" + infomation + "]";
	}

}
