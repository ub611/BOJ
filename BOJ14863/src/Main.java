//서울에서 경산까지
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int walk[][];
	static int byc[][];
	static int dp[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;

		walk = new int[n][2];
		byc = new int[n][2];
		dp = new int[101][100001];

		for(int i = 0; i < n; i++) {
			walk[i][0] = sc.nextInt();
			walk[i][1] = sc.nextInt();
			byc[i][0] = sc.nextInt();
			byc[i][1] = sc.nextInt();
		}

		dp[0][walk[0][0]] = walk[0][1];		//dp[depth][현재까지의시간] = 모금액
		dp[0][byc[0][0]] = Math.max(dp[0][byc[0][0]], byc[0][1]);

		for(int i = 1; i < n; i++) {	
			for(int j = 0; j <= k; j++) {		//이 전까지의 시간, K보다 작거나 " 같은동안 "
				int mon = dp[i - 1][j];		//모금액
				
				if(mon == 0)
					continue;

				if(j + walk[i][0] <= k) {		//이미데이터가 있을 수 있기때문에 max함수
					dp[i][j + walk[i][0]] = Math.max(dp[i][j + walk[i][0]], mon + walk[i][1]);
//					answer = Math.max(answer, dp[i][j + walk[i][0]]);

				}
				if(j + byc[i][0] <= k) {
					dp[i][j + byc[i][0]] = Math.max(dp[i][j + byc[i][0]], mon + byc[i][1]);
//					answer = Math.max(answer, dp[i][j + byc[i][0]]);		여기서 max돌리면 모든 장소를 다 돌지 않았을때 최댓값을 반환할 수 있음

				}
			}
		}
		
		for(int i = 0; i <= k; i++) {
			if(dp[n - 1][i] != 0) {
				answer = Math.max(answer, dp[n - 1][i]);		//Math만 쓰면 안돼..까먹지않기.......ㅠ
//				answer = answer > dp[n - 1][i] ? answer : dp[n - 1][i];

			}
		}

		System.out.println(answer);

	}

}
