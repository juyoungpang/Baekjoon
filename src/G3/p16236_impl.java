package G3;

import java.util.*;
import java.io.*;

public class p16236_impl {

	static int N, sharkSize, smallerThanShark, sharkAte = 0, time = 0;
	static Point shark;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Point> pq = new PriorityQueue<>();

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
				if (map[i][j] == 9) {
					shark = new Point(i, j, 0);
					sharkSize = 2;
				}
				if (map[i][j] == 1)
					smallerThanShark++;
			}
		}

		while (true) {
			visited = new boolean[N][N];
			pq.clear();
			bfs(shark);
			if(pq.isEmpty()) break;
			
			Point eaten = pq.poll();
			sharkAte++;
			map[shark.r][shark.c] = 0; 
			shark.r = eaten.r;
			shark.c = eaten.c;
			map[shark.r][shark.c] = 9;
			time += eaten.dist;
			if (sharkSize == sharkAte) {
				sharkAte = 0;
				sharkSize++;
			}
//			print();
		}
		
		System.out.println(time);
	}

	public static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(p);
		visited[p.r][p.c] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				int nextD = cur.dist + 1;

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || visited[nextR][nextC]
						|| map[nextR][nextC] > sharkSize) {
					continue;
				}

				if (map[nextR][nextC]!=0 && map[nextR][nextC] < sharkSize) {
					pq.add(new Point(nextR, nextC, nextD));
				}

				queue.add(new Point(nextR, nextC, nextD));
				visited[nextR][nextC] = true;
			}
		}
	}
	
	public static void print() {
		System.out.println("Size: "+sharkSize);
		System.out.println("Time: "+time);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("===========");
	}
}

class Point implements Comparable{
	int r;
	int c;
	int dist;

	public Point(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}

	@Override
	public int compareTo(Object o) {
		Point temp = (Point) o;
		if(this.dist>temp.dist) return 1;
		else if(this.dist<temp.dist) return -1;
		else {
			if(this.r>temp.r) return 1;
			else if(this.r<temp.r) return -1;
			else {
				if(this.c>temp.c) return 1;
				else return -1;
			}
		}
	}
	
	
}