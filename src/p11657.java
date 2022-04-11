import java.io.*;
import java.util.*;

public class p11657 {
    static BufferedReader br;
    static BufferedWriter bw;

    static int N, M;
    static int a,b,c;
    static final long INF = Long.MAX_VALUE;

    static class Path implements Comparable<Path>{
        int end, weight;
        public Path(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Path o){
            return weight - o.weight;
        }
    }

    static long[] dist;
    static ArrayList<Path>[] list;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
        Arrays.fill(dist,INF);

        list = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list[a].add(new Path(b,c));
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanFord()){
            sb.append("-1\n");
        }
        else{
            for (int i = 2; i < N+1; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bellmanFord(){
        dist[1] = 0;
        for(int i=1;i<N;i++){
            for(int j=1;j<N+1;j++){
                for(Path cur:list[j]){
                    if(dist[j]!=INF){
                        if(dist[cur.end]>(dist[j]+cur.weight)){
                            dist[cur.end] = (dist[j]+cur.weight);
                        }
                    }
                }
            }
        }

        for(int i=1;i<N+1;i++){
            for(Path p : list[i]){
                if(dist[i]!=INF && dist[p.end]>(dist[i]+p.weight)) return true;
            }
        }

        return false;
    }
}
