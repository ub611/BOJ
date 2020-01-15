import java.util.Scanner;

public class Main {
	static int map[][];
	static int dp[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();

		map = new int[x][y];
		dp = new int[x][y];
		ans = 0;

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)
					dfs(i, j);
			}
		}

//		if(check()) {
//			System.out.println("0");
//			return;
//		}
		
		if(!check())
			System.out.println("-1");
		else 
			System.out.println(ans);


	}

	public static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == -1 || dp[x][y] == 1 || check())
			return ;

		dp[x][y] = 1;
		map[x][y] = 1;

		for(int i = 0; i < 4; i++) {
			dfs(x + dx[i], y + dy[i]);
		}

		ans++;

	}

	public static boolean check() {		//다 익었나 확인
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0)
					return false;
			}
		}

		return true;
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
	}

}
