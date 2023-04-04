package G4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20033_binarySearch {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] histogram;
	
	public static void main(String[] args) throws IOException {
		N = nextInt();
		
		histogram = new int[N];
		for(int i=0;i<N;i++) {
			histogram[i] = nextInt();
		}
		
		int left = 1;
		int right = N;
		int answer = 0;
		while(left<=right) {
			int middle = (left+right)/2;
			boolean flag = false;
			for(int i=0;i<N;i++) {
				if(histogram[i]<middle)
					continue;
				int count = 0;
				while(i<N && histogram[i]>=middle) {
					count++;
					i++;
				}
				if(count>=middle) {
					flag = true;
					break;
				}
			}
			if(flag) { // 가능한 놈이 있다
				left = middle+1;
				answer = middle;
			} else {
				right = middle-1;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}