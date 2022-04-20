//dijkstra

package graph;
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
        for(int i=1;i<V+1;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //리스트 초기화
        list = new ArrayList[V+1];  //인접 정점 리스트
        for(int i=1;i<V+1;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1;i<E+1;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        //dijkstra
        dijkstra(K);

        //output
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<V+1;i++){
            if(dist[i]<Integer.MAX_VALUE) sb.append(dist[i]+"\n");
            else sb.append("INF\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight > dist[cur.id]) continue; //현재 weight가 dist에 저장된 weight보다 크면 갱신할 필요가 없다.
            for(Node next:list[cur.id]){
                int nextW = next.weight+cur.weight;
                if(dist[next.id]>nextW){     //만약 dist에 저장된 next의 weight가 cur에서 next로가는 weight보다 크다면 갱신.  
                    dist[next.id] = nextW;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }
    }
}