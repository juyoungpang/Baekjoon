//package myPrivate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class k2 {
//    List<House> houses;
//    int CAP;
//    long answer;
//
//    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//        CAP=cap;
//        answer = 0;
//
//        houses = new ArrayList<>();
//        for(int i=0;i<n;i++) {
//            houses.add(new House(i+1,deliveries[i], pickups[i]));
//        }
//
//        while(!houses.isEmpty()) {
//            int capD = 0;
//            int capP = 0;
//            for(int i=houses.size()-1;i>=0;i--) {
//                capD+=houses.get(i).d;
//                capP+=houses.get(i).p;
//                if(capD>=cap) {
//                    deliver(i);
//                }
//                if(capP>=cap) {
//                    pickup(i);
//                }
//            }
//
//            for(int i=houses.size()-1;i>=0;i--) {
//                if(houses.get(i).isEmpty()) houses.remove(i);
//            }
//        }
//
//        return answer;
//    }
//
//    public void deliver(int index) {
//        int temp = CAP;
//        for(int i=houses.size()-1;i>=index;i--) {
//            answer+=houses.get(i).dist;
//            while(temp!=0 && houses.get(i).d!=0) {
//                temp--;
//                houses.get(i).d--;
//                if(houses.get(i).p!=0) houses.get(i).p--;
//            }
//        }
//    }
//
//    public void pickup(int index) {
//        int temp = CAP;
//        for(int i=houses.size()-1;i>=index;i--) {
//            answer+=houses.get(i).dist;
//            while(temp!=0 && houses.get(i).p!=0) {
//                temp--;
//                houses.get(i).p--;
//                if(houses.get(i).d!=0) houses.get(i).d--;
//            }
//        }
//    }
//}
//
//class House {
//    int dist;
//    int d;
//    int p;
//
//    public House(int dist, int d, int p) {
//        this.dist=dist;
//        this.d=d;
//        this.p=p;
//    }
//
//    public boolean isEmpty() {
//        return d==0&&p==0;
//    }
//}