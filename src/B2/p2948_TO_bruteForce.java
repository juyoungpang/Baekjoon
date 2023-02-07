package B2;
import java.util.Scanner;

public class p2948_TO_bruteForce {
	
	static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int M = sc.nextInt();
		
		int day = 3;
		
		int d=1;
		int m=1;
		
		while(d!=D || m!=M) {
			day = (day+1)%7;
			d++;
			
			if((d==29 && m==2) || 
					(d==30 && (m==4||m==6||m==9||m==11)) ||
					(d==31 && (m==1||m==3||m==5||m==7||m==8||m==10||m==12))) {
				m++;
				d=1;
			} 
		}
		
		System.out.println(days[day]);
	}
}