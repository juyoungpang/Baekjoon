package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10819_bruteForce {

    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        permu(new int[N], new boolean[N], 0);

        System.out.println(max);
    }

    public static void permu(int[] output, boolean[] visited, int depth) {
        if(depth==N) {
            max = Math.max(max, calculate(output));
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permu(output, visited, depth+1);
                visited[i] = false;
            }
        }
    }

    public static int calculate(int[] a) {
        int ret = 0;
        for(int i=0;i<N-1;i++) {
            int temp = Math.abs(a[i]-a[i+1]);
            ret+=temp;
        }
        return ret;
    }
}
