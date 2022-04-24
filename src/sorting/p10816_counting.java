package sorting;

import java.io.*;
import java.util.*;

public class p10816_counting {
    static final int MAX = 10000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        
        int N, M;
        int[] cards;

        N = Integer.parseInt(br.readLine());
        cards = new int[MAX*2+1];
        Arrays.fill(cards,0);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cards[Integer.parseInt(st.nextToken())+MAX]++;
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(cards[Integer.parseInt(st.nextToken())+MAX]).append(" ");;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        

    }
}
