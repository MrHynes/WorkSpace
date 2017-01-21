import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

public class CMoveRecord {
	private List<CRecord> allRecord;
	private CRecord data;

	public CMoveRecord(List<CRecord> allRecord) {
		super();
		this.allRecord = allRecord;
		this.data = new CRecord();
	}

	//1

	public List<CRecord> Move(OutputStream out) throws Exception {
		CInsertRecord insertData=new CInsertRecord(this.allRecord, this.data);
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫ�ƶ��ļ�¼��id");
		int original = scanner.nextInt();
		System.out.println(allRecord.size());
		if (original <=0 || original >allRecord.size()) {
			System.out.println("��������");
			return allRecord;
		}
		System.out.println("����Ҫ�ƶ�����λ��");
		int dest = scanner.nextInt();
		if (dest <=0 || dest >allRecord.size()) {
			System.out.println("��������");
			return allRecord;
		}
		if (dest != original) {
			// ���Ŀ��λ����ԭλ��֮ǰ
			if (dest < original) {
				this.data = this.allRecord.remove(original - 1);
				this.allRecord.add(dest - 1, this.data);
				RefreshID();
				insert(out);
			}
			// ���Ŀ��λ����ԭʼλ��֮��
			else {
				this.data=this.allRecord.remove(original - 1);
				this.allRecord.add(dest-2, this.data);
				RefreshID();
				insert(out);
			}
		}
		return this.allRecord;
	}

	public void RefreshID() {
		for (int i = 0; i < allRecord.size(); i++) {
			allRecord.get(i).setId(i + 1);
		}
	}
	public void insert(OutputStream out) throws Exception{
		for(int i=0;i<allRecord.size();i++){
			this.data=allRecord.get(i);
			CInsertRecord insertData=new CInsertRecord(this.allRecord, this.data);
			insertData.insertRecord(out);
		}	
	}
}