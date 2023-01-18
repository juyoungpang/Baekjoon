package S4;
import java.util.Scanner;

public class p1244_impl {
	
	static boolean[] switches;
	
	static final int MALE = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // number of switches
		switches = new boolean[N]; //0==false==off, 1==true==on
		for(int i=0;i<N;i++) {
			switches[i] = sc.nextInt()==1?true:false;
		}
		
		int S = sc.nextInt(); // num of students
		
		for(int i=0;i<S;i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt()-1; // index여야해서 1빼기
			
			if(gender == MALE) {
				male(num);
			} else female(num);
		}
		
		for(int i=0;i<N;i++) {
			System.out.print((switches[i]?1:0)+" ");
			if((i+1)%20==0) System.out.println();
		}
	}
	
	public static void male(int num) {
		for(int i=num;i<switches.length;i+=(num+1)) {
			switches[i] = !switches[i];
		}
	}
	
	public static void female(int num) {
		int left = num-1;
		int right = num+1;
		
		if(left<0 || right>=switches.length) {
			switches[num] = !switches[num];
			return;
		}
		
		while(left>=0 && right<switches.length) {
			if(switches[left]!=switches[right]) break;
			left--;
			right++;
		}
		
		for(int i=left+1;i<right;i++) {
			switches[i] = !switches[i];
		}
	}
}