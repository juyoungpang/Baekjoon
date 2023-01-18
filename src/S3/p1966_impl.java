package S3;

import java.io.*;
import java.util.*;
public class p1966_impl {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer tok = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tok.nextToken());
            int M = Integer.parseInt(tok.nextToken());
            int count = 1;

            Queue<int[]> queue = new LinkedList<>();
            tok = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                queue.offer(new int[] {i, Integer.parseInt(tok.nextToken())});
            }

            while(!queue.isEmpty()){
                int[] front = queue.poll();
                boolean isMax = true;
                for(int[] arr:queue){
                    if(arr[1]>front[1]) {
                        queue.offer(front);
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;
                
                if(front[0] != M) count++;
                else break;
                
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
