package Chapter01;

public class main {
	public static void main(String[] args) {
		Search search=new Search();
		//������������������������
		int a[]={1,3,4,6,7};
		int i=search.linearSearch(a, 4);
		System.out.println(i);
		int j=search.binarySearch(a, 4);
		System.out.println(j);
		Sort sort=new Sort();
		//���򣬺ϲ���������ı���ѡ�����򣬲��������Ե����Ϻϲ�����
		int b[]={2,3,5,8,9,10};
		int c[]=sort.Merge(a, b);
		for (int k : c) {
			System.out.print(k+" ");
		}
		System.out.println();
		int d[]={5,3,1,7,9,0,1,2};
		sort.selectionSort(d);
		for (int k : d) {
			System.out.print(k+" ");
		}

	}
}