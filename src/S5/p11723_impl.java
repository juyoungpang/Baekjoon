package S5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p11723_impl {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();
		
		Integer[] defaultArr = new Integer[20];
		for(int i=0;i<20;i++) {
			defaultArr[i] = i+1;
		}
		
		Set<Integer> set = new HashSet<>();
		int M = Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++) {
			String[] input = br.readLine().split(" ");
			int in=0;
			if(input.length>1) in = Integer.parseInt(input[1]);
			switch(input[0]) {
			case "add":
				set.add(in);
				break;
			case "remove":
				set.remove(in);
				break;
			case "check":
				sb.append(set.contains(in)?1:0).append("\n");
				break;
			case "toggle":
				if(set.contains(in)) set.remove(in);
				else set.add(in);
				break;
			case "all":
				set = new HashSet<>(Arrays.asList(defaultArr));
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}