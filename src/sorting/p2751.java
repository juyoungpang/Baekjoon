//merge sort

package sorting;
import java.io.*;

public class p2751 {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] list;
    static int N;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        for(int i=0;i<N;i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, list.length-1);

        StringBuilder sb = new StringBuilder();
        for(int num:list){
            sb.append(num+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(start,mid);
            mergeSort(mid+1,end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end){
        int temp[] = new int[end-start+1];
        int l=start, r=mid+1, idx = 0;

        while(r<=end && l<=mid){
            if(list[l]<=list[r]) temp[idx++] = list[l++];
            else temp[idx++] = list[r++];
        }

        while(r<=end) temp[idx++] = list[r++];
        while(l<=mid) temp[idx++] = list[l++];

        for(int i=0;i<temp.length;i++){
            list[i+start]=temp[i];
        }

    }
}
