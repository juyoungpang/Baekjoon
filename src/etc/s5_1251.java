package etc;

import java.util.Scanner;

public class s5_1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String ans = Character.toString('z'+1);

        for(int i=1;i<str.length()-1;i++) {
            for(int j=i+1;j<str.length();j++) {
                String temp = divide(str,i,j);
                ans = ans.compareTo(temp)>0?temp:ans;
            }
        }

        System.out.println(ans);
    }

    public static String divide(String stringOriginal, int s1, int s2) {
        String ret = "";
        ret+=flip(stringOriginal.substring(0,s1));
        ret+=flip(stringOriginal.substring(s1,s2));
        ret+=flip(stringOriginal.substring(s2,stringOriginal.length()));
        return ret;
    }

    public static String flip(String substring) {
        String ret = "";
        for(int i=substring.length()-1;i>=0;i--) {
            ret+=substring.substring(i,i+1);
        }
        return ret;
    }
}
