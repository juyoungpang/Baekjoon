package B1;

import java.util.Scanner;

public class p24416_dp {
    static int recur = 0;
    static int dynamic = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fibRecur(n);
        fibDynamic(n);

        System.out.println(recur+" "+dynamic);
    }

    public static void fibRecur(int n) {
        if(n==1 || n==2) {
            recur++;
            return;
        }
        fibRecur(n-1);
        fibRecur(n-2);
    }

    public static void fibDynamic(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
            dynamic++;
        }
    }
}
