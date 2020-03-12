//자리배정
import java.util.Scanner;
/*
1, 1 	1, 2		1, 3	1, 4	1, 5	1, 6	1, 7	
2, 1 	2, 2		2, 3	2, 4	2, 5	2, 6	2, 7	
3, 1 	3, 2		3, 3	3, 4	3, 5	3, 6	3, 7	
4, 1 	4, 2		4, 3	4, 4	4, 5	4, 6	4, 7	
5, 1	 	5, 2		5, 3	5, 4	5, 5	5, 6	5, 7	
6, 1	 	6, 2		6, 3	6, 4	6, 5	6, 6	6, 7	
 */

public class Main {
	static int[] dx = { 1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] map = new int[n + 1][c + 1];

		if(n * c < k) {
			System.out.println("0");
			return;
		}

		int num = 1;
		int x = 0;
		int y = 1;
		int idx = 0;

		while(num <= k) {
			int tx = x + dx[idx];
			int ty = y + dy[idx];

			if(tx > n || ty > c || tx < 1 || ty < 1 || map[tx][ty] != 0) {
				idx++;
				idx %= 4;
				continue;
			}

			x = tx; y = ty;
			map[x][y] = num++;

		}
		
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= c; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println("");
//		}

		System.out.println(y + " " + x);

	}

}
