    //insertion sort

    package sorting;
    import java.io.*;
    import java.util.*;

    public class p1427 {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int input, key=-1;
            ArrayList<Integer> nums;

            input = Integer.parseInt(br.readLine());
            nums = new ArrayList<>();
            while(input>0){
                nums.add(input%10);
                input /= 10;
            }

            for(int i=1;i<nums.size();i++){
                key = nums.get(i);
                int j = i-1;
                while(j>=0 && nums.get(j)<key){
                    nums.set(j+1,nums.get(j));
                    j--;
                }
                nums.set(j+1,key);
            }

            StringBuilder sb = new StringBuilder();
            for(int n:nums)
                sb.append(n);
            
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }
    }
