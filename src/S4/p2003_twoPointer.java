package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2003_twoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        int N, M;
        int[] arr;

        tok = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());

        arr = new int[N];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }

        System.out.println(twoPointer(arr,M));
    }

    private static int twoPointer(int[] arr, int m) {
        int count = 0;
        int startPointer = 0;
        int endPointer = 0;
        int sum = 0;

        while (true) {
            if(sum>=m) {
                sum -= arr[startPointer++];
            }

            else if (endPointer >= arr.length) {
                break;
            }

            else {
                sum += arr[endPointer++];
            }

            if(sum==m) {
                count++;
            }
        }
        
        return count;
    }
}
