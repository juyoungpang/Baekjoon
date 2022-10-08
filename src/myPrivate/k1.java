//package myPrivate;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class k1 {
//    public int[] solution(String today, String[] terms, String[] privacies) {
//        Map<String, Integer> termsMap = new HashMap<>();
//        for (String term : terms) {
//            String[] s = term.split(" ");
//            termsMap.put(s[0], Integer.parseInt(s[1]));
//        }
//
//        Date dateToday = new Date(today);
//
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < privacies.length; i++) {
//            String[] p = privacies[i].split(" ");
//            Date date = new Date(p[0]);
//            date.monthsPassed(termsMap.get(p[1]));
//            if (date.compareTo(dateToday) > 0) ans.add(i + 1);
//        }
//
//        int[] answer = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
//        return answer;
//    }
//}
//
//class Date implements Comparable{
//    int year;
//    int month;
//    int day;
//
//    final int DAYSINMONTH = 28;
//
//    public Date(String date) {
//        String[] d = date.split("\\.");
//        this.year = Integer.parseInt(d[0]);
//        this.month = Integer.parseInt(d[1]);
//        this.day = Integer.parseInt(d[2]);
//    }
//
//    public void monthsPassed(int months) {
//        this.day+=months*DAYSINMONTH;
//
//        if(this.day>DAYSINMONTH) {
//            this.month+=this.day/DAYSINMONTH;
//            this.day=this.day%DAYSINMONTH;
//        }
//
//        if(this.month>12) {
//            this.year+=this.month/12;
//            this.month=this.month%12;
//        }
//
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        Date date = (Date)o;
//        if(this.year < date.year) return 1;
//        else if(this.year == date.year && this.month < date.month) return 1;
//        else if(this.year == date.year && this.month == date.month && this.day < date.day) return 1;
//        else if(this.year == date.year && this.month == date.month && this.day == date.day) return 0;
//        else return -1;
//    }
//}