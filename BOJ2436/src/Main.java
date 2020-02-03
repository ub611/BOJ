//공약수
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int m = sc.nextInt();

		long mul = (long)m*(long)n;
		int a = n;
		int b = m;
		int tm = m;
		
		for(int i = n; i < tm; i += n) {
			if(mul % i != 0) {
				continue;
			}

			tm = (int) (mul / i);
			int gcd = gcd(tm, i);

			
			if((long)tm * (long)i != (long)m * (long)n || gcd != n)
				continue;
			
//			System.out.println(tm + " " + i + " " + gcd);

			if(tm + i < a + b) {
				a = i;
				b = tm;

			}

		}

		System.out.println(a + " " + b);

		sc.close();

	}

	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else {
			return gcd(b, a % b);
		}
	}
}
