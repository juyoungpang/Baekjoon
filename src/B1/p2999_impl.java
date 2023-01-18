package B1;
import java.util.Scanner;

public class p2999_impl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int R = 0;
		int C = 0;
		for(int i=(int)Math.sqrt(str.length());i>=1;i--) {
			if(str.length()%i==0) {
				R=i;
				C=str.length()/i;
				break;
			}
		}
		
		char[][] board = new char[R][C];
		
		int idx = 0;
		for(int c=0;c<C;c++) {
			for(int r=0;r<R;r++) {
				board[r][c] = str.charAt(idx++);
			}
		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				System.out.print(board[r][c]);
			}
		}
		
	}
}