import java.util.Arrays;

public class Solution {
    public static int main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        int[] temp = new int[1000001];
        Arrays.fill(temp,0);
        int ret = 1;
        for(int a:A){
            if(a>0) temp[a]++;
            if(a==ret) ret = findSmallestZero(A,ret);
        }
        return ret;
    }
    public static int findSmallestZero(int[] A, int cur) {
        for(int i=cur+1;i<A.length;i++) {
            if(A[i]==0) return i;
        }
        return -1;
    }
}
