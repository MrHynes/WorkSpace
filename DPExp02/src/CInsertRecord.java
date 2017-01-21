import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

public class CInsertRecord {
	private CRecord data;
	private List<CRecord> allRecord;
	
	public CInsertRecord(List<CRecord> allRecord,CRecord data) {
		super();
		this.allRecord = allRecord;
		this.data = data;
	}

	public List<CRecord> Input(){
		System.out.println("请输入记录类型，用户名，时间，记录内容");
		Scanner scanner=new Scanner(System.in);
		int strRecordType=scanner.nextInt();
		String userName=scanner.next();
		scanner.nextLine();
		String date=scanner.nextLine();
		String info=scanner.nextLine();
		
		this.data.setRecordType(strRecordType);
		this.data.setUserNameLenth(userName.length());
		this.data.setUserName(userName);
		this.data.setDateLength(date.length());
		this.data.setDate(date);
		this.data.setInfoLength(info.length()*2);//中文*2
		this.data.setInfomation(info);
		int len=this.data.getRecordLenth();
		this.data.setRecordLenth(len+1);
		int id=this.allRecord.size()+1;
		this.data.setId(id);
		allRecord.add(this.data);
		return allRecord;
	}

	public void insertRecord(OutputStream out) throws Exception{
		byte b[]=new byte[4];
		b=int2byte(this.data.getRecordType());
		out.write(b);//写记录类型
		b=int2byte(this.data.getUserNameLenth());
		out.write(b);//写用户名长度
		byte name[]=this.data.getUserName().getBytes();
		out.write(name);//写用户名
		b=int2byte(this.data.getDateLength());
		out.write(b);//写时间长度
		byte date[]=this.data.getDate().getBytes();
		out.write(date);//写时间
		b=int2byte(this.data.getInfoLength());
		out.write(b);//写信息长度
		byte info[]=this.data.getInfomation().getBytes();
		out.write(info);//写信息内容
		//文件的头四个字节也需要改
	}
	
	//int转byte
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (res & 0xff);// 最低位
		targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
		targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
		targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
		return targets;
	}
}
