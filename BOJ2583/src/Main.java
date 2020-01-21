import java.util.*;

public class Main {
	static int map[][];
	static int visit[][];
	static ArrayList<Integer> ans;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int ret = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		ans = new ArrayList<Integer>();
		map = new int[n][m];
		visit = new int[n][m];

		for(int i = 0; i < k; i++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();

			paint(x1, x2, y1, y2);
		}

	//	print();


		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(map[i][j] == 0 && visit[i][j] == 0) {
					dfs(i, j);
					if(ret > 0) {
						ans.add(ret);
						ret = 0;
					}

				}
			}
		}

		Collections.sort(ans);

		System.out.println(ans.size());
		
		for(int t : ans) {
			System.out.print(t + " ");
		}

		sc.close();
	}

	public static void dfs(int x, int y) {
		if(map[x][y] == 1 || visit[x][y] == 1)
			return;

		ret++;
		visit[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];

			if(tx < map.length && ty < map[0].length && tx >= 0 && ty >= 0) {
				if(map[tx][ty] == 0 && visit[tx][ty] == 0) {
					dfs(tx, ty);
				}	
			}
		}
	}

	public static void paint(int x1, int x2, int y1, int y2) {
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				map[i][j] = 1;
			}
		}
	}

	public static void print() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}

			System.out.println("");
		}

		System.out.println("");
	}

}
