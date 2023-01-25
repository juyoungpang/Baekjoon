package B1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10163_bruteForce {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N+1];
				
		for(int n=1;n<=N;n++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			int h = Integer.parseInt(input[3]);
			
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					nums[board[x+i][y+j]]--;
					board[x+i][y+j]=n;
					nums[n]++;
				}
			}
		}
		
		for(int n=1;n<=N;n++) {
			System.out.println(nums[n]);
		}
	}
}