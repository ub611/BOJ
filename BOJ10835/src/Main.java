//카드 게임
import java.util.*;

public class Main {
	static int a[];
	static int b[];
	static int dp[][];
	static int ans = 0;
	static int ret = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n];
		b = new int[n];
		dp = new int[n + 1][n + 1];
		
		for(int j = 0; j < n; j++) {
			a[j] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] = -1;			//0으로 초기화 안해주면 0점을 얻는 경우 시간초과 남
			}
		}
		
		System.out.println(func(0, 0));

	}
	
	public static int func(int aidx, int bidx) {		//아래에서부터 채워옴
		if(aidx == a.length || bidx == b.length) {
			return 0;
		}
				
		if(dp[aidx][bidx] != -1) {		
			return dp[aidx][bidx];
		}
		
		dp[aidx][bidx] = Math.max(func(aidx + 1, bidx + 1), func(aidx + 1, bidx));		//1번의 경우, 둘 다 버릴때 or 왼쪽만 버릴때 경우중에서 가장 큰 값을 뽑을 경우
		
		if(a[aidx] > b[bidx]) {		//오른쪽 카드가 왼쪽보다 작으면
			dp[aidx][bidx] = Math.max(dp[aidx][bidx], func(aidx, bidx + 1) + b[bidx]);
		}
		
		return dp[aidx][bidx];	
	}

}
