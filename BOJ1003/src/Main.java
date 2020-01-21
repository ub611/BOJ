import java.util.*;

public class Main {
	
	static int dp[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		dp = new int[41]; 	// 0 <= n <= 40 & 0 or 1 저장 
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			fib(n);
			
			if(n == 0) {
				System.out.println("1 0");
			}else if(n == 1) {
				System.out.println("0 1");
			}else {
				System.out.println(dp[n - 2] + " " + dp[n - 1]);
			}
			
		}
		
		
	}
	
	public static int fib(int n) {
		if(dp[n] != 0)
			return dp[n];
		
		if(n == 0) {
			return 0;
		}
		
		else if(n == 1 ) {
			return 1;
		}
		else {
			dp[n] = fib(n - 2) + fib(n - 1);
			return dp[n];
		}
		
	}

}
