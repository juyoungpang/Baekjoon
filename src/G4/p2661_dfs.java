package G4;
import java.util.Scanner;

public class p2661_dfs {
	static int N;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dfs(0,"");

	}

	public static void dfs(int depth, String num) {
		if (flag)
			return;

		if (depth == N) {
			System.out.println(num);
			flag = true;
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(possible(num+i)) {
				dfs(depth+1, num+i);
			}
		}
	}
	
	public static boolean possible(String num) {
		for(int i=1;i<=num.length()/2;i++) {
			if(num.substring(num.length()-i).equals(num.substring(num.length()-2*i,num.length()-i))) {
				return false;
			}
		}
		
		return true;
	}
}