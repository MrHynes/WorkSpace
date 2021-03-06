package Chapter07;
/**
 * 求矩阵相乘的数量乘法最小次数，以及最优乘法顺序,最后输出乘积
 * 矩阵链乘问题
 * @author Buer
 *
 */
//r[i]数组，表示矩阵的阶，如A的矩阵为2*3，B的矩阵为3*4，那么数组r[]={2,3,4};
//最优顺序的信息数组S[1..n][ 1..n]。
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
		//输出矩阵链
		for(int i=1;i<=n;i++){
			for(int j1=i;j1<=n;j1++){
				System.out.print(C[i][j1]+" ");
			}
			System.out.println();
		}
		//return C[1][n];
		System.out.println("最小乘法次数为："+C[1][n]);
		System.out.println("最优顺序：");
		for(int i=1;i<=n;i++){
			for(int j1=i;j1<=n;j1++){
				System.out.print(S[i][j1]+" ");
			}
			System.out.println();
		}
		//matchin_product(C[1][n], S,1,n);
		
	}
	//求乘积
	//public static int  matchin_product(int n,int S[][],int i,int j){
		/*if i=j then return Mi
		else
			A=matchain_product(i, S[i, j]-1)
			B=matchain_product(S[i, j], j)
			C=multiply( A , B)  //计算两个矩阵乘积C=AB。
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
