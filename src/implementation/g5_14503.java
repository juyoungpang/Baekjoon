package implementation;

import java.util.*;
import java.io.*;

public class g5_14503 {

	static int N, M, initRow, initCol, initD, count;
	static int[][] map;
	static Robot robot;

	static final int NORTH = 0;
	static final int EAST = 1;
	static final int SOUTH = 2;
	static final int WEST = 3;

	static final int WALL = 1;
	static final int NOTCLEANED = 0;
	static final int CLEANED = -1;
	
	static final int FORWARD = -1;
	static final int BACKWARD = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		tok = new StringTokenizer(br.readLine());
		initRow = Integer.parseInt(tok.nextToken());
		initCol = Integer.parseInt(tok.nextToken());
		initD = Integer.parseInt(tok.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		/*----입력 란----*/

		robot = new Robot(initRow,initCol,initD);
		map[initRow][initCol] = CLEANED;
		count = 1;
		
//		System.out.println(arrayToString(map));
		
		simulate();
		
//		System.out.println(arrayToString(map));
		
		System.out.println(count);
		
		br.close();
	}
	
	public static String arrayToString(int[][] map) {
		String ret = "";
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(i == robot.r && j == robot.c) {
					if(robot.d==0) ret+="^ ";
					else if(robot.d==1) ret+="> ";
					else if(robot.d==2) ret+="V ";
					else ret+="< ";
				}
				else {
					if(map[i][j]==-1) ret+="C ";
					else ret+=map[i][j]+" ";
				}
			}
			ret+="\n";
		}
		return ret;
	}
	
	public static void simulate() {
		for(int i=0;i<4;i++) {
			if(robot.onLeft()==NOTCLEANED) {
				robot.rotate();
				robot.step(FORWARD);
				map[robot.r][robot.c]= CLEANED; 
				count++;
				i=-1;
			} else {
				robot.rotate();
			}
//			System.out.println(arrayToString(map));
		}
		
		robot.rotate();
		if(robot.onLeft()==WALL) {
			for(int i=0;i<3;i++) robot.rotate();
		} else {
			for(int i=0;i<3;i++) robot.rotate();
			robot.step(BACKWARD);
			simulate();
		}
	}
	

	public static class Robot {
		int r;
		int c;
		int d;

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public void rotate() {
			d = (d+3)%4;
		}

		//forward면 -1, backward면 +1
		public void step(int s) {
			switch (d) {
			case NORTH:
				r+=s;
				break;
			case WEST:
				c+=s;
				break;
			case SOUTH:
				r-=s;
				break;
			default:
				c-=s;
				break;
			}
		}
		
		public int onLeft() {
			switch (d) {
			case NORTH:
				return map[r][c-1];
			case WEST:
				return map[r+1][c];
			case SOUTH:
				return map[r][c+1];
			default:
				return map[r-1][c];
			}
		}
	}
}
