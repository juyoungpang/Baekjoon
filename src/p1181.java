import java.io.*;

public class p1181{
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

        mergeSort(0, list.length-1);

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
    
    private static void mergeSort(int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start,mid,end);
        }
    }

    private static void merge(int start, int mid, int end){
        String[] temp = new String[end-start+1];
        int l = start, r = mid+1, idx = 0;

        while(r<=end && l<=mid){
            if(list[l].length() == list[r].length()){
                temp[idx++] = list[l].compareTo(list[r])<0 ? list[l++] : list[r++];
            }
            else {
                temp[idx++] = list[l].length()<list[r].length() ? list[l++] : list[r++];
            }
        }

        while(r<=end) temp[idx++] = list[r++];
        while(l<=mid) temp[idx++] = list[l++];

        for(int i=0;i<temp.length;i++){
            list[i+start]=temp[i];
        }
    }
}