import java.io.InputStream;
import java.util.List;

public class CReadRecord {
	private CRecord data;
	private List<CRecord> allRecord;
	public CReadRecord( List<CRecord> allRecord) {
		super();
		this.data = new CRecord();
		this.allRecord = allRecord;
	}

	// 读取文件中的信息，并显示
	public List<CRecord> ReadInfomation(InputStream inputStream) throws Exception {
		//List<CData> allRecord = new ArrayList<CData>();
		byte b[] = new byte[4];
		for (int i = 0; i < 100;/*data.getDateLength();*/ i++) {
			CRecord data = new CRecord();
			inputStream.read(b);//读取数据类型
			data.setRecordType(byte2int(b));
			inputStream.read(b);
			data.setUserNameLenth(byte2int(b));//读取用户名的长度
			byte nameInfo[] = new byte[data.getUserNameLenth()];
			inputStream.read(nameInfo);	//读取用户名
			data.setUserName(new String(nameInfo));
			inputStream.read(b);
			data.setDateLength(byte2int(b));//读取时间长度
			byte date[] = new byte[data.getDateLength()];//读取时间
			inputStream.read(date);
			data.setDate(new String(date));
			inputStream.read(b);
			data.setInfoLength(byte2int(b));//读取信息长度
			byte info[] = new byte[data.getInfoLength()];
			inputStream.read(info);//读取信息
			data.setInfomation(new String(info));
			data.setId(i + 1);
			allRecord.add(data);
		}
		return allRecord;
	}

	public void ReadDataLenth(InputStream inputStream) throws Exception{
		byte b[] = new byte[4];
		inputStream.read(b);
		this.data.setRecordLenth(byte2int(b));
	}
	// 输出文件中的所有内容
	public void show() {
		for (int i = 0; i < allRecord.size(); i++) {
			CRecord data = allRecord.get(i);
			System.out.print("   " + data.getId() + "\t");
			System.out.print("   " + data.getRecordType() + "\t");
			System.out.print(data.getUserName() + "\t");
			System.out.print(data.getDate() + "\t");
			System.out.print(data.getInfomation() + "\t");
			System.out.println();
		}
	}

	public void head(){
		System.out.println("记录编号" + "\t" + "记录类型" + "\t" + "      用户名" + "\t\t" + "时间" + "\t\t\t" + "内容");
	}
	// 将byte转化成int
	public int byte2int(byte[] res) {
		// 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 表示安位或
				| ((res[2] << 24) >>> 8) | (res[3] << 24);
		return targets;
	}

}
