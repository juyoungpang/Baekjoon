package S1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p11286_pQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pqP = new PriorityQueue<>();
        PriorityQueue<Long> pqN = new PriorityQueue<>(Collections.reverseOrder());

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int n=0;n<N;n++) {
            Long num = sc.nextLong();
            if(num == 0) {
                if(pqP.size() == 0 && pqN.size()==0) sb.append(0).append("\n");
                else if(pqP.size()==0 && pqN.size()!=0) sb.append(pqN.poll()).append("\n");
                else if(pqP.size()!=0 && pqN.size()==0) sb.append(pqP.poll()).append("\n");
                else sb.append((pqP.peek()<pqN.peek()*-1)?pqP.poll():pqN.poll()).append("\n");
            } else {
                if(num<0) pqN.offer(num);
                else pqP.offer(num);
            }
        }

        System.out.print(sb.toString());
    }
}
