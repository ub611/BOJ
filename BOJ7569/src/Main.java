//토마토
import java.util.*;

public class Main {
	static int[][][] arr;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		arr = new int[h][n][m];

		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					arr[i][j][k] = sc.nextInt();
					
					if(arr[i][j][k] == 1)
						dfs(j, k, i);
					
				}
			}
		}
		
		if(!isFull()) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
		
		print();
	}
	
	public static void print() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				for(int k = 0; k < arr[i][j].length; k++) {
					System.out.print(arr[i][j][k] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
	
	public static void dfs(int x, int y, int h) {
//		if(h < 0 || x < 0 || y < 0 || h >= arr.length || x >= arr[0].length || y >= arr[0][0].length || arr[h][x][y] == -1)
//			return;
//		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx < arr[0].length && ty < arr[0][0].length && tx >= 0 && ty >= 0 && arr[h][tx][ty] == 0) {
				arr[h][tx][ty] = 1;
				dfs(tx, ty, h);
			}
		}

		if(h + 1 < arr.length && arr[h + 1][x][y] == 0) {
			arr[h + 1][x][y] = 1;
			dfs(x, y, h + 1);
		}
		
		if(h - 1 >= 0 && arr[h - 1][x][y] == 0)
			arr[h - 1][x][y] = 1;
			dfs(x, y, h - 1);
		
	}
	
	public static boolean isFull() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				for(int k = 0; k < arr[i][j].length; k++) {
					if(arr[i][j][k] == 0)
						return false;
				}
			}
		}
		
		return true;
	}

}