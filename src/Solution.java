import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args){
        int[][] v = {{1,4},{3,4},{3,10}};
        System.out.println(toString(solution(v)));
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

//     public static int solution(int n, int[] times) {
//         int visited[] = new int[n+1];
//         Queue<Integer> queue = new LinkedList<>();
//         Arrays.fill(visited,0);
//         queue.offer(1);
//         while(!queue.isEmpty()) {
//             int current = queue.poll();

//             for(int i=0;i<times.length;i++) {
//                 int numStrings = current+(i+1);
//                 int time = visited[current]+times[i];
//                 if(numStrings==n) return time;

//                 if(numStrings<n && visited[numStrings]==0) {
//                     visited[numStrings] = time;
//                 }
//             }
//         }
//         return -1;
//     }

    public static String toString(int[] arr) {
        String s = "";
        for(int i:arr) s+=i+" ";
        return s;
    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        int x1 = -1, x2 = -1;
        int y1 = -1, y2 = -1;

        for(int[] point:v) {
            int x = point[0];
            int y = point[1];

            if(x1 == -1) x1 = x;
            else if(x1 == x) x1 = -1;
            else if(x2 == -1) x2 = x;
            else x2 = -1;

            if(y1 == -1) y1 = y;
            else if(y1 == y) y1 = -1;
            else if(y2 == -1) y2 = y;
            else y2 = -1;
        }

        answer[0] = x1!=-1?x1:x2;
        answer[1] = y1!=-1?y1:y2;

        return answer;
    }
}