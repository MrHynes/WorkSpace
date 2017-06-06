package Chapter08;

/**
 * 设有一个容量为C的背包，n个物品的集合U={u1, u2, …, un}，
 * 物品ui的体积和价值分别为sj和vj，C, sj, vj都是正实数。
 * 在U中选择物品装入背包，使得装入背包的物品总价值最大。设允许取每种物品的一部分装入背包.
 * @author Buer
 */
public class GREEDY_KANPSACK {
	/**
	 * 选择排序
	 * @param args
	 */
	public static void selectSort(float y[],int d[]){
		float temp;
		int t;
		for(int i=1;i<y.length-1;i++){
			int k=i;
			for(int j=i+1;j<y.length;j++){
				if(y[k]<y[j]) k=j;//选择最大的
			}
			if(k!=i){
				temp=y[k];
				y[k]=y[i];
				y[i]=temp;
				t=d[k];
				d[k]=d[i];
				d[i]=t;
			}
		}
	}
	public static void main(String[] args) {
		float s[]={0,18,15,10};
		float v[]={0,25,24,15};
		float x[]=new float[4];
		float y[]=new float[4];
		float Y[]=new float[4];//对y[1..n]按降序地址排序，排序结果返回到数组d[1..n]  //中, 使得Y[d[1]]>=Y[d[2]]>=…>=Y[d[n]]。
		for(int i=1;i<=3;i++){
			y[i]=v[i]/s[i];//求每个物品的平均体积的价值
			Y[i]=v[i]/s[i];
		}
		int d[]=new int[4];
		for(int i=0;i<4;i++){
			d[i]=i;
		}
		selectSort(y,d);
		/*for(int i=1;i<=3;i++){
			System.out.println("y["+i+"]"+y[i]+"  d["+i+"]"+d[i]);
		}*/
		//System.out.println(Y[d[1]]+" "+Y[d[2]]+" "+Y[d[3]]);
		for(int i=0;i<4;i++){
			x[i]=0;
		}
		int i=1;
		float maxv=0f;
		float rc=30;//背包容量
		while(rc>0&&i<=4){
			int j=d[i];
			if(s[j]<rc){
				rc=rc-s[j];
				x[j]=1;
			}else{
				x[j]=rc/s[j];
				rc=0;
			}
			maxv=maxv+v[j]*x[j];
			i=i+1;
		}
		System.out.println(maxv);
		for(int j=1;j<x.length;j++){
			System.out.print(x[j]+" ");
		}
	}

}