package dynamic_programming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s1_12852 {
    static int dp[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        Arrays.fill(dp,-1);

        sb = new StringBuilder();
        sb.append(n).append(" ");

//        System.out.println(topDown(n)+"\n"+sb.toString()+"1");

        System.out.println(topDown(n));
    }

    public static int topDown(int i) {
        if(i==1) return 0;
        if(i==2) return 1;
        if(i==3) return 1;
        if(dp[i]!=-1) return dp[i];

        int whichOne = -1;

        dp[i] = topDown(i-1)+1;
        whichOne = 0;

        if(i%2==0) {
            int temp = topDown(i/2)+1;
            if(temp<dp[i]) {
                dp[i] = temp;
                whichOne = 1;
            }
        }

        if(i%3==0) {
            int temp = topDown(i/3)+1;
            if(temp<dp[i]) {
                dp[i] = temp;
                whichOne = 2;
            }
        }

        return dp[i];
    }
}
