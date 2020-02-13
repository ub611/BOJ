//벨트
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int p = sc.nextInt();
		long next = sc.nextInt();
		int flag = sc.nextInt();

		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			flag += sc.nextInt();

			if(a > next) {
				next = b;
			}else {
				next = (long)((next / a) * b);
			}
		}
		
		if(flag != 0) {		//zeroDivde
			flag = flag % 2 == 0 ? 0 : 1;
		}
		
		System.out.println(flag + " " + next);
	}
}
