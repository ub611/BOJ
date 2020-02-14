//타일 장식물
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		long[] dp = new long[k + 1];
		
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= k; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		long ans = dp[k] * 2 + dp[k - 1] * 2;
		
		System.out.println(ans);
	}

}
