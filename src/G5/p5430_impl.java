package G5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p5430_impl {
	static List<Integer> list;
	static boolean front, flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			String input = br.readLine();
			flag = false;
			front = true;
			br.readLine();
			toAL(br.readLine());
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 'R') {
					reverse();
				} else {
					delete();
				}

				if (flag)
					break;
			}
			if (flag)
				continue;
			alToString();
		}
		
		System.out.print(sb.toString());
	}

	public static void reverse() {
		front = !front;
	}

	public static void delete() {
		try {
			if (front) {
				list.remove(0);
			} else {
				list.remove(list.size() - 1);
			}
		} catch (Exception e) {
			sb.append("error\n");
			flag = true;
		}
	}

	public static void toAL(String str) {
		list = new ArrayList<>();
		str = str.substring(1, str.length() - 1);
		StringTokenizer tok = new StringTokenizer(str, ",");
		while (tok.hasMoreTokens()) {
			list.add(Integer.parseInt(tok.nextToken()));
		}
	}

	public static void alToString() {
		if(list.size()==0) {
			sb.append("[]\n");
			return;
		}
		
		sb.append("[");
		if (front) {
			for (int n : list) {
				sb.append(n).append(",");
			}
		} else {
			for(int i=list.size()-1;i>=0;i--) {
				sb.append(list.get(i)).append(",");
			}
		}
	if(sb.length()>1) sb.setLength(sb.length() - 1);
		sb.append("]\n");
	}
}