package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p18185_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;
        int money = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        ArrayList<Integer> pairs = new ArrayList<>();
        for(int i=1;i<arr.length;i++) {
            if(arr[i-1]>0 && arr[i]>0){
                pairs.add(i-1);
                arr[i-1]--;
                arr[i]--;
                money+=5;
            }
        }

        int i=0;
        while(i<arr.length) {
            if(arr[i]>0) {
                if(pairs.contains(i-2)) {
                    arr[i]--;
                    pairs.remove(pairs.indexOf(i-2));
                    money+=2;
                }
                else {
                    arr[i]--;
                    money+=3;
                }
            }
            else i++;
        }

        System.out.println(money);
    }
}
