package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11047_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());

        int arr[] = new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int curr = N-1;
        while (K!=0) {
            if(arr[curr]<=K) {
                K-=arr[curr];
                count++;
            }
            else {
                curr--;
            }
        }

        System.out.println(count);
    }
}
