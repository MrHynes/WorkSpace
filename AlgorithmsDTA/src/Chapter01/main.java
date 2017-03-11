package Chapter01;

public class main {
	public static void main(String[] args) {
		Search search=new Search();
		//搜索，线性搜索，二分搜索
		int a[]={1,3,4,6,7};
		int i=search.linearSearch(a, 4);
		System.out.println("搜索结果："+i);
		int j=search.binarySearch(a, 4);
		System.out.println("搜索结果："+j);
		Sort sort=new Sort();
		//排序，合并两个排序的表，选择排序，插入排序，自底向上合并排序
		int b[]={2,3,5,8,9,10};
		int c[]=sort.Merge(a, b);
		System.out.println("合并后的数组");
		for (int k : c) {
			System.out.print(k+" ");
		}
		System.out.println();
		int d[]={5,3,1,7,9,0,1,2};
		System.out.println("选择排序后的数组");
		sort.selectionSort(d);
		for (int k : d) {
			System.out.print(k+" ");
		}
		System.out.println();
		int e[]={5,3,1,7,9,0,1,2};
		sort.insertionSort(e);
		System.out.println("插入排序后的数组");
		for (int k : e) {
			System.out.print(k+" ");
		}

	}
}
