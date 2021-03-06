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
		int h[]={1,5,7,8,2,3,6,9};
		sort.Merge(h, 0, 3, h.length-1);
		System.out.println();
		System.out.println("合并2后的数组");
		for (int k : h) {
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
		int e[]={5,2,1,3,9,0,1,2};
		sort.insertionSort(e);
		System.out.println("插入排序后的数组");
		for (int k : e) {
			System.out.print(k+" ");
		}
		System.out.println();
		int f[]={0,3,5,7,12,0,1,2};
		sort.bubbleSort(f);
		System.out.println("冒泡排序后的数组");
		for (int k : f) {
			System.out.print(k+" ");
		}
		System.out.println();
		int g[]={9,3,5,7,12,4,1,2};
		sort.quickSort(g, 0, g.length-1);
		System.out.println("快速排序后的数组");
		for (int k : g) {
			System.out.print(k+" ");
		}
		
		int m[]={1,4,2,5,0,3,7,6};
		sort.mergeSort(m, 0, m.length-1);
		System.out.println("\n自顶向下合并排序后的数组");
		for (int k : m) {
			System.out.print(k+" ");
		}
		
		int n[]={1,0,6,5,11,3,7,4};
		sort.bottomupSort(n);
		System.out.println("\n自底向上合并排序后的数组");
		for (int k : n) {
			System.out.print(k+" ");
		}
	
	}
}
