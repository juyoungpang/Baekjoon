import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<Integer>[] rows = new Set[9];
	static Set<Integer>[] cols = new Set[9];
	static Set<Integer>[] box = new Set[9];
	
	static int[][] board = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<10;i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			box[i] = new HashSet<>();
		}
		
		int startR = -1;
		int startC = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			String row = br.readLine();
			for(int j=0;j<9;j++) {
				board[i][j] = row.charAt(j)-'0';
				rows[i].add(board[i][j]);
				cols[j].add(board[i][j]);
				box[getBox(i,j)].add(board[i][j]);
				
				if(startR==-1 && board[i][j]==0) {
					startR = i;
					startC = j;
				}
			}
		}
		
		run(startR, startC);
		
		
	}
	
	public static void run(int row, int col) {
		
	}
	
	public static int getBox(int row, int col) {
		return row/3+col/3;
	}
}
