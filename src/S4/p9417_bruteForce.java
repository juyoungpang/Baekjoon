package S4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class p9417_bruteForce {
	
	static Map<Integer, Map<Integer,Integer>> cache = new HashMap<>();
	
	static int answer;
	static List<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0;n<N;n++) {
			answer = Integer.MIN_VALUE;
			
			arr = new ArrayList<>();
			StringTokenizer tok = new StringTokenizer(br.readLine());
			
			while(tok.hasMoreTokens()) {
				arr.add(Integer.parseInt(tok.nextToken()));
			}
			
			Collections.sort(arr);
			
			run();
			
			System.out.println(answer);
		}
	}
	
	public static void run() {
		for(int i=0;i<arr.size()-1;i++) {
			int smallNum = arr.get(i);
			for(int j=i+1;j<arr.size();j++) {
				int bigNum = arr.get(j);
				int gcd = gcd(bigNum, smallNum);
				answer = Math.max(answer, gcd);
			}
		}
	}
	
	public static int gcd(int bigNum, int smallNum) {
		if(smallNum==0) {
			return bigNum;
		}
		
		if(cache.containsKey(smallNum) && cache.get(smallNum).containsKey(bigNum)) {
			return cache.get(smallNum).get(bigNum);
		}
		
		int gcd = gcd(smallNum, bigNum%smallNum);
		
		if(!cache.containsKey(smallNum)) {
			cache.put(smallNum, new HashMap<>());
		}
		cache.get(smallNum).put(bigNum, gcd);
		
		return gcd;
	}
}