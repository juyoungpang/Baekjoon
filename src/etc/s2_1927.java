package etc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class s2_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++) {
            Long num = sc.nextLong();

            if(num==0) {
                if(pq.size()==0) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else pq.offer(num);
        }

        System.out.print(sb.toString());
    }
}
