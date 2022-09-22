package BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        Arrays.fill(answer,0);
    
        int[][] plan = new int[plans.length][n+1];
        for(int i=0;i<plan.length;i++) {
            String[] temp = plans[i].split(" ");
            plan[i][0] = Integer.parseInt(temp[0]);
            if(i>0) {
                for(int j=1;j<plan[0].length;j++) {
                    plan[i][j] = plan[i-1][j];
                }
            }
            for(int j=1;j<temp.length;j++) {
                plan[i][Integer.parseInt(temp[j])]=1;
            }
        }

        for(int c=0;c<clients.length;c++) {
            String client = clients[c];
            String[] temp = client.split(" ");
            int data = Integer.parseInt(temp[0]);
            List<Integer> service = new ArrayList<>();
            for(int j=1;j<temp.length;j++) {
                service.add(Integer.parseInt(temp[j]));
            }

            for(int i=0;i<plans.length;i++) {
                if(data<=plan[i][0] && check(plan[i], service)) {
                    answer[c] = i+1;
                    break;
                }
            }
        }

        return answer;
    }

    public boolean check(int[] plan, List<Integer> service) {
        for(Integer s:service) {
            if(plan[s]!=0) return false;
        }
        return true;
    }
}