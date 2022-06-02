package dynamic_programming;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class p2839_bottom {

    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(bottomUp(N));
    }

    public static int bottomUp(int sugar) {
        int count = 0;

        while (true) {
            if (sugar % 5 == 0) {
                return sugar / 5 + count;
            } else if (sugar < 0) {
                return -1;
            }

            sugar = sugar - 3; 
            count++;
        }
    }
}
