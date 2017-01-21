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
		System.out.println("�������¼���ͣ��û�����ʱ�䣬��¼����");
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
		this.data.setInfoLength(info.length()*2);//����*2
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
		out.write(b);//д��¼����
		b=int2byte(this.data.getUserNameLenth());
		out.write(b);//д�û�������
		byte name[]=this.data.getUserName().getBytes();
		out.write(name);//д�û���
		b=int2byte(this.data.getDateLength());
		out.write(b);//дʱ�䳤��
		byte date[]=this.data.getDate().getBytes();
		out.write(date);//дʱ��
		b=int2byte(this.data.getInfoLength());
		out.write(b);//д��Ϣ����
		byte info[]=this.data.getInfomation().getBytes();
		out.write(info);//д��Ϣ����
		//�ļ���ͷ�ĸ��ֽ�Ҳ��Ҫ��
	}
	
	//intתbyte
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (res & 0xff);// ���λ
		targets[1] = (byte) ((res >> 8) & 0xff);// �ε�λ
		targets[2] = (byte) ((res >> 16) & 0xff);// �θ�λ
		targets[3] = (byte) (res >>> 24);// ���λ,�޷������ơ�
		return targets;
	}
}
