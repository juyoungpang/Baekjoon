package G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p16235_impl {
    static int N,M,K,count=0;
    static int[][] A, land;
    static List<Integer>[][] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tok.nextToken());
        M = Integer.parseInt(tok.nextToken());
        K = Integer.parseInt(tok.nextToken());

        A = new int[N][N];
        land = new int[N][N];
        trees = new ArrayList[N][N];

        for(int i=0;i<N;i++) {
            tok = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(tok.nextToken());
                land[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<M;i++) {
            tok = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tok.nextToken())-1;
            int y = Integer.parseInt(tok.nextToken())-1;
            int z = Integer.parseInt(tok.nextToken());

            trees[x][y].add(z);

            if(trees[x][y].size()>1) Collections.sort(trees[x][y]);
        }

        count = M;

        for(int k=0;k<K;k++) {
            if(count==0) break;
            year();
        }

        System.out.println(count);
    }

    public static void year() {
        List<Location> procreate = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].size() != 0) {

                    int deadAges = 0;

                    for (int a = 0; a < trees[i][j].size(); a++) {
                        int age = trees[i][j].get(a);
                        //봄
                        if (age <= land[i][j]) {
                            land[i][j] -= age;
                            age++;
                            if (age % 5 == 0) {
                                procreate.add(new Location(i, j)); //가을 준비
                            }
                            trees[i][j].set(a, age);
                        } else {
                            deadAges += age / 2; //여름 준비
                            trees[i][j].remove(a);
                            a--;
                            count--;
                        }
                    }

                    //여름
                    land[i][j] += deadAges;
                }
                //겨울
                land[i][j]+=A[i][j];
            }
        }

        //가을
        autumn(procreate);
    }

    public static void autumn(List<Location> procreate) {
        for(Location loc : procreate) {
            boolean canGoUp = loc.r>0;
            boolean canGoDown = loc.r<N-1;
            boolean canGoRight = loc.c<N-1;
            boolean canGoLeft = loc.c>0;

            if(canGoUp) {
                trees[loc.r-1][loc.c].add(0,1);
                count++;
                if(canGoLeft) {
                    trees[loc.r-1][loc.c-1].add(0,1);
                    count++;
                }
                if(canGoRight) {
                    trees[loc.r-1][loc.c+1].add(0,1);
                    count++;
                }
            }
            if(canGoDown) {
                trees[loc.r+1][loc.c].add(0,1);
                count++;
                if(canGoLeft) {
                    trees[loc.r+1][loc.c-1].add(0,1);
                    count++;
                }
                if(canGoRight) {
                    trees[loc.r+1][loc.c+1].add(0,1);
                    count++;
                }
            }
            if(canGoRight) {
                trees[loc.r][loc.c+1].add(0,1);
                count++;
            }
            if(canGoLeft) {
                trees[loc.r][loc.c-1].add(0,1);
                count++;
            }
        }
    }

}

class Location{
    int r;
    int c;

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}