import java.util.Scanner;


//Note .class
public class Main {
	static int map[][];
	static int visit[][];
	static int visitd[][];
	static int ans;
	static int tmp;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n][m];
		visit = new int[n][m];
		visitd = new int[n][m];

		ans = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}	
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0 && visitd[i][j] == 0)
					dfs(i, j, 0);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt == 3) {
			getArea(map);
			if(Math.max(tmp, ans) == tmp)
				print();
			ans = Math.max(ans, tmp);
			return;
		}
		
		if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || visitd[x][y] == 1 || map[x][y] != 0)
			return;
		
		
		for(int i = 0; i < 4; i++) {
			map[x][y] = 1;
			visitd[x][y] = 1;
			dfs(x + dx[i] , y + dy[i] , cnt + 1);
			map[x][y] = 0;
			visitd[x][y] = 0;
		}
		

	}
	
	
	public static void getArea(int[][] arr) {	//0의 개수 구하기 위한 dfs함수 호출하는 함수
		tmp = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(map[i][j] == 0 && visit[i][j] == 0) {
					virusDfs(i, j);
				}
			}
		}
	}
	
	public static void virusDfs(int x, int y) {		//0의 개수 구하기
		if(x >= map.length || y >= map[0].length || x < 0 || y < 0 || map[x][y] == 1 || visit[x][y] == 1) {
			return;
		}
		
		if(map[x][y] == 2) {
			tmp = 0;
			return;
		}
		
		tmp++;
		visit[x][y] = 1;
				
		for(int i = 0; i < 4; i++) {
			virusDfs(x + dx[i], y + dy[i]);
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
