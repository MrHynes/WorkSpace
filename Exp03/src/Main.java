
public class Main {
//��д���򣬷ֱ�ʵ����̬�ڲ��ࡢ�Ǿ�̬�ڲ��ࡢ�ֲ��ڲ���������ڲ���Ķ����ʹ�ã�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Ǿ�̬�ڲ���
		InternalClass internalClass=new InternalClass(); 
		internalClass.show(); 
		//��̬�ڲ���
		StaticInternalClass staticInternalClass=new StaticInternalClass();
		staticInternalClass.show();
		//�ֲ����ڲ���
		PartInternalClass partInternalClass=new PartInternalClass();
		partInternalClass.fun();
		//�����ڲ���
		AnonymityInternalClass anonymityInternalClass=new AnonymityInternalClass();
		anonymityInternalClass.fun();
		
		
	}
}
