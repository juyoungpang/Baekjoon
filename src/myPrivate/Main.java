package myPrivate;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int[] d = {1, 0, 3, 1, 2};
        int[] p = {0, 2, 0, 1, 0, 2, 0};
        System.out.println(solution(4, 5,  d, p));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        List<House> houses = new ArrayList<>();
        for(int i=0;i<n;i++) {
            houses.add(new House(i+1,deliveries[i], pickups[i]));
        }

        while(!houses.isEmpty()) {
            boolean hasChanged=false;
            int capD = 0;
            int capP = 0;
            for(int i=houses.size()-1;i>=0;i--) {
                capD+=houses.get(i).d;
                capP+=houses.get(i).p;
                if(capD>=cap || capP>=cap) {
                    answer+=deliver(houses, cap);
                    hasChanged=true;
                    break;
                }
            }
            if(!hasChanged) {
                for(House h:houses) {
                    answer+=h.dist;
                    h.p=0;
                    h.d=0;
                }
            }
            for(int i=houses.size()-1;i>=0;i--) {
                if(houses.get(i).isEmpty()) houses.remove(i);
            }
        }

        return answer;
    }

    public static long deliver(List<House> houses, int CAP) {
        long answer = 0;
        int tempD = CAP;
        int tempP = CAP;
        answer+=(houses.get(houses.size()-1).dist)*2;
        for(int i=houses.size()-1;i>=0;i--) {
            while((tempD!=0 && houses.get(i).d!=0) || (tempP!=0 && houses.get(i).p!=0)) {
                if(houses.get(i).d!=0){
                    tempD--;
                    houses.get(i).d--;
                }
                if(houses.get(i).p!=0) {
                    tempP--;
                    houses.get(i).p--;
                }
            }
        }
        return answer;
    }

}

class House {
    int dist;
    int d;
    int p;

    public House(int dist, int d, int p) {
        this.dist=dist;
        this.d=d;
        this.p=p;
    }

    public boolean isEmpty() {
        return d==0&&p==0;
    }

    public String toString() {
        return dist+"/"+d+"/"+p;
    }
}