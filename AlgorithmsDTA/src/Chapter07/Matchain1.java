package Chapter07;
/**
 * �������˵������˷���С�������Լ����ų˷�˳��,�������˻�
 * ������������
 * @author Buer
 *
 */
//r[i]���飬��ʾ����Ľף���A�ľ���Ϊ2*3��B�ľ���Ϊ3*4����ô����r[]={2,3,4};
//����˳�����Ϣ����S[1..n][ 1..n]��
public class Matchain1 {
	public static int min(int x,int y){
		return x<y ? x:y;
	}
	public static void matchain(int n,int r[]){
		int C[][]=new int[n+1][n+1]; 
		int S[][]=new int[n+1][n+1]; 
		for(int i=1;i<n+1;i++){
			C[i][i]=0;
		}
		int j;
		for(int d=1;d<n;d++){
			for(int i=1;i<=n-d;i++){
				j=i+d;
				C[i][j]=Integer.MAX_VALUE;//
				for(int k=i+1;k<=j;k++){
					//C[i][j]=min{C[i][k-1]+c[k][j]+r1*rk*rj+1};
					//C[i][j]=min(C[i][j],C[i][k-1]+C[k][j]+r[i]*r[k]*r[j+1]);
					int x=C[i][k-1]+C[k][j]+r[i]*r[k]*r[j+1];
					if(x<C[i][j]){
						C[i][j]=x; S[i][j]=k;
					}
					
				}
			}
		}
		//���������
		for(int i=1;i<=n;i++){
			for(int j1=i;j1<=n;j1++){
				System.out.print(C[i][j1]+" ");
			}
			System.out.println();
		}
		//return C[1][n];
		System.out.println("��С�˷�����Ϊ��"+C[1][n]);
		System.out.println("����˳��");
		for(int i=1;i<=n;i++){
			for(int j1=i;j1<=n;j1++){
				System.out.print(S[i][j1]+" ");
			}
			System.out.println();
		}
		//matchin_product(C[1][n], S,1,n);
		
	}
	//��˻�
	//public static int  matchin_product(int n,int S[][],int i,int j){
		/*if i=j then return Mi
		else
			A=matchain_product(i, S[i, j]-1)
			B=matchain_product(S[i, j], j)
			C=multiply( A , B)  //������������˻�C=AB��
		return C*/
	//}
	public static void main(String[] args) {
		int n=5; 
		int r[]={0,5,10,4,6,10,2};
		/*int n=3;
		int r[]={0,2,10,2,10};*/
		//System.out.println(matchain(n, r));
		matchain(n, r);
	}
}