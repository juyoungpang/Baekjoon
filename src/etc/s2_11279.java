package etc;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class s2_11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++) {
            int num = sc.nextInt();
            if(num==0) {
                if(pq.size()==0) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else pq.offer(num);
        }

        System.out.print(sb.toString());
    }
}
