package S5;
import java.util.Scanner;

public class p2941_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		
		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		int answer = 0;
		
		for(String c:cro) {
			while(input.indexOf(c)!=-1) {
				StringBuilder temp = new StringBuilder();
				temp.append(input.substring(0,input.indexOf(c)));
				for(int i=0;i<c.length();i++) temp.append("*");
				temp.append(input.substring(input.indexOf(c)+c.length()));
				input = temp.toString();
				answer++;
			}
		}
		
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)!='*') answer++;
		}
		
		System.out.println(answer);
	}
}