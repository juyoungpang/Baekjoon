//selection sort

package S4;
import java.io.*;
import java.util.*;

public class p11399_selection {
    private static int N;
    private static int[] time;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N];

        StringTokenizer tok = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            time[i] = Integer.parseInt(tok.nextToken());
        }

        int min = -1;
        for(int i=0;i<N-1;i++){
            min = i;
            for(int j=i+1;j<N;j++){
                if(time[min]>time[j]){
                    min = j;
                }
            }
            int temp = time[i];
            time[i] = time[min];
            time[min] = temp;

            if(i!=0) time[i] += time[i-1];
        }

        if(N>1) time[N-1] += time[N-2];

        System.out.println(Arrays.stream(time).sum());

        br.close();
    }
}
