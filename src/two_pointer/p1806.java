package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        int N, S;
        int[] arr;

        tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        S = Integer.parseInt(tok.nextToken());

        arr = new int[N];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        System.out.println(twoPointer(arr,S));
    }

    private static int twoPointer(int[] arr, int s) {
        int minLen = Integer.MAX_VALUE;
        int startPointer = 0;
        int endPointer = 0;
        int sum = 0;

        while (true) {
            if(sum >= s) {
                sum -= arr[startPointer++];
                minLen = Math.min(minLen, endPointer-startPointer+1);
            } else if (endPointer == arr.length) {
                break;
            } else {
                sum += arr[endPointer++];
            }
        }

        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }
}
