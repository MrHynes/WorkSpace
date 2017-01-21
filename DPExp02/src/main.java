import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.MenuElement;

import org.omg.CORBA.PUBLIC_MEMBER;

public class main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "DPExp02" + File.separator + "src"
				+ File.separator + "chrom2000.log";
		File file = new File(path);
		InputStream in = new FileInputStream(file);
		List<CRecord> allRecord = new ArrayList<CRecord>();
		CReadRecord read = new CReadRecord(allRecord);
		CRecord data = new CRecord();
		COutputRecordLength outputRecordLength=new COutputRecordLength(allRecord);
		// 读取文件中的信息，并显示
		read.ReadDataLenth(in);
		allRecord = read.ReadInfomation(in);
		read.head();
		read.show();
		in.close();
		boolean index=true;
		while (index) {
			System.out.println("1.插入记录\n2.删除记录\n3.修改记录\n4.移动记录\n5.退出\n输入要进行的操作的序号");
			Scanner scanner = new Scanner(System.in);
			int type = scanner.nextInt();
			switch (type) {
			case 1:
				// 在末尾插入数据
				CInsertRecord insert = new CInsertRecord(allRecord, data);
				allRecord = insert.Input();
				OutputStream out = new FileOutputStream(file, true);
				insert.insertRecord(out);
				out.close();
				data=allRecord.get(100);
				show(allRecord);
				break;
			case 2:
				// 删除记录
				OutputStream out2 = new FileOutputStream(file);
				CDeleteRecord delete = new CDeleteRecord(allRecord);
				outputRecordLength.changeRecordLength(out2);
				allRecord = delete.deleteRecord(out2);
				out2.close();
				show(allRecord);
				break;
			case 3:
				// 修改
				OutputStream out3 = new FileOutputStream(file);
				CModifRecord modif = new CModifRecord(allRecord);
				outputRecordLength.changeRecordLength(out3);
				allRecord = modif.modif(out3);
				out3.close();
				show(allRecord);
				break;
			case 4:
				// 移动记录
				OutputStream out4 = new FileOutputStream(file);
				CMoveRecord move = new CMoveRecord(allRecord);
				outputRecordLength.changeRecordLength(out4);
				allRecord = move.Move(out4);
				out4.close();
				show(allRecord);
				break;
			case 5:
				index=false;
				System.out.println("已经退出");
				break;
			default:
				break;
			}
		}
	}

	public static void show(List<CRecord> allRecord) {
		CReadRecord read = new CReadRecord(allRecord);
		read.head();
		read.show();
	}
}