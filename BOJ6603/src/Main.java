import java.util.*;

public class Main {
	static int dp[];
	static int arr[];
	static int k = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(k!=0) {
			k = sc.nextInt();
			if(k == 0)
				break;
			arr = new int[k];
			dp = new int[k];
			
			for(int i = 0; i < k; i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(arr, 0, 0);
			System.out.println("");
		}
	}
	
	public static void dfs(int[] arr, int cnt, int idx) {
		if(cnt == 6) {
			for(int i = 0; i < k; i++) {
				if(dp[i] == 1)
					System.out.print(arr[i] + " " );
			}
			System.out.println("");	
		}
		
		for(int i = idx; i < k; i++) {
			dp[i] = 1;
			dfs(arr, cnt + 1, i + 1);
			dp[i] = 0;
		}
	}

}
