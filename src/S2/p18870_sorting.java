package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p18870_sorting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point18870> points = new PriorityQueue<>();
		tok = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			points.add(new Point18870(i, Integer.parseInt(tok.nextToken())));
		}
		
		int count = 0;
		int before = points.peek().size;
		int[] answer = new int[N];
		while(!points.isEmpty()) {
			Point18870 point = points.poll();
			if(point.size>before) {
				count++;
			}
			
			answer[point.idx]= count; 
			before = point.size;
		}
		
		for(int n:answer) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

class Point18870 implements Comparable<Point18870>{
	int idx;
	int size;
	
	public Point18870(int idx,int size) {
		this.idx = idx;
		this.size = size;
	}

	@Override
	public int compareTo(Point18870 o) {
		// TODO Auto-generated method stub
		return this.size-o.size;
	}
}