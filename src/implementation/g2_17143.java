package implementation;

import java.io.*;
import java.util.*;

public class g2_17143 {

	static int R, C, M, fisher = 0, total = 0;
	static List<Shark> sharks;
	static Shark[][] map;
	
	static char n = 'A';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());

		R = Integer.parseInt(tok.nextToken());
		C = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());

		sharks = new ArrayList<>();
		map = new Shark[R][C];

		int minIndex = -1;

		for (int m = 0; m < M; m++) {
			tok = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(tok.nextToken()) - 1;
			int c = Integer.parseInt(tok.nextToken()) - 1;
			int s = Integer.parseInt(tok.nextToken());
			int d = Integer.parseInt(tok.nextToken());
			int z = Integer.parseInt(tok.nextToken());

			Shark newShark = new Shark(r, c, s, d, z, n++);

			sharks.add(newShark);

			if (newShark.col == fisher) {
				if (minIndex == -1)
					minIndex = m;
				else if (sharks.get(minIndex).row > newShark.row)
					minIndex = m;
			}
		}

		while (fisher < C) {
			System.out.println("FISHER: " + fisher);
			System.out.println("TOTAL: " + total);

			for (int i = 0; i < sharks.size(); i++) {
				if (i == minIndex)
					System.out.print("*");
				System.out.println(sharks.get(i));
			}
			System.out.println("=====================");

			if (minIndex != -1) {
				total += sharks.get(minIndex).size;
				sharks.remove(minIndex);
			}

			minIndex = -1;
			for (int i = 0; i < sharks.size(); i++) {
				sharks.get(i).move(R, C);

				for (int j = 0; j < i; j++) {
					if (sharks.get(i).row == sharks.get(j).row && sharks.get(i).col == sharks.get(j).col) {
						if (sharks.get(i).size > sharks.get(j).size) {
//							System.out.printf("Shark %c eats Shark %c\n", sharks.get(i).name, sharks.get(j).name);
							sharks.remove(j);
						}
						else {
//							System.out.printf("Shark %c eats Shark %c\n", sharks.get(j).name, sharks.get(i).name);
							sharks.remove(i);
						}
						i--;
					}
				}

				if (sharks.get(i).col == fisher + 1) {
					if (minIndex == -1)
						minIndex = i;

					else if (sharks.get(minIndex).row > sharks.get(i).row)
						minIndex = i;
				}
			}
			fisher++;
		}

		System.out.println(total);
	}

}

//d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
class Shark {
	int row;
	int col;
	int speed;
	int dir;
	int size;
	
	char name;

	public Shark(int r, int c, int s, int d, int z, char n) {
		row = r;
		col = c;
		speed = s;
		dir = d;
		size = z;
		
		name = n;
	}

	public void move(int R, int C) {
		for (int i = 0; i < speed; i++) {
			switch (dir) {
			case 1:
				if (row - 1 < 0) {
					dir = 2;
					i--;
				} else
					row--;
				break;
			case 2:
				if (row + 1 >= R) {
					dir = 1;
					i--;
				} else
					row++;
				break;
			case 3:
				if (col + 1 >= C) {
					dir = 4;
					i--;
				} else
					col++;
				break;
			default:
				if (col - 1 < 0) {
					dir = 3;
					i--;
				} else
					col--;
				break;
			}
		}
	}

	public String toString() {
		return name+"<ROW: " + row + "/COL: " + col + "/SIZE: " + size + "/DIR: " + dir + "/SPEED: " + speed + ">";
	}
}
