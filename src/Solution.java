import java.util.Arrays;

class Solution {
    public static void main(String[] args){
        int test[] = {1,2,3};
        int sol = solution(test);
        System.out.println(sol);
    }

    public static int solution(int[] arr) {
        int answer = 1;
        int[][] multiples = new int[arr.length][101];
        
        for(int[] m: multiples){
            for(int i=0;i<101;i++){
                if(isPrime(i))
                    m[i] = 0;
                else
                    m[i] = -1;
            }
        }
        
        for(int j=2;j<multiples[0].length;j++){
            for(int i=0;i<multiples.length;i++){
                if(arr[i]%j==0 && multiples[i][j]>=0)
                    multiples[i][j]++;
            }
        }
        
        for(int j=2;j<multiples[0].length;j++){
            int max = 0;
            for(int i=0;j<multiples.length;i++){
                if (max<multiples[i][j]){
                    max = multiples[i][j];
                }
            }
            if(max>0) answer*=Math.pow(j,max);
        }
        return answer;
    }
    
    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if (n%i==0) return false;
        }
        return true;
    }
}