package G4;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p2239_backTracking {
	static Set<Integer>[] rows = new Set[10];
	static Set<Integer>[] cols = new Set[10];
	static Set<Integer>[] boxes = new Set[10];
	static List<Point> zeros = new ArrayList<>();

	static int[][] board = new int[9][9];
	
	static boolean found;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String row = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = row.charAt(j) - '0';
				if (board[i][j] == 0) {
					zeros.add(new Point(i, j));
					continue;
				}
				rows[i].add(board[i][j]);
				cols[j].add(board[i][j]);
				boxes[getBox(i, j)].add(board[i][j]);
			}
		}

		run(0);

	}

	public static void run(int idx) {
		if(found) {
			return;
		}
		
		if (idx == zeros.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[0].length;j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
			found = true;
			return;
		}

		int row = zeros.get(idx).x;
		int col = zeros.get(idx).y;
		int box = getBox(row,col);

		for (int num = 1; num <= 9; num++) {
			if (rows[row].contains(num) || cols[col].contains(num) || boxes[box].contains(num))
				continue;

			rows[row].add(num);
			cols[col].add(num);
			boxes[box].add(num);
			board[row][col] = num;
			run(idx + 1);
			rows[row].remove(num);
			cols[col].remove(num);
			boxes[box].remove(num);
		}
	}

	public static int getBox(int row, int col) {
		return (row / 3)*3 + col / 3;
	}
}
