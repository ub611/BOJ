import java.util.*;

public class Main {
	static int dp[];
	static int arr[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];
		arr = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[2] + dp[1];
		
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
		}
		
		System.out.println(dp[n]);

	}
}
