package Line_private;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

class q1 {
    public static void main(String[] args){
        String[] logs = {"morgan string_compare", "felix string_compare", "morgan reverse", "rohan sort", "andy reverse", "morgan sqrt"};
        String[] ans = solution(logs);
        for(String a:ans) System.out.println(a);
    }

    public static String[] solution(String[] logs) {
        Set<String> temp = new HashSet<String>(Arrays.asList(logs));
        String[] uniqueLogs = temp.toArray(new String[temp.size()]);

        HashMap<String, Integer> problems = new HashMap<>();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        int userMin;

        for(String log:uniqueLogs) {
            String user = log.split(" ")[0];
            String problem = log.split(" ")[1];

            if(!users.contains(user)) users.add(user);
            
            if(problems.containsKey(problem)) problems.put(problem, problems.get(problem)+1);
            else problems.put(problem,1);
        }

        userMin = (int)Math.ceil((double)users.size()/2);

        for(Entry<String, Integer> entry: problems.entrySet()) {
            if(entry.getValue()>=userMin) answer.add(entry.getKey());
        }

        String[] ans = answer.toArray(new String[answer.size()]);
        Arrays.sort(ans);

        return ans;
    }
}