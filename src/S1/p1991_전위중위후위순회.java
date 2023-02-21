package S1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1991_전위중위후위순회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;	
	static StringBuilder pre = new StringBuilder();
	static StringBuilder mid = new StringBuilder();
	static StringBuilder post = new StringBuilder();
	
	static int[][] tree;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		tree = new int[N][2];
		
		for(int n=0;n<N;n++) {
			tok = new StringTokenizer(br.readLine());
			int idx = tok.nextToken().charAt(0) - 'A';
			int left = tok.nextToken().charAt(0);
			int right = tok.nextToken().charAt(0);
			
			if(left!='.') {
				tree[idx][0] = left-'A';
			} else {
				tree[idx][0] = -1;
			}
			
			if(right!='.') {
				tree[idx][1] = right-'A';
			} else {
				tree[idx][1] = -1;
			}
		}
		
		dfs(0);
		
		System.out.println(pre.append('\n').append(mid).append('\n').append(post));
		
	}
	
	public static void dfs(int cur) {
		pre.append((char)(cur+'A'));
		if(tree[cur][0]==-1 && tree[cur][1]==-1) { // 만약 현재 보고있는 node가 leaf노드라면
			mid.append((char)(cur+'A'));
			post.append((char)(cur+'A'));
			return;
		}
		
		if(tree[cur][0]!=-1) {
			dfs(tree[cur][0]);
		}
		mid.append((char)(cur+'A'));
		if(tree[cur][1]!=-1) {
			dfs(tree[cur][1]);
		}
		post.append((char)(cur+'A'));
	}
}