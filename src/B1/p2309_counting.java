//counting sort

package B1;
import java.io.*;
import java.util.*;

public class p2309_counting{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        ArrayList<Integer> input = new ArrayList<>();
        int a=-1,b=-1;
        int[] countingSort = new int[100];


        for(int i=0;i<9;i++){
            input.add(Integer.parseInt(br.readLine()));
        }

        for(int i=0;i<input.size();i++){
            for(int j=i+1;j<input.size();j++){
                if(addWithout(input,i,j)==100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        input.remove(a);
        input.remove(b-1);

        for(int n:input){
            countingSort[n]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<countingSort.length;i++){
            for(int count = 0;count<countingSort[i];count++){
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }

    private static int addWithout(ArrayList<Integer> arr, int a, int b){
        int ret = 0;
        for(int i=0;i<arr.size();i++){
            if(i != a && i != b){
                ret += arr.get(i);
            }
        }
        return ret;
    }       


}