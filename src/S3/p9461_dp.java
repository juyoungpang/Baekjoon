package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p9461_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Long> dp = new ArrayList<>(Arrays.asList(0L, 1L, 1L, 1L, 2L, 2L, 3L));

        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            if(dp.size()>n) {
                sb.append(dp.get(n)).append("\n");
            }
            else {
                for(int i=dp.size();i<=n;i++) {
                    dp.add(dp.get(i-2)+dp.get(i-3));
                }
                sb.append(dp.get(n)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
