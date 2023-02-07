//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Main {
//	static Checker[] checkers;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//		checkers = new Checker[N];
//
//		for (int i = 0; i < N; i++) {
//			StringTokenizer tok = new StringTokenizer(br.readLine());
//			checkers[i] = new Checker(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
//		}
//
//		StringBuilder sb = new StringBuilder("0 ");
//
//		
//		// x로 정열해서 x기준 가장 가까운 두개의 movements를 구한다
//		Arrays.sort(checkers, new Comparator<Checker>() {
//			
//			@Override
//			public int compare(Checker o1, Checker o2) {
//				return o1.x - o2.x;
//			}
//		});
//		int centerX = (checkers[0].x+checkers[N-1].x)/2;
//		
//		// y로 정열해서 y기준 가장 가까운 두개의 movements를 구한다
//		Arrays.sort(checkers, new Comparator<Checker>() {
//			
//			@Override
//			public int compare(Checker o1, Checker o2) {
//				return o1.y - o2.y;
//			}
//		});
//		int centerY = (checkers[0].y+checkers[N-1].y)/2;
//		
//		int[] diffs = new int[N];
//		for(int i=0;i<N;i++) {
//			diffs[i] = manh(centerX,checkers[i].x,centerY,checkers[i].y);
//		}
//		Arrays.sort(diffs);
//		
//		for (int numsToMove = 2; numsToMove <= N; numsToMove++) {
//			int movements = 0;
//			
//			for(int i=0;i<numsToMove;i++) {
//				movements+=diffs[i];
//			}
//
//			sb.append(movements).append(" ");
//		}
//
//		System.out.println(sb);
//	}
//	
//	public static int manh(int x1, int x2, int y1, int y2) {
//		return Math.abs(x1-x2)+Math.abs(y1-y2);
//	}
//}
//
//class Checker {
//	int x;
//	int y;
//
//	public Checker(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}