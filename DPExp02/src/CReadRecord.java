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

	// ��ȡ�ļ��е���Ϣ������ʾ
	public List<CRecord> ReadInfomation(InputStream inputStream) throws Exception {
		//List<CData> allRecord = new ArrayList<CData>();
		byte b[] = new byte[4];
		for (int i = 0; i < 100;/*data.getDateLength();*/ i++) {
			CRecord data = new CRecord();
			inputStream.read(b);//��ȡ��������
			data.setRecordType(byte2int(b));
			inputStream.read(b);
			data.setUserNameLenth(byte2int(b));//��ȡ�û����ĳ���
			byte nameInfo[] = new byte[data.getUserNameLenth()];
			inputStream.read(nameInfo);	//��ȡ�û���
			data.setUserName(new String(nameInfo));
			inputStream.read(b);
			data.setDateLength(byte2int(b));//��ȡʱ�䳤��
			byte date[] = new byte[data.getDateLength()];//��ȡʱ��
			inputStream.read(date);
			data.setDate(new String(date));
			inputStream.read(b);
			data.setInfoLength(byte2int(b));//��ȡ��Ϣ����
			byte info[] = new byte[data.getInfoLength()];
			inputStream.read(info);//��ȡ��Ϣ
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
	// ����ļ��е���������
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
		System.out.println("��¼���" + "\t" + "��¼����" + "\t" + "      �û���" + "\t\t" + "ʱ��" + "\t\t\t" + "����");
	}
	// ��byteת����int
	public int byte2int(byte[] res) {
		// һ��byte��������24λ���0x??000000��������8λ���0x00??0000
		int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | ��ʾ��λ��
				| ((res[2] << 24) >>> 8) | (res[3] << 24);
		return targets;
	}

}
