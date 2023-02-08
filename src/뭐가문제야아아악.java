import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class 뭐가문제야아아악 {
	public static void main(String[] args) {
		int N = 1;
		while (N <= 8) {
			try {
				int a = 1;
				int b = 1;

				while (a <= 300) {
					File fileName = new File("test_case.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
					
					bw.write(N + "\n");
					bw.write(a + " " + b + "\n");
					bw.close();

					int 내꺼 = MyMain.main();
					int 쟤꺼 = Main.main();

					if (내꺼 != 쟤꺼) {
						System.out.println("이거다 멍충아");
						return;
					}
					b++;
					if(b==300) {
						a++;
						b=1;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			N++;
		}
	}
}
