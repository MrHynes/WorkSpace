package Chapter01;

public class Sort {
	//�ϲ�������������
	public int[] Merge(int a[],int b[]){
		int i=0,j=0,k=0;
		int c[]=new int[a.length+b.length];
		while(i<a.length&&j<b.length){
			if(a[i]<b[j]){
				c[k]=a[i];
				i++;
				k++;
			}
			else{
				c[k]=b[j];
				k++;
				j++;
			}
		}
		//��ʣ�µ�ȫ�����뵽����c��
		if(i==a.length){
			for(;j<b.length;j++){
				c[k]=b[j];
				k++;
			}
		}else{
			for(;i<a.length;i++){
				c[k]=a[i];
				k++;
			}
		}
		return c;
	}
	//ѡ������
	public int[] selectionSort(int a[]){
		int k,temp,i;
		for(i=0;i<a.length-1;i++){
			k=i;
			for(int j=i+1;j<a.length;j++){//ѡ����С��Ԫ��
				if(a[k]>a[j]) k=j;//k����СԪ�ص��±�
			}
			if(k!=i){//��СԪ�غ���ǰ���Ԫ�ؽ���
				temp=a[i];
				a[i]=a[k];
				a[k]=temp;
			}
		}
		return a;
	}
	//��������
	public int[] insertionSort(int a[]){
		return null;
	}
	
}