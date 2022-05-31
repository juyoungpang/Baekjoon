package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p1644 {
    static int N;
    static boolean[] isPrime;
    static List<Integer> primeNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primeNums = new ArrayList<>();

        isPrime = new boolean[N+1];
        isPrime[0] = isPrime[1] = true;       
        for(int i=2; i*i<=N; i++){
            if(!isPrime[i]) for(int j=i*i; j<=N; j+=i) isPrime[j]=true;                
        }
        for(int i=1;i<isPrime.length;i++) {
            if(!isPrime[i]) primeNums.add(i);
        }


        int startPointer = 0;
        int endPointer = 0;
        int count = 0;
        int sum = 0;

        while (true) {
            if (sum>=N) {
                sum-=primeNums.get(startPointer++);
            } else if (endPointer == primeNums.size()) {
                break;
            } else {
                sum+=primeNums.get(endPointer++);
            }

            if(sum==N) {
                count++;
            }
        }

        System.out.println(count);
    }
}
