package S5;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//5
//6 3 2 10 -10
//8
//10 9 -5 2 3 4 5 -10

public class p10815_Set {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<N;i++) {
			set.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			if(set.contains(sc.nextInt())) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
}