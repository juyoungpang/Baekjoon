package implementation;

import java.util.*;
import java.io.*;

public class g2_12100 {
	
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0;i<map.length;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int j=0;j<map[0].length;j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
//		run(new Board(map),0);
		
		Board board = new Board(map);
		board.right();
		System.out.println(board.print());
		
//		System.out.println(max);
	}
	
	public static void run(Board b, int level) {
		if(level==1||level==2) System.out.println("=====================\nLevel: "+level);
		if(level==1||level==2) System.out.println(b.print());
		
		if(level<5) {
			for(int i=0;i<4;i++) {
				Board tempBoard = new Board(b.map, b.max);
				if(i==0) {
					tempBoard.up();
					run(tempBoard,level+1);
				}
				else if(i==1) {
					tempBoard.down();
					run(tempBoard,level+1);
				}
				else if(i==2) {
					tempBoard.left();
					run(tempBoard,level+1);
				}
				else {
					tempBoard.right();
					run(tempBoard,level+1);
				}
			}
		} else {
			if(b.max>max) max = b.max;
		}
	}
	
	public static class Board{
		static int[][] map;
		static int max;
		
		public Board(int[][] map) {
			this.map = map;
			max = -1;
			
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					if(map[i][j]>max) max = map[i][j];
				}
			}
		}
		
		public Board(int[][] map, int max) {
			this.map = map;
			this.max = max;
		}
		
		public static void up() {
//			System.out.println("up");
			for(int c=0;c<map[0].length;c++) {
				int val = map[0][c];
				int row = 0;
				for(int r=1;r<map.length;r++) {
					if(map[r][c]!=0) {
						if(val == 0) {
							map[row][c] = map[r][c];
							map[r][c] = 0;
							row++;
							
						} else if (val == map[r][c]) {
							map[row][c] *= 2;
							map[r][c] = 0;
							row++;
						} else {
							row++;
							map[row][c] = map[r][c];
							if(row!=r) map[r][c] = 0;
						}
						val = map[row][c];
						if(val>max) max = val;
					}
				}
			}

//			System.out.println(print());
		}
		
		public static void left() {
//			System.out.println("left");
			for(int r=0;r<map.length;r++) {
				int val = map[r][0];
				int col = 0;
				for(int c=1;c<map.length;c++) {
					if(map[r][c]!=0) {
						if(val == 0) {
							map[r][col] = map[r][c];
							map[r][c] = 0;
							col++;
						} else if (val == map[r][c]) {
							map[r][col] *= 2;
							map[r][c] = 0;
							col++;
						} else {
							col++;
							map[r][col] = map[r][c];
							if(col!=c) map[r][c] = 0;
						}
						val = map[r][col];
						if(val>max) max = val;
					}
				}
			}

//			System.out.println(print());
		}
		
		public static void down() {
//			System.out.println("down");
			for(int c=0;c<map[0].length;c++) {
				int val = map[map.length-1][c];
				int row = map.length-1;
				for(int r=map.length-2;r>=0;r--) {
					if(map[r][c]!=0) {
						if(val == 0) {
							map[row][c] = map[r][c];
							map[r][c] = 0;
							row--;
						} else if (val == map[r][c]) {
							map[row][c] *= 2;
							map[r][c] = 0;
							row--;
						} else {
							row--;
							map[row][c] = map[r][c];
							if(row!=r) map[r][c] = 0;
						}
						val = map[row][c];
						if(val>max) max = val;
					}
				}
			}

//			System.out.println(print());
		}
			
		public static void right() {
//			System.out.println("right");
			for(int r=0;r<map.length;r++) {
				int val = map[r][map[0].length-1];
				int col = map[0].length-1;
				for(int c=map[0].length-2;c>=0;c--) {
					if(map[r][c]!=0) {
						if(val == 0) {
							map[r][col] = map[r][c];
							map[r][c] = 0;
							col--;
						} else if (val == map[r][c]) {
							map[r][col] *= 2;
							map[r][c] = 0;
							col--;
						} else {
							col--;
							map[r][col] = map[r][c];
							if(col!=c) map[r][c] = 0;
						}
						val = map[r][col];
						if(val>max) max = val;
					}
				}
			}

//			System.out.println(print());
		}
		
		public static String print() {
			StringBuilder sb = new StringBuilder();
			sb.append("MAX: ").append(max).append("\n");
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}

}
