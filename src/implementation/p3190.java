package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p3190 {

    static final int LEFT = 0, DOWN = 1, RIGHT = 2, UP = 3;
    static int N, K, L;
    static int[][] board;
    static int[] rotates;
    static Snake snake;
    static int timer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;

        snake = new Snake();

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int[] b:board) {
            Arrays.fill(b,0);
        }
        //뱀의 위치
        board[0][0] = -1;

        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++) {
            tok = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            //사과위치
            board[a-1][b-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        rotates = new int[L];
        for(int i=0;i<L;i++) {
            tok = new StringTokenizer(br.readLine());
            rotates[i] = Integer.parseInt(tok.nextToken());
            //왼쪽이면 음수
            if(tok.nextToken().equals("L")) rotates[i]*=-1;
        }

        int l = 0;
        boolean cont = true;
        while(cont) {
            timer++;
            cont = move();
            if(l<L && timer == Math.abs(rotates[l])) snake.direction = rotate(snake.direction, (rotates[l++]<0));
        }

        System.out.println(timer);
    }

    public static int rotate(int currentDirection, boolean turnLeft) {
        if(turnLeft) return (currentDirection+1)%4;
        return (currentDirection-1)<0?3:currentDirection-1;
    }
    
    public static boolean move() {
        int newHeadR = snake.getHead().row;
        int newHeadC = snake.getHead().col;
        switch(snake.direction) {
            case LEFT :
                newHeadC--;
                break;
            case RIGHT :
                newHeadC++;
                break;
            case UP :
                newHeadR--;
                break;
            case DOWN :
                newHeadR++;
                break;
            default: break;
        }
        if(newHeadC<0 || newHeadR<0 || newHeadC>=N || newHeadR>=N || board[newHeadR][newHeadC]==-1) {
            return false;
        }

        if(board[newHeadR][newHeadC]!=1) {
            Point tail = snake.delTail();
            board[tail.row][tail.col] = 0;
        }
        snake.addHead(new Point(newHeadR, newHeadC));
        board[newHeadR][newHeadC]=-1;
        return true;
    }

    public static class Snake {
        List<Point> body = new ArrayList<>();
        int direction;
        int length;

        public Snake() {
            body.add(new Point(0,0));
            direction = RIGHT;
            length = 1;
        }

        public void addHead(Point point) {
            body.add(point);
        }

        public Point delTail() {
            return body.remove(0);
        }

        public Point getHead() {
            return body.get(body.size()-1);
        }
    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

