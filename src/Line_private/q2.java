package Line_private;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class q2 {
    public static void main(String[] args){
        int n = 6;
        int[] times = {1,2,3};
        System.out.println(solution(n, times));
    }

    /*public static int solution(int n, int[] times) {
        return cut(1,1,0,n,times);
    }

    public static int cut(int numStrings, int numCuts, int currentTime, int goal, int[] times) {
        if(numStrings<numCuts) return Integer.MAX_VALUE;

        numStrings = (numStrings-numCuts)+numCuts*2;
        currentTime += times[numCuts-1];

        if(numStrings == goal) return currentTime;
        else if(numStrings > goal) return Integer.MAX_VALUE;

        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<times.length;i++) {
            int time = cut(numStrings, i+1, currentTime, goal, times);
            if(time<minTime) minTime = time;
        }

        return minTime;
    }*/

    public static int solution(int n, int[] times) {
        int visited[] = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited,0);
        queue.offer(1);
        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i=0;i<times.length;i++) {
                int numStrings = current+(i+1);
                int time = visited[current]+times[i];
                if(numStrings==n) return time;

                if(numStrings<n && visited[numStrings]==0) {
                    visited[numStrings] = time;
                }
            }
        }
        return -1;
    }
}