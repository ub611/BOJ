import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] dp;
	static int ans;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String t = sc.next();
			String tarr[] = t.split("");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(tarr[j]);
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ans = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dfs(i, j);
				if(ans > 0) {
					arr.add(ans);
					ans = 0;
				}
			}
		}
		
		Collections.sort(arr);		//Arrays.sort(arr.toArray()) 의 경우 정렬이 잘 안됐음 ㅠ 		
		System.out.println(arr.size());
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}
	
	public static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= map.length || y >= map.length || map[x][y] == 0 || dp[x][y] == 1)
			return;
		
		dp[x][y] = 1;
		ans++;
		
		for(int i = 0; i < 4; i++) {
			dfs(x + dx[i] , y + dy[i]);
		}
		
	}

}
