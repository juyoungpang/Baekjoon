package etc;

import java.util.Scanner;

public class b1_1193 {
    public static void main(String[] args) {
        int n;
        do {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            int a = 1;
            int b = 1;

            int temp = 1;

            while (true) {
                if (temp + a > n) break;
                temp += a;
                a++;
            }

            for (int i = 0; i < n - temp; i++) {
                a--;
                b++;
            }

            System.out.println(b + "/" + a);

        } while(n!=-1);
    }
}
