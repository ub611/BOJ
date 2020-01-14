import java.util.*;

/*

 */

public class Main {
	static int map[][];
	static int dp[][];
	static int dx[] = {1, 0, 0, -1};
	static int dy[] = {0, 1, -1, 0};

	static class Point{
		int x;
		int y;

		public Point(int a, int b) {
			this.x = a;
			this.y = b;
		}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		map = new int[x][y];
		dp = new int[x][y];

		for(int i = 0; i < x; i++) {
			String t = sc.next();
			for(int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(t.substring(j, j + 1));
			//	dp[i][j] = 0;
			}
		}
		
		bfs(0, 0);
		System.out.println(dp[x - 1][y - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		dp[x][y] = 1;

		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				
				if(tx < 0 || ty < 0 || tx >= map.length || ty >= map[0].length) {
					continue;
				}

				if(map[tx][ty] == 1) {
					if(dp[tx][ty] > 0) {		//이미 방문한 적이 있는 곳이면 지금 경로가 더 빠른가 원래가 빠른가 확인 
						//이미 방문한 경우면 큐에 이미 들어가 있으니 add 필요 없
						dp[tx][ty] = dp[p.x][p.y] + 1 > dp[tx][ty] ? dp[tx][ty] : dp[p.x][p.y] + 1;
					}
					else {		
						dp[tx][ty] = dp[p.x][p.y] + 1;
						q.add(new Point(tx, ty));
					}
				}
			}
		}
		
	}
}
