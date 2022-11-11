package etc;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class g2_1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int n1 = sc.nextInt();

        System.out.println(n1);

        if(N==1) {
            return;
        }

        int n2 = sc.nextInt();

        PriorityQueue<Integer> smallerHalf = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> biggerHalf = new PriorityQueue<>();

        if(n1>n2) {
            biggerHalf.offer(n1);
            smallerHalf.offer(n2);
        } else {
            biggerHalf.offer(n2);
            smallerHalf.offer(n1);
        }

        System.out.println(smallerHalf.poll());

        if(N==2) {
            return;
        }

        for(int i=3;i<N;i++) {
            int num = sc.nextInt();
            if(num>biggerHalf.peek()) {
                biggerHalf.offer(num);
            }
            else {
                smallerHalf.offer(num);
            }
            System.out.println(smallerHalf.peek());
        }

    }
}
