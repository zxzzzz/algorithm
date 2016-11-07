
import java.util.*;
//基本题2：二分搜索
//查找X的位置并输出，如果没有则输出比X大和小的两个数字的位置
public class Chap1{
	static int max;
	static int min;
	public static void main(String[] args){
		System.out.println("请依次输入数组个数，要比较的数，与数组：");
		Scanner scanner=new Scanner(System.in);
		int x=scanner.nextInt();
		System.out.println("数组个数为："+x);
		int y=scanner.nextInt();
		System.out.println("要比较的数为："+y);
		int[] b=new int[x];
		System.out.println("数组为：");
		for(int i=0;i<x;i++){
			b[i]=scanner.nextInt();
		//	System.out.print(b[i]);
			}
		for(int j=0;j<x;j++)
			System.out.println(""+b[j]);
		boolean findIt=search(b, y);
		if(findIt){
			System.out.println("输出X的下标："+""+max);
}
		else {
			System.out.println("输出大于和小于的坐标： "+max+"    "+min);
			System.out.println("值分别为："+b[max]+"  "+b[min]);
}
}
	public static boolean search(int[] a,int x) {
		int left =0;
		int n=a.length;
		int right=n-1;
		boolean find=false;
		int middle=0;
		while(left<=right){
			middle=(int)(right+left)/2;
			if(x==a[middle]){
				System.out.println("相等");
				max=min=middle;
				find=true;
				break;
}
			
			else if(x<a[middle]){
				System.out.println("小于");
				right=middle-1;}
			else if(x>a[middle]){
				System.out.println("大于");
				left=middle+1;
}
					
}
	if(!find){
		System.out.println("没找到");
		max=right;
		min=left;
		return false;
}else {
		return true;
}

}
}
