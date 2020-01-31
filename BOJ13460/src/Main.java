import java.util.*;

public class Main {
	static char map[][];
	static int dx[] = {1, 0, 0, -1};
	static int dy[] = {0, 1, -1, 0};
	static int ans = 0;
	static int max = 0;
	static int n;
	static int m;
	static char tmp[][];

	static public class Point{
		int x;
		int y;
		char c;

		public Point(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static Point R;
	static Point B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new char[n][m];

		// ----- start input ------

		for(int i = 0; i < n; i++) {
			String str = sc.next();
			char[] tmp = str.toCharArray();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp[j];

				if(tmp[j] == 'R') {
					R = new Point(i, j, 'R');
				}else if(tmp[j] == 'B') {
					B = new Point(i, j, 'B');
				}
			}
		}
		// ----- end of input ----
		
		cpyMap();
		
		for(int i = 1; i < 5; i++) {
			if(move(i) > 0)
				max = ans > max ? max : ans;
				cpyTmp();
		}
	
		if(max == 0)
			System.out.println("-1");
		else
			System.out.println(max);

	}

	public static void cpyTmp() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
	
	public static void cpyMap() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}

	//dir = 1 (위) 2 (오른) 3 (아래) 4 (왼)
	public static int move(int dir) {
		if(ans > 10)
			return -1;
		
		ans++;
		
		for(int i = 0; i < 3; i++) {
			int x;
			int y;
			char c;
			
			if(i == 0 || i == 2) {
				x = R.x;
				y = R.y;
				c = R.c;
			}
			else {
				x = B.x;
				y = B.y;
				c = B.c;
			}
			
			do {
				switch(dir) {
				case 1 : 
					x++;
					break;
				case 2:
					y++;
					break;
				case 3:
					x--;
					break;
				case 4:
					y--;
					break;
				}
				if(map[x][y] == 'O') {
					return ans;
				}
				map[x][y] = c;
			}while(map[x][y] == '.' || x >= 0 || y >= 0 || x < n || y < m) ;
		}
		
		for(int i = 1; i < 5; i++) {
			if(move(i) > 0) {
				max = ans > max ? max : ans;
			}
			
			
			
		}
		return ans;
	}

}