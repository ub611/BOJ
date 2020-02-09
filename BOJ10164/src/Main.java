//격자상의 경로
import java.util.*;

public class Main {
	static int map[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		map = new int[n][m];

		int x = (k - 1) / m + 1;
		int y = (k - 1) % m + 1;
		
		int ret = 1;


		if(k == 0) {
			initMap(0, 0, n, m);
			getAns(1, 1, n, m);
		}else {
			initMap(0, 0, x, y);
			getAns(1, 1, x, y);
		
			ret = map[x - 1][y - 1];
			
			initMap(x - 1, y - 1, n, m);		
			getAns(x, y, n, m);			

		}

		System.out.println(ret * map[n -1][m - 1]);
	}
	
	public static void getAns(int x, int y, int l, int h) {
		for(int i = x; i < l; i++) {
			for(int j = y; j < h; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
	}

	public static void initMap(int srcX,  int srcY, int destX, int destY) {
		for(int i = srcX; i < destX; i++) {
			map[i][srcY] = 1;
		}

		for(int i = srcY; i < destY; i++) {
			map[srcX][i] = 1;
		}
	}
	
	public static void print(int n, int m) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
