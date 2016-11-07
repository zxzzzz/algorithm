
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.naming.directory.SearchControls;
//快排
//提高题一：用分治法实现元素选择
public class Chap13 {
	static int SHURU=1;
	static int RANDOMS=2;
	public static	void	main(String[]args){
		System.out.println("选择方式：1--自己输入，2--随机输入,并设置K与数组大小:");
		Scanner scanner1=new Scanner(System.in);
		int choice=scanner1.nextInt();
		int position=scanner1.nextInt();
		int count=scanner1.nextInt();
		int[] b=new int[count];
		if (choice==1) {
			System.out.println("请依次输入K，数组个数，与数组：");
			Scanner scanner=new Scanner(System.in);
			System.out.println("K："+position);
			count=scanner.nextInt();
			System.out.println("数组个数为："+count);
			for(int i=0;i<count;i++){
				b[i]=scanner.nextInt();
		}
			
			
		}else {
			int random;
			
			for(int i=0;i<count;i++){
					random=(int)(Math.random()*150);
					b[i]=random;
			
		}
		
		
		}
		int []x=new int[count];//排序之前的数组
		for(int i=0;i<count;i++){
			//System.out.println(""+b[i]);
			x[i]=b[i]; 
			
			System.out.println(""+x[i]);
		}
		quickSort(b, 0, count-1);
		for(int i=0;i<count;i++){
			System.out.println(""+b[i]);
		}
		for(int j=0;j<count;j++){
		//	System.out.println(b[j]);
			if (b[position-1]==x[j]) {
				System.out.println("下标为："+j);
				System.out.println("值为："+b[position-1]);
				
			}
			
		}
	}
	
	public static void  quickSort(int a[] ,int p,int r){
		if (p<r) {
			int q=partition(a,p,r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);	
		}
		
	}
	public static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int i=p;
		int j=r+1;
		int x=a[p];
		while(true){
			while (a[++i]<x&&i<r);
			while(a[--j]>x);
			if (i>=j) {
				break;
			}
			int t=0;
			t=a[j];
			a[j]=a[i];
			a[i]=t;
			}
		a[p]=a[j];
		a[j]=x;
		return j;
	}

}
