//안전영역 
import java.util.*;

public class Main {
	static int ans;
	static int[][] arr;
	static int[][] tmp;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, -1, 1, 0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		tmp = new int[n][n];
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				max = max > arr[i][j] ? max : arr[i][j];
			}
		}
		
		int cnt = 0;
		int res = 0;
		
		for(int i = 0; i < max; i++) {
			tmp = new int[n][n];
			cnt = 0;
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					dfs(i, j, k);
					if(ans > 0) {
//						System.out.println(k + ", " + j + " " + ans);
						cnt++;
					}
					ans = 0;
				}
			}		
			
			res = res > cnt ? res : cnt;
		}
		
		System.out.println(res);
			
	}
	
	public static void dfs(int k, int x, int y) {	
		if(x < 0 || y < 0 || x >= arr.length || y >= arr.length || arr[x][y] <= k || tmp[x][y] == 1) {		//잠긴곳이면 return
			return;
		}
		
		tmp[x][y] = 1;
		ans++;
		
		for(int i = 0; i < 4; i++) {
			dfs(k, x + dx[i], y + dy[i]);
		}
	}
	
	public static void cpyMap() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
	}

}
