

import java.util.Scanner;
//基本题2：二分搜索第2题
public class Chap12 {
	public static void main(String[] args){
		System.out.println("请依次输入下标，数组个数，与数组：");
		Scanner scanner=new Scanner(System.in);
		int position=scanner.nextInt();
		System.out.println("下标为："+position);
		int count=scanner.nextInt();
		System.out.println("数组个数为："+count);
		int[] b=new int[count];
		int c=0;
		//为什么hasNextInt()不起作用？？一直不往下执行
		
		for(int i=0;i<b.length;i++){
			b[c++]=scanner.nextInt();
			 
	}
		System.out.println("数组为：");
		for (int i = 0; i < count; i++) {
			System.out.println(b[i]);
}
		run(b, position);
		

	}
	public static int run(int[] a,int i){
		int left=0;
		int right=a.length-1;
		int middle=0;
		while(left<=right){
			middle=(int)(right+left)/2;
			if (a[middle]==i) {
				System.out.println("相等的下标为："+middle);
				return middle;
			}
			else if (a[middle]>i) {
				System.out.println("下标过小");
				right=middle-1;
				
			} else if (a[middle]<i) {
				System.out.println("下标过大");
				left=middle+1;
				
			} {
				
			}
		}
		System.out.println("没找到");
		return 0;
		
		
	}

}
