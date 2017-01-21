import java.awt.image.BandCombineOp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CDataIOStream {
	public static void main(String[] args) throws Exception {
		String path = "F:" + File.separator + "WorkSpace" + File.separator + "Exp08" + File.separator + "src"
				+ File.separator + "f6.txt";
		File file=new File(path);
		//数据输出/输入流 DataInputSream DataOutputStream
		DataOutputStream dout=new DataOutputStream(new FileOutputStream(file));
		String name[]={"衬衣","手套","围巾"};
		float prices[]={98.3f,30.2f,50.5f};
		int num[]={34,23,55};
		for(int i=0;i<name.length;i++){
			dout.writeChars(name[i]);
			dout.writeChar('\t');
			dout.writeFloat(prices[i]);
			dout.writeChar('\t');
			dout.writeInt(num[i]);
			dout.writeChar('\n');
		}
		dout.close();
		
		DataInputStream din=new DataInputStream(new FileInputStream(file));
		String namex=null;
		float price=0f;
		int numi=0;
		char []temp=null;
		int len=0;
		char c;
		//while(din.readLine()!=null){
		for(int i=0;i<3;i++){
			temp=new char[20];
			len=0;
			while((c=din.readChar())!='\t'){
				temp[len]=c;
				len++;
			}
			namex=new String(temp, 0, len);
			price=din.readFloat();
			din.readChar();
			numi=din.readInt();
			din.readChar();
			System.out.printf("名称:%s;价格:%5.2f;数量:%d\n",namex,price,numi);
			
		}
		din.close();
	}

}
