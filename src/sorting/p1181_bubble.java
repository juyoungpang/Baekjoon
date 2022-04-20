//bubble sort
//wrong due to time out but keeping for studying purpose

package sorting;
import java.io.*;

public class p1181_bubble{
    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
    static String[] list;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        list = new String[N];

        for(int i=0;i<N;i++){
            list[i] = br.readLine();
        }

        for(int rep=0; rep<N; rep++){
            for(int i=0;i<N-1;i++){
                if(list[i].length() == list[i+1].length()){
                    if(list[i].compareTo(list[i+1])>0){
                        swap(i,i+1);
                    }
                }
                else if(list[i].length()>list[i+1].length()){
                    swap(i,i+1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N-1;i++){
            if(!list[i].equals(list[i+1])) sb.append(list[i]).append("\n");
        }
        sb.append(list[N-1]).append("\n");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void swap(int i, int j){
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}