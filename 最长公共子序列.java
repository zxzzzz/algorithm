import java.util.*;
//实验二 动态规划 基本题一
//最长公共子序列  严格递增下标
public class Chap21 {
	static StringBuilder builder=new StringBuilder();
	static String longest;
	public static void main(String []args){
		System.out.println("请输入两个数组:");
		Scanner scanner=new Scanner(System.in);
		String ss=scanner.next();
		//System.out.println("ss:"+ss);
		int length=ss.length();
		char[] a =new char[length];
		for(int i=0;i<length;i++){
			a[i]=ss.charAt(i);
			//System.out.println("a:"+a[i]);
		}
		String kk=scanner.next();
	//	System.out.println("kk:"+kk);
		int length2=kk.length();
		//System.out.println("length2:"+length2);
		char[] b =new char[length2];
		for(int i=0;i<length2;i++){
			b[i]=kk.charAt(i);
			//System.out.println("b:"+b[i]);
		}
		int [][]c=new int[length][length2];
		int [][] record=new int[length][length2];
		LCSLength(a,b,length,length2,c,record);
		longest=LCS(length-1,length2-1,a,record);
		System.out.println("最长公共子序列为：" +longest);
	}
		 
		static public void LCSLength(char x[],char y[],int n,int m,int[][]c ,int[][]b){
			 for(int i=0;i<n;i++){
			c[i][0]=0;
			}
		for(int j=0;j<m;j++)
			c[0][j]=0;
		for(int i=1;i<n;i++){
		for(int j=1;j<m;j++){
				//2.当 x[i]=y[j]时，c[i][j]=c[i-1][j-1]+1;
				if(x[i]==y[j]){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
		//			System.out.println("x:"+x[i]+"y:"+y[j]+"i:"+i+" j:"+j +"b:"+b[i][j]+"");
				}
				//3 c[i][j]=max{c[i-1][j],c[i][j-1]},当 x[i]!=x[j]
				else if(c[i-1][j]>c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;
			//		System.out.println("x:"+x[i]+"y:"+y[j]+"i:"+i+" j:"+j +"b:"+b[i][j]+"");
					
				}
				else{
					c[i][j]=c[i][j-1];
					b[i][j]=3;
				//	System.out.println("x:"+x[i]+"y:"+y[j]+"i:"+i+" j:"+j +"b:"+b[i][j]+"");
					
				}
			}
		}
		
		}
	
	//
	static public String LCS(int i,int j,char[] x,int[][] b){
		if(i==0||j==0)
			return null;
		if(b[i][j]==1){
			LCS(i-1,j-1,x,b);
			String m=String.valueOf(x[i]);
			builder.append(m);
	//		System.out.println(m);
			//
		}else if(b[i][j]==2){
			LCS(i-1,j,x,b);
		}else{
			LCS(i,j-1,x,b);
			
	}
		
		return builder.toString();
	}

}
