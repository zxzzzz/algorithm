import java.util.*;
public class Chap22 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入个数和数组：");
		int l=scanner.nextInt();
		int[] a=new int[l];
		for(int i=0;i<l;i++)
		{		
			a[i]=scanner.nextInt();
		//	System.out.println("a："+a[i]);
		}	
		
		int sum=MaxSum(l,a);
		System.out.println("最大字段和为： "+sum);
	}
	//b[j]=b[j-1]+a[i] ;b[j-1]>0//
	//b[j]=a[i]  b[j-1]<0
	//当b[j]<0时 说明子段该从j+1 处重新开始
	public static int MaxSum(int n,int []a){
		//ArrayList<Object> d=new ArrayList<Object> ();
		int sum=0,b=0;//
		//int count=0;
		for(int i=0;i<n;i++){
			if(b>0){
				b+=a[i];
				System.out.println("b>0:"+b+" a:"+a[i]);
		//		c[count++]=i;
			}
			else {
				b=a[i];
				System.out.println("b<0");
		
			}

			if(b>sum){
				sum=b;
				System.out.println("sum"+sum);
			}
			
				
				
		}
			
		
		
		
		return sum;
		
	}

}
