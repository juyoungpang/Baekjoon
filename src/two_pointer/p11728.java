package two_pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11728 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tok = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());

        int[] A = new int[N];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(tok.nextToken());
        }

        int[] B = new int[M];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            B[i] = Integer.parseInt(tok.nextToken());
        }

        int aPointer = 0;
        int bPointer = 0;
        while(true) {
            if(aPointer==N || bPointer==M) {
                break;
            } else if(A[aPointer]<B[bPointer]) {
                sb.append(A[aPointer++]).append(" ");
            } else {
                sb.append(B[bPointer++]).append(" ");
            }
        }

        while(aPointer<N) sb.append(A[aPointer++]).append(" ");
        while(bPointer<M) sb.append(B[bPointer++]).append(" ");
        
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    
}
