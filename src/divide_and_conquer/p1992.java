package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1992 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        split(arr,0,0,N);

        System.out.println(sb.toString());
    }

    private static void split(int[][] arr, int top, int left, int len) {
        for(int i=top;i<arr.length && i<=top+len;i+=len) {
            for(int j=left;j<arr.length && j<=left+len;j+=len) {
                int check = check(arr,i,j,len);
                if(check==-1) {
                    sb.append("(");
                    split(arr,i,j,len/2);
                    sb.append(")");
                }
                else {
                    sb.append(check);
                }
            }
        }
    }

    private static int check(int[][] arr, int top, int left, int len) {
        int ret = arr[top][left];
        for(int i=top;i<top+len;i++) {
            for(int j=left;j<left+len;j++) {
                if(arr[i][j]!=ret) 
                    return -1;
            }
        }
        return ret;
    }
    
}
