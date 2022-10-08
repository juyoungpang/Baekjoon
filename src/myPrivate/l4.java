package myPrivate;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class l4 {
    public static int[][] solution(String[] wall) {
        int[][] answer = new int[wall.length][wall[0].length()];

        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[0].length;j++) {
                answer[i][j] = (wall[i].substring(j,j+1).equals("H"))?Integer.MAX_VALUE:((wall[i].substring(j,j+1).equals("X"))?-2:0);
            }
        }

        int startRow = answer.length-1;
        int startCol = 0;

        answer[answer.length-1][0] = 1;

        answer = bfs(answer,startRow,startCol);

        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[0].length;j++) {
                if(answer[i][j]==-2) answer[i][j]=0;
                else if(answer[i][j]==Integer.MAX_VALUE) answer[i][j]=-1;
            }
        }

        return answer;
    }

    public static int[][] bfs(int[][] map, int r, int c) {
        int[][] answer = map;

        boolean[][] visited = new boolean[map.length][map[0].length];
        for(boolean[] rows:visited) {
            Arrays.fill(rows,false);
        }
        visited[r][c] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r,c));

        //상,좌,하,우,위로두칸,대각선좌,대각선우,두칸좌,두칸우,세칸좌,세칸우
        int[] dr = {-1,0,1,0,-2,-1,-1,0,0,0,0};
        int[] dc = {0,-1,0,1,0,-1,1,-2,2,-3,3};
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for (int i = 0; i < dr.length; i++) {
                int row = p.x;
                int col = p.y;
                int newR = p.x+dr[i];
                int newC = p.y+dc[i];
                int newAns = answer[row][col]+1;
                if(!inMap(newR,newC,map.length,map[0].length)) continue;
                if(answer[newR][newC]<=0 || !(newAns<answer[newR][newC])) continue;

                if (i < 4) {
                    answer[newR][newC]=newAns;
                    queue.offer(new Point(newR,newC));
                }

                else if(inMap(row-1,col, map.length, map[0].length)&&answer[row-1][col]==0) {
                    if (i == 4) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if (i == 5 && inMap(row,col-1, map.length, map[0].length) &&answer[row][col - 1] == 0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if (i == 6 && inMap(row,col+1, map.length, map[0].length)&& answer[row][col + 1] == 0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if (i == 7 && inMap(row-1,col-1, map.length, map[0].length)&& answer[row - 1][col - 1] == 0
                            && inMap(row,col-1, map.length, map[0].length)&& answer[row][col - 1] == 0
                            && inMap(row,col-2, map.length, map[0].length)&& answer[row-1][col-2]==0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if(i == 8
                            && inMap(row-1,col+1, map.length, map[0].length)&& answer[row - 1][col + 1] == 0
                            && inMap(row,col+1, map.length, map[0].length)&& answer[row][col + 1] == 0
                            && inMap(row,col+2, map.length, map[0].length)&& answer[row-1][col+2]==0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if (i == 9
                            && inMap(row-1,col-1, map.length, map[0].length)&& answer[row - 1][col - 1] == 0
                            && inMap(row,col-1, map.length, map[0].length)&& answer[row][col - 1] == 0
                            && inMap(row-1,col-2, map.length, map[0].length)&& answer[row-1][col-2]==0
                            && inMap(row,col-2, map.length, map[0].length)&&answer[row][col-2]==0
                            && inMap(row-1,col-3, map.length, map[0].length)&&answer[row-1][col-3]==0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                    else if(i == 10
                            && inMap(row-1,col+1, map.length, map[0].length)&& answer[row - 1][col + 1] == 0
                            && inMap(row,col+1, map.length, map[0].length)&& answer[row][col + 1] == 0
                            && inMap(row-1,col+2, map.length, map[0].length)&& answer[row-1][col+2]==0
                            && inMap(row,col+2, map.length, map[0].length)&&answer[row][col+2]==0
                            && inMap(row-1,col+3, map.length, map[0].length)&&answer[row-1][col+3]==0) {
                        answer[newR][newC] = newAns;
                        queue.offer(new Point(newR,newC));
                    }
                }

            }
        }
        return answer;
    }

    public static boolean inMap(int r, int c, int row, int col) {
        return (r>=0 && c>=0 && r<row && c<col);
    }
    public static void main(String[] args) {
        String[] wall = {"H.H",".HX","H.H"};
        int[][] answer = solution(wall);
        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[0].length;j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
