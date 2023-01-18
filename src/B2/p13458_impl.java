package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13458_impl {
    public static int N, B, C, A[];
    public static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(tok.nextToken());
        }

        tok = new StringTokenizer(br.readLine());
        B = Integer.parseInt(tok.nextToken());
        C = Integer.parseInt(tok.nextToken());

        ans = N;
        for(int num:A) {
            int temp = num-B;
            if(temp>0) {
                ans += temp / C;
                if (temp % C != 0) ans++;
            }
        }

        System.out.println(ans);
    }
}
