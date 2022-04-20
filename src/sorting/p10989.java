//counting sort

package sorting;
import java.io.*;
import java.util.*;

public class p10989 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        //list에 넣어주면서 max값도 찾는다
        int max = -1;
        for(int i=0;i<N;i++){
            list[i] = Integer.parseInt(br.readLine());
            if(list[i]>max) max = list[i];
        }

        //max값만큼의 index를 가진 int[] counting 생성
        int[] counting = new int[max+1];
        Arrays.fill(counting,0);

        //list에 있는 숫자의 값과 동일한 index값 안에 있는 수를 +1씩 해주기
        for(int i:list) counting[i]++;

        StringBuilder sb = new StringBuilder();
        //counting의 index값을 element값만큼 반복해서 print
        for(int i=0;i<counting.length;i++){
            for(int j=0;j<counting[i];j++){
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
