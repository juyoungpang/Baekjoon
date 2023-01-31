package S2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2304_bruteForce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Pole> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(tok.nextToken());
			int height = Integer.parseInt(tok.nextToken());
			pq.add(new Pole(position, height));
		}
		
		int center=-1;
		int left=-1;
		int right=-1;
		
		int area = 0;
			
		while(!pq.isEmpty()) {
			Pole pole = pq.poll();
			if(center==-1) { // 첫번째 기등
				center = left = right = pole.position;
				area = pole.height;
				continue;
			}
			
			if(pole.position < center) { // 가운데 기둥의 왼쪽
				if(pole.position < left) { // 지금까지 나온 기둥 중 가장 왼쪽
					area += (left-pole.position)*pole.height;
					left = pole.position;
				} else { // 지금까지 나온 기둥들 보다 오른쪽
					continue;
				}
			} else {
				if(pole.position > right) {
					area += (pole.position-right)*pole.height;
					right = pole.position;
				} else {
					continue;
				}
			}
		}
		
		System.out.println(area);
		
		br.close();
	}
}

class Pole implements Comparable<Pole> {
	int position;
	int height;

	public Pole(int position, int height) {
		this.position = position;
		this.height = height;
	}

	@Override
	public int compareTo(Pole o) {
		// TODO Auto-generated method stub
		return o.height - this.height;
	}
}