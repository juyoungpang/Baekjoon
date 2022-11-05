package brute_force;

import java.io.*;
import java.util.*;

public class g5_1759 {
    static int N,C;
    static char[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        C = Integer.parseInt(tok.nextToken());

        word = new char[C];

        tok = new StringTokenizer(br.readLine());
        for(int c=0;c<C;c++) {
            word[c] = tok.nextToken().charAt(0);
        }

        Arrays.sort(word);

        simulate("",-1,0,0);
    }

    public static void simulate(String input, int index, int numV, int numC) {
        if(input.length()==N && numV>0 && numC>1) {
            System.out.println(input);
            return;
        }
        if(C-index<=N-input.length()||input.length()>N) return;

        for(int i=index+1;i<word.length;i++) {
            if (isVowel(word[i])) numV++;
            else numC++;
            simulate(input+word[i],i,numV, numC);
            if(isVowel(word[i])) numV--;
            else numC--;
        }
    }

    public static boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

}
