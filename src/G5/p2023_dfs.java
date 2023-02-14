package G5;
import java.util.Scanner;

public class p2023_dfs {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dfs(0,0);
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int num) {
		if(depth==N) {
			sb.append(num).append("\n");
			return;
		}
		
		for(int i=0;i<10;i++) {
			int newNum = num*10+i;
			if(isPrime(newNum)) {
				dfs(depth+1, newNum);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num==0 || num==1) 
			return false;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
}