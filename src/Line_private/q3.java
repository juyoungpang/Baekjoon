package Line_private;

import java.util.Arrays;

class q3 {
    public static void main(String[] args){
        int fuel = 8;
        int[] powers = {20,30};
        int[] distances = {750,675};
        System.out.println(solution(fuel,powers,distances));
    }

    
    public static int solution(int fuel, int[] powers, int[] distances) {
        int answer = -1;
        int distributedFuel = powers.length; //우선 한통씩 배분
        int[] dFuels = new int[powers.length];
        Arrays.fill(dFuels,1);

        while(distributedFuel<=fuel) {
            int maxIndex = -1;
            int maxVal = -1;
            for(int i=0;i<powers.length;i++) {
                int tempTime = getTime(dFuels[i], powers[i], distances[i]);
                if(tempTime > maxVal) {
                    maxIndex = i;
                    maxVal = tempTime;
                }
            }
            answer = getTime(dFuels[maxIndex], powers[maxIndex], distances[maxIndex]);
            dFuels[maxIndex]++;
            distributedFuel++;
        }

        return answer;
    }

    public static int getTime(int fuel, int power, int distance) {
        double totalTime = fuel;
        double finalSpeed = fuel*power;
        double engineDist = finalSpeed*fuel/2.0;
        if(engineDist < distance) {
            totalTime += (distance-engineDist)/finalSpeed;
        }
        return (int)Math.ceil(totalTime);
    }
}