
public class CRecord {
	private static int recordLenth;//静态变量，日志文件的记录数
	private int id;//每条记录的编号
	private int recordType;//记录类型
	private int userNameLenth;//用户名长度
	private String userName;//用户名
	private int dateLength;//时间长度
	private String date;//时间
	private int infoLength;//内容长度
	private String infomation;//内容
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
