import java.io.OutputStream;
import java.util.List;

public class COutputRecordLength {
	private List<CRecord> allRecord;
	private CRecord data;
	public COutputRecordLength(List<CRecord> allRecord) {
		super();
		this.allRecord = allRecord;
		this.data=new CRecord();
	}

	public void changeRecordLength(OutputStream out) throws Exception {
		CInsertRecord insert = new CInsertRecord(allRecord, data);
		byte b[] = new byte[4];
		// 将记录总长度写入文件
		b = insert.int2byte(this.data.getRecordLenth());
		out.write(b);
	}

}
