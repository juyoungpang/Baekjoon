package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        int[] arr = new int[Integer.parseInt(br.readLine())];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(tok.nextToken());

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;
        int leftVal = 0;
        int rightVal = 0;

        while(left!=right) {
            int sum = arr[left]+arr[right];
            if(Math.abs(sum)<min) {
                leftVal = arr[left];
                rightVal = arr[right];
                min = Math.abs(sum);
            }

            if(sum>0) right--;
            else left++;
        }

        System.out.println(leftVal+" "+rightVal);

    }
    
}
