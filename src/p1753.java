import java.util.*;
import java.io.*;

public class p1753{
    static BufferedReader br;
    static BufferedWriter bw;

    static int V,E,K;
    static int u,v,w;
    static int[] dist;
    static List<Node>[] list;

    static class Node implements Comparable<Node>{
        int id, weight;

        public Node(int id, int weight){
            this.id = id;
            this.weight = weight;
        }

        public String toString(){
            return "("+id+","+weight+")";
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   //정점 개수
        E = Integer.parseInt(st.nextToken());   //간선 개수
        K = Integer.parseInt(br.readLine());    //시작 정점

        //거리배열 INF로 초기화
        dist = new int[V+1];    //거리배열
        Arrays.fill(dist, Integer.MAX_VALUE);

        //리스트 초기화
        list = new ArrayList[V+1];  //인접 정점 리스트
        for(int i=1;i<V+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }
    }

    public void dijkstra(int start){
        
    }
  
}