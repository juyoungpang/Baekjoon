package implementation;

import java.io.*;
import java.util.*;

public class g3_14890 {
	static int N, L, numRoads;
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		L = Integer.parseInt(tok.nextToken());
		
		map = new int[N][N];
		numRoads = 2*N;
		
		for(int i=0;i<N;i++) {
			tok = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.println("row: "+i);
			simulate(map[i]);
			int[] temp = new int[N];
			for(int j=0;j<N;j++) {
				temp[j] = map[j][i];
			}
			System.out.println("column"+i);
			simulate(temp);
		}
		
		System.out.println(numRoads);
		
		br.close();
	}
	
	public static void simulate(int[] arr) {
		print(arr);
		int[] slope = new int[arr.length];
		
		int curHeight = arr[0];
		
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==curHeight) continue;
			if(Math.abs(curHeight-arr[i])>1) {
				numRoads--;
				return;
			}
			
			if(arr[i]>curHeight) {
				curHeight = arr[i];
				for(int j=i-L;j<i;j++) {
					if(j<0 || slope[j]==1 || arr[j]!=curHeight-1) {
						numRoads--;
						return;
					}
				}
				for(int j=i-L;j<i;j++) {
					slope[j]=1;
				}
			} else if(arr[i]<curHeight) {
				for(int j=i+L-1;j>i;j--) {
					if(j>=arr.length || slope[j]==1 || arr[j]!=curHeight-1) {
						numRoads--;
						return;
					}
				}
				for(int j=i+L-1;j>=i;j--) {
					slope[j]=1;
				}
				curHeight = arr[i];
			}
		}
	}
	
	public static void print(int[] arr) {
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n---------------------------");
	}
}
