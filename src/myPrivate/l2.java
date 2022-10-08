package myPrivate;

import java.util.Arrays;
import java.util.StringTokenizer;

class l2 {
    public String solution(int k, String[] dic, String chat) {
        String answer = "";

        StringTokenizer tok = new StringTokenizer(chat);

        while(tok.hasMoreTokens()) {
            answer+=changeWord(k,dic,tok.nextToken())+" ";
        }

        return answer;
    }

    public String changeWord(int k, String[] dic, String word) {
        //정확한 매치가 있는경우 --> 비속어
        if(Arrays.stream(dic).anyMatch(s -> s.equals(word))) return censor(word);
        //정확한 매치가 없으면서 "."이 없는 경우 --> 비속어 아님
        if(!word.contains(".")) return word;

//        //단어가 하나도 없는 경우
//        int wordCase = 1;
//
//        boolean startsWithDot = word.startsWith(".");
//        boolean endsWithDot = word.endsWith(".");
//
//        if(!startsWithDot && !endsWithDot) wordCase = 2;    //단어로 시작해서 단어로 끝나는 경우
//        else if(!startsWithDot) wordCase = 3;               //단어로 시작해서 .으로 끝나는 경우
//        else if(!endsWithDot) wordCase = 4;                 //.으로 시작해서 단어로 끝나는 경우
//
//
//
//        String[] arr = word.split("\\.");

        String stringformat = "";
        for(int i=0;i<word.length();i++) {
            if(!word.substring(i,i+1).equals(".")) stringformat+=word.substring(i,i+1);
            else {
                for(int j=0;j<k;j++) {
                    stringformat+="%r";
                }
            }
        }

        return "A";
    }

    public String censor(String word) {
        String ret = "";
        for(int i=0;i<word.length();i++) ret+="#";
        return ret;
    }

    public static void main(String[] args) {
        String word = "..T";
        String[] arr = word.split("\\.");
        System.out.println(arr.length);
        for(String a:arr) System.out.println(a);
    }
}