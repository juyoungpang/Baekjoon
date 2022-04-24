//counting

package sorting;
import java.io.*;

public class p2108_counting{
    static int N;
    static int[] counting;

    static BufferedReader br;
    static BufferedWriter bw;

    static final int absMax = 4000;
    
    public static void main(String[] args) throws IOException{
        int med=0, range=0, sum=0, min=absMax*+1, max=absMax*-1-1;
        int[] mod = new int[2];
        mod[0] = absMax+1;
        mod[1] = absMax+1;
        double avg = 0;
        boolean foundMed=false;

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        counting = new int[absMax*2+1];
        for(int i=0;i<N;i++){
            int input = Integer.parseInt(br.readLine());
            counting[input+absMax]++;
            sum+=input;
            if(input<min) min = input;
            if(input>max) max = input;
        }
        avg = sum/(double)N;
        range = max-min;

        int maxCount=-1, medSearcher=-1;
        for(int i=0;i<counting.length;i++){
            if(counting[i]>maxCount) {
                maxCount = counting[i];
                mod[0] = i-absMax;
                mod[1] = absMax+1;
            }
            else if(counting[i]==maxCount && mod[1]>absMax){
                mod[1] = i-absMax;
            }
            medSearcher+=counting[i];
            if(medSearcher>=N/2 && !foundMed) {
                med = i-absMax;
                foundMed=true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(avg)).append("\n").append(med).append("\n").append((mod[1]>absMax)?mod[0]:mod[1]).append("\n").append(range).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();        

    }


}