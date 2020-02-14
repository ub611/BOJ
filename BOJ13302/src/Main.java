//리조트
//https://chw0501.tistory.com/12
import java.util.Scanner;

public class Main {
	static int arr[];
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 		//day of vacation
		int m = sc.nextInt();
		
		arr = new int[n + 1];
		dp = new int[n + 1][50];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			arr[a] = 1;	
		}
		
		System.out.println(func(1, 0));
	}
	
	public static int func(int day, int cp) {
		if(day >= arr.length) {
			return 0;
		}
		
		if(arr[day] == 1)
		{
			dp[day][cp] = func(day + 1, cp);
			return dp[day][cp];
		}
		
		if(dp[day][cp] != 0) {
			return dp[day][cp];
		}
		
		int ans = Integer.MAX_VALUE;
		
		ans = Math.min(ans, 10000 + func(day + 1, cp));
		ans = Math.min(ans, 25000 + func(day + 3, cp + 1));
		ans = Math.min(37000 + func(day + 5, cp + 2), ans);
		
		if(cp >= 3) {
			ans = Math.min(ans, func(day + 1, cp - 3));
		}
		
		dp[day][cp] = ans;
		
		return dp[day][cp];
	}

}
