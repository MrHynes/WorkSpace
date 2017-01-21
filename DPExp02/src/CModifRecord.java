import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;


public class CModifRecord {
	private CRecord data;
	private List<CRecord> allRecord;

	public CModifRecord(List<CRecord> allRecord) {
		super();
		this.allRecord = allRecord;
		this.data=new CRecord();
	}

	//2

	public List<CRecord> modif(OutputStream out) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入要需需改的记录的id");
		int id = scanner.nextInt();
		for (int i = 0; i < allRecord.size(); i++) {
			this.data = allRecord.get(i);
			CInsertRecord insert = new CInsertRecord(allRecord, this.data);
			if (id == this.data.getId()) {
				System.out.print("输入要修改记录的属性名(1.类型、2.用户名、3.时间、4.内容)");
				int type = scanner.nextInt();
				System.out.print("输入修改的内容");
				String content = scanner.next();
				switch (type) {
				case 1:
					this.data.setRecordType(Integer.parseInt(content));
					insert.insertRecord(out);
					System.out.println("修改成功");
					break;
				case 2:
					this.data.setUserName(content);
					this.data.setUserNameLenth(content.length());
					insert.insertRecord(out);
					System.out.println("修改成功");
					break;
				case 3:
					this.data.setDate(content);
					this.data.setDateLength(content.length());
					insert.insertRecord(out);
					System.out.println("修改成功");
					break;
				case 4:
					this.data.setInfomation(content);
					this.data.setInfoLength(content.length() * 2);
					insert.insertRecord(out);
					System.out.println("修改成功");
					break;
				default:
					break;
				}
			} else {
				insert.insertRecord(out);
			}
		}
		return allRecord;
	}
}
