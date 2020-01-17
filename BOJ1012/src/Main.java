import java.util.*;

public class Main {
	static int cnt;
	static int[][] dp;
	static int[][] map;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int idx = 0; idx < tc; idx++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cabCnt = sc.nextInt();
			int ans = 0;
			
			map = new int[x][y];
			dp = new int[x][y];
			
			for(int i = 0; i < cabCnt; i++) {
					int tx = sc.nextInt();
					int ty = sc.nextInt();
					
					map[tx][ty] = 1;
				
			}
			
			for(int i = 0; i < x; i++) {
				for(int j = 0; j < y; j++) {
					dfs(i, j);
					if(cnt > 0) {
						ans++;
						cnt = 0;
					}
				}
			}
			
			System.out.println(ans);
			
		}
	}
	
	public static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 0 || dp[x][y] == 1)
			return;
		
		dp[x][y] = 1;
		
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			dfs(x + dx[i], y + dy[i]);
		}
	}

}
