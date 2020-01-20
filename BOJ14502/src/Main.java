import java.util.*;

public class Main {
	static int map[][];
	static int n;
	static int m;
	static int visit[][];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int ans;
	static ArrayList<Point> list;

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
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visit = new int[n][m];
		
		list = new ArrayList<Point>();

		ans = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();

				if(map[i][j] == 2)
					list.add(new Point(i, j));		//여기서 부터 바이러스 
			}
		}	

		dfs(0, 0);

		System.out.println(ans);


	}


	public static void dfs(int x, int cnt) {
		if(cnt == 3) {
			cloneMap();

			for(Point t : list) {
//				System.out.println(t.x + " " + t.y);
				VirusDfs(t.x, t.y);
			}
			
		//	print(visit);

			ans = Math.max(getArea(), ans);
			return;
		}

		for(int i = x; i < n*m; i++) {
			int ix = i/m;
			int iy = i%m;

			if(map[ix][iy] == 0) {
				map[ix][iy] = 1;
				dfs(i + 1, cnt + 1);
				map[ix][iy] = 0;
			}
		}

	}

	//바이러스 퍼트리기
	public static void VirusDfs(int x, int y) {
//				if(x >= map.length || y >= map[0].length || x < 0 || y < 0 || visit[x][y] == 1 ) {
//					return;
//				}
//		

		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];			// x += dx[i] 로 할 경우 -가 안먹혔음 -> 2로 안바껴서 함참 헤매어버렸ㄷㅏ
			int ty = y + dy[i];

			if(tx < n && ty < m && tx >= 0 && ty >= 0) {
				if(visit[tx][ty]  == 0) {
					visit[tx][ty] = 2;
					VirusDfs(tx,ty);
				}	
			}
		}
	}

		//0개수 세기
		public static int getArea() {
			int ret = 0;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(visit[i][j] == 0)
						ret++;
				}
			}

			return ret;		
		}

		public static void cloneMap() {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					visit[i][j] = map[i][j];
				}
			}
		}

		public static void print(int[][] arr) {
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}

				System.out.println("");
			}

			System.out.println("");
		}
	}
