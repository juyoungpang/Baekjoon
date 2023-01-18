package S4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10158_math {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(tok.nextToken());
		int h = Integer.parseInt(tok.nextToken());
				
		tok = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(tok.nextToken());
		int q = Integer.parseInt(tok.nextToken());

		int t = Integer.parseInt(br.readLine());

		p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        if (p > w) p = 2 * w - p;
        if (q > h) q = 2 * h - q;

		StringBuilder sb = new StringBuilder();
		sb.append(p).append(" ").append(q);
		
		System.out.println(sb);
	}
}