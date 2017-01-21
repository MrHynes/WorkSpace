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
		System.out.println("����Ҫ����ĵļ�¼��id");
		int id = scanner.nextInt();
		for (int i = 0; i < allRecord.size(); i++) {
			this.data = allRecord.get(i);
			CInsertRecord insert = new CInsertRecord(allRecord, this.data);
			if (id == this.data.getId()) {
				System.out.print("����Ҫ�޸ļ�¼��������(1.���͡�2.�û�����3.ʱ�䡢4.����)");
				int type = scanner.nextInt();
				System.out.print("�����޸ĵ�����");
				String content = scanner.next();
				switch (type) {
				case 1:
					this.data.setRecordType(Integer.parseInt(content));
					insert.insertRecord(out);
					System.out.println("�޸ĳɹ�");
					break;
				case 2:
					this.data.setUserName(content);
					this.data.setUserNameLenth(content.length());
					insert.insertRecord(out);
					System.out.println("�޸ĳɹ�");
					break;
				case 3:
					this.data.setDate(content);
					this.data.setDateLength(content.length());
					insert.insertRecord(out);
					System.out.println("�޸ĳɹ�");
					break;
				case 4:
					this.data.setInfomation(content);
					this.data.setInfoLength(content.length() * 2);
					insert.insertRecord(out);
					System.out.println("�޸ĳɹ�");
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
