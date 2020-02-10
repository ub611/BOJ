///파이프 옮기기
import java.util.Scanner;
public class Main {
	static int map[][];
	static int n;
	static int ans = 0;

	public static class Info{
		int r;
		int c;
		int p;		//1 : 가로  2 : 세로 3 : 대각선

		public Info(int r, int c, int p) {
			this.r = r;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 2, 1);		//여기서 한 번 움직이고 나 ㄴ후를 호출해야함, 가로로 되어있는게 기본이니 세로로는 움직일 수 없음
		dfs(1, 2, 3);

		System.out.println(ans);

	}

	public static void dfs(int x, int y, int p) {
		if(x > n - 1 || y > n - 1 || x < 0 || y < 0 || map[x][y] == 1) {
			return;
		}

		
		//대각선으로 움직이는 경우 비어야하는 칸에 벽(1)이 있으면 리턴
		if(p == 3 && ((x - 1 >= 0 && map[x - 1][y] == 1) || (y - 1 >= 0 && map[x][y - 1] == 1))) {
			return;
		}


		if(x == n - 1 && y ==  n - 1) {
			ans++;
			return;
		}
		
		if(p == 1 || p == 3) 
			dfs(x, y + 1, 1);
		
		if(p == 2 || p == 3)
			dfs(x + 1, y, 2);
		
		dfs(x + 1, y + 1, 3);

	}

}
