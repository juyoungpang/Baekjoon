package S3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13702_binarySearch {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K;
	static int[] drinks;

	public static void main(String[] args) throws IOException {
		N = nextInt();
		K = nextInt();
		
		drinks = new int[N];
		for(int i=0;i<N;i++) {
			drinks[i] = nextInt();
		}

		System.out.println(binarySearch());
	}
	
	public static int binarySearch() {
		long left = 0;
		long right = Integer.MAX_VALUE;
		int ret = 0;
		
		while(left<=right) {
			int mid = (int)((left+right)/2);
			if(calc(mid)) {
				ret = mid;
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		return ret;
	}
	
	public static boolean calc(int amount) {
		if(amount==0)
			return false;
		
		int ret = 0;
		for(int d:drinks) {
			ret+=d/amount;
		}
		return ret>=K;
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}