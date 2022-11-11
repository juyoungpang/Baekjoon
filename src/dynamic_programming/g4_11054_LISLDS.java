package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_11054_LISLDS {
    static int[] A;
    static Integer[] lis,lds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        lis = new Integer[N];
        lds = new Integer[N];

        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(tok.nextToken());
        }

        for(int i=0;i<N;i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(lis[i] + lds[i], max);
        }
        System.out.println(max - 1);

    }

    public static int LIS(int N) {
        if(lis[N] == null) {
            lis[N] = 1;

            for(int i=N-1;i>=0;i--) {
                if(A[i] < A[N]) {
                    lis[N] = Math.max(lis[N], LIS(i)+1);
                }
            }
        }

        return lis[N];
    }

    public static int LDS(int N) {
        if(lds[N] == null) {
            lds[N] = 1;

            for(int i=N+1;i<lds.length;i++) {
                if(A[i] < A[N]) {
                    lds[N] = Math.max(lds[N], LDS(i)+1);
                }
            }
        }

        return lds[N];
    }
}
