import java.util.*;

public class Main {
	static int map[][];
	static int dp[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	static int ans;
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		map = new int[x][y];
		dp = new int[x][y];
		int ans = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					q.add(new Point(i, j));
				}
			}
		}	
		
		//최소경로를 찾아야하기 때문에 bfs 사용
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = tmp.x + dx[i];
				int ty = tmp.y + dy[i];
				
				if(tx >= 0 && ty >= 0 && tx < x && ty < y && map[tx][ty] == 0) {
					map[tx][ty] = 1;
					q.add(new Point(tx, ty));
					dp[tx][ty] = dp[tmp.x][tmp.y] + 1;		//얘 떄문에 오래걸림 ㅠ 
					ans = dp[tx][ty];
				}	
			}	
		}
		
//		print(map);
//		print(dp);
		
		if(!check())
			System.out.println("-1");
		else 
			System.out.println(ans);
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
