package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20047 {

    static BufferedReader br;
    static StringTokenizer tok;

    static int n,fPos,sPos;
    static String initial, end, temp;
    static char first, second;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        initial = br.readLine();
        end = br.readLine();
        tok = new StringTokenizer(br.readLine());
        fPos = Integer.parseInt(tok.nextToken());
        sPos = Integer.parseInt(tok.nextToken());
        first = initial.charAt(fPos);
        second = initial.charAt(sPos);
        temp = initial.substring(0, fPos)+initial.substring(fPos+1,sPos)+initial.substring(sPos+1);

        System.out.println((getAns())?"YES":"NO");

    }

    public static String makeString(int f, int s) {
        return temp.substring(0,f)+first+temp.substring(f, s-1)+second+temp.substring(s-1);
    }

    public static boolean getAns() {
        for(int s=sPos; s<n; s++) {
            for(int f=fPos;f<s;f++) {
                if(makeString(f,s).equals(end)) return true;
            }
        }
        return false;
    }


}
