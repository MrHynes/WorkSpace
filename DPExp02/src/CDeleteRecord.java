import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

public class CDeleteRecord {
	private List<CRecord> allRecord;
	private CRecord data;

	public CDeleteRecord(List<CRecord> allRecord) {
		super();
		this.allRecord = allRecord;
		this.data=new CRecord();
	}

	//3
	
	public List<CRecord> deleteRecord(OutputStream out) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("输入需要删除的记录的id");
		int id=sc.nextInt();
		CRecord d=new CRecord();
		for(int i=0;i<allRecord.size();i++){
			d=allRecord.get(i);//getid=1..100  i=0...99
			CInsertRecord insert= new CInsertRecord(allRecord, d);
		   if(d.getId()==id){
			    allRecord.remove(d);
				System.out.println("删除成功");
				int len=this.data.getRecordLenth()-1;
				this.data.setRecordLenth(len);
			}
			else{
				insert.insertRecord(out);
			}
		}
        RefreshID();
		return allRecord;
	}
	
	public void RefreshID(){
		for(int i=0;i<allRecord.size();i++){
			allRecord.get(i).setId(i+1);
		}
	}


}
