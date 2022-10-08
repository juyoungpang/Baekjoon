package myPrivate;

import java.util.*;
import java.util.stream.Collectors;

class dev1 {
    public static String solution(String[] registered_list, String new_id) {
//        String answer = new_id;

//        List<String> list = Arrays.asList(registered_list);
//
//        int index_of_N = 3;
//        while (index_of_N < new_id.length() && new_id.charAt(index_of_N) > 'a') index_of_N++;
//        int n = (index_of_N < new_id.length()) ? Integer.parseInt(new_id.substring(index_of_N)) : 0;
//
//        while(list.contains(answer)) {
//            answer = answer.substring(0,index_of_N)+(++n);
//        }

        if(!Arrays.asList(registered_list).contains(new_id)) return new_id;

        int index_of_N = 3;
        while (index_of_N < new_id.length() && new_id.charAt(index_of_N) > 'a') index_of_N++;
        int n = (index_of_N < new_id.length()) ? Integer.parseInt(new_id.substring(index_of_N)) : 0;

        final String S = new_id.substring(0,index_of_N);
        final int finalIndex_of_N = index_of_N;

        List<Integer> list = new ArrayList<>();

        for(String id:registered_list) {
            if(id.length()>finalIndex_of_N && id.substring(0,finalIndex_of_N).equals(S) && Integer.parseInt(id.substring(finalIndex_of_N))>n)
                list.add(Integer.parseInt(id.substring(finalIndex_of_N)));
        }

        Collections.sort(list);

        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i)+1!=list.get(i+1)) return S+(list.get(i)+1);
        }

        return S+(list.get(list.size()-1)+1);
    }

    public static void main(String[] args) {
        String[] r = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String i = "cow";
        System.out.println(solution(r,i));
    }
}