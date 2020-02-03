//수열
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();		//k만큼의 일수
		int input[] = new int[n];
		int dp[] = new int[n];		//n 최대 10만개까지 가능 -> On2 -> 시간초과
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		dp[0] = input[0];
		
		for(int i = 1; i < k; i++) {
			dp[i] = dp[i - 1] + input[i];
		}
		
		int max = dp[k - 1];
		
		for(int i = k; i < n; i++) {
			dp[i] = dp[i - 1] - input[i - k] + input[i];
			max = max > dp[i] ? max : dp[i];
		}
		
		System.out.println(max);
		
		
	}

}
