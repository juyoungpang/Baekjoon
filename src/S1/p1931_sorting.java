package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1931_sorting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;

		PriorityQueue<Schedule> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			tok = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(tok.nextToken());
			int end = Integer.parseInt(tok.nextToken());
			pq.add(new Schedule(start, end));
		}

		int answer = 1;
		int temp = pq.poll().end;
		while (!pq.isEmpty()) {
			Schedule s = pq.poll();
			if (s.start >= temp) {
				temp = s.end;
				answer++;
			}
		}

		System.out.println(answer);
	}
}

class Schedule implements Comparable<Schedule> {
	int start;
	int end;

	public Schedule(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Schedule o) {
		if (this.end != o.end) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}

}