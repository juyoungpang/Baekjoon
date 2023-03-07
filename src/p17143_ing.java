import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p17143_ing {

	static class Shark {
		int row;
		int col;
		int speed;
		int dir;
		int size;

		public Shark(int row, int col, int speed, int dir, int size) {
			super();
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [row=" + row + ", col=" + col + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static List<Shark> sharks = new ArrayList<>();
	static Shark[][] map;
	static int R, C, answer;

	public static void main(String[] args) {

	}

	public static int nextInt() throws IOException {
		if(st==null||!st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}