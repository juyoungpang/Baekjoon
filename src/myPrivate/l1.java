package myPrivate;

import java.util.HashMap;
import java.util.Map;

class l1 {
    public static int solution(int[][] queries) {
        int answer = 0;

        Map<Integer, Arr> map = new HashMap<>();

        for(int i=0;i<queries.length;i++) {
            int key = queries[i][0];
            if(!map.containsKey(key)) map.put(queries[i][0], new Arr(queries[i][1]));
            else {
                answer += map.get(key).addElements(queries[i][1]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] q = {{2,10},{7,1},{2,5},{2,9},{7,32}};
        solution(q);
    }
}

class Arr {
    int size;
    int elements;

    public Arr(int elements) {
        this.elements = elements;
        this.size = calcSize(elements);
    }

    public int addElements(int num) {
        int temp = elements;
        elements+=num;
        if(elements<=size) return 0;
        size = calcSize(elements);
        return temp;
    }

    public int calcSize(int n) {
        if(n==1) return 1;

        int ret = 2;
        while(n>=ret) {
            ret*=2;
        }
        return ret;
    }
}