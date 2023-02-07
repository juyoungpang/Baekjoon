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
//		for (int numsToMove = 2; numsToMove <= N; numsToMove++) {
//			int movements = 0;
//
//			// x로 정열해서 x기준 가장 가까운 두개의 movements를 구한다
//			Arrays.sort(checkers, new Comparator<Checker>() {
//
//				@Override
//				public int compare(Checker o1, Checker o2) {
//					return o1.x - o2.x;
//				}
//			});
//			int diffX = Integer.MAX_VALUE;
//			int ix1 = -1, ix2 = -1;
//			for (int i = 0; i < N - (numsToMove - 1); i++) {
//				int diff = Math.abs(checkers[i + (numsToMove - 1)].x - checkers[i].x);
//				if (diff < diffX) {
//					ix1 = i;
//					ix2 = i + (numsToMove - 1);
//					diffX = diff;
//				}
//			}
//			int totalX = manh(checkers[ix1].x,checkers[ix2].x,checkers[ix1].y,checkers[ix2].y);
//
//			// y로 정열해서 y기준 가장 가까운 두개의 movements를 구한다
//			Arrays.sort(checkers, new Comparator<Checker>() {
//
//				@Override
//				public int compare(Checker o1, Checker o2) {
//					return o1.y - o2.y;
//				}
//			});
//			int diffY = Integer.MAX_VALUE;
//			int iy1 = -1, iy2 = -1;
//			for (int i = 0; i < N - (numsToMove - 1); i++) {
//				int diff = Math.abs(checkers[i + (numsToMove - 1)].y - checkers[i].y);
//				if (diff < diffY) {
//					iy1 = i;
//					iy2 = i + (numsToMove - 1);
//					diffY = diff;
//				}
//			}			
//			int totalY = manh(checkers[iy1].x,checkers[iy2].x,checkers[iy1].y,checkers[iy2].y);
//			
//			if(totalX<=totalY) {
//				int centerX = (int)Math.ceil((double)(checkers[iy1].x+checkers[iy2].x)/2.0);
//				int centerY = (int)Math.ceil((double)(checkers[iy1].y+checkers[iy2].y)/2.0);
//				
//				for(int j=iy1;j<=iy2;j++) {
//					movements+=manh(checkers[j].x,centerX,checkers[j].y,centerY);
//				}
//			} else {
//				Arrays.sort(checkers, new Comparator<Checker>() {
//
//					@Override
//					public int compare(Checker o1, Checker o2) {
//						return o1.x - o2.x;
//					}
//				});
//
//				int centerX = (int)Math.ceil((double)(checkers[ix1].x+checkers[ix2].x)/2.0);
//				int centerY = (int)Math.ceil((double)(checkers[ix1].y+checkers[ix2].y)/2.0);
//				
//				for(int j=ix1;j<=ix2;j++) {
//					movements+=manh(checkers[j].x,centerX,checkers[j].y,centerY);
//				}
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