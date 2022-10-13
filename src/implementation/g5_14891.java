package implementation;

import java.util.*;
import java.io.*;

public class  g5_14891{

	public static int[][] gears;
	public static int[] tops;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gears = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String t = br.readLine();
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(t.substring(j, j + 1));
			}
		}
		
		tops = new int[4];
		
		int actions = Integer.parseInt(br.readLine());
		for (int a = 0; a < actions; a++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			simulate(Integer.parseInt(tok.nextToken()) - 1, Integer.parseInt(tok.nextToken()));
		}

		int score = 0;

		for (int i = 0; i < 4; i++) {
			score += Math.pow(2, i) * gears[i][tops[i]];
		}

		System.out.println(score);
	}

	public static void simulate(int gear, int clockwise) {

		boolean[] gearAndNextEqual = new boolean[3];
		for (int i = 0; i < 3; i++) {
			gearAndNextEqual[i] = getRightVal(i) == getLeftVal(i+1);
		}

		int[] hasTurned = new int[4];
		hasTurned[gear] = clockwise;

		tops[gear] = turn(tops[gear], clockwise);

		for (int i = gear + 1; i < 4; i++) {
			if (!gearAndNextEqual[i - 1]) {
				tops[i] = turn(tops[i], hasTurned[i - 1] * -1);
				hasTurned[i] = hasTurned[i-1]*-1;
			}
		}

		for (int i = gear - 1; i >= 0; i--) {
			if (!gearAndNextEqual[i]) {
				tops[i] = turn(tops[i], hasTurned[i + 1] * -1);
				hasTurned[i] = hasTurned[i+1]*-1;
			}
		}
	}
	
	public static int turn(int top, int clockwise) {
		if(clockwise == 0) return top;
		
		if (clockwise == 1)
			top--;
		else
			top++;

		if (top == -1)
			top = 7;
		else if (top == 8)
			top = 0;
		
		return top;
	}
	
	public static int getLeftVal(int gear) {
		int top = tops[gear];
		
		if (top == 0)
			return gears[gear][6];
		else if (top == 1)
			return gears[gear][7];

		return gears[gear][top - 2];
	}

	public static int getRightVal(int gear) {
		int top = tops[gear];
		
		if (top == 6)
			return gears[gear][0];
		else if (top == 7)
			return gears[gear][1];

		return gears[gear][top + 2];
	}
}