//색종이
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans[] = new int[n + 1];
		int map[][] = new int[101][101];

		for(int i = 1; i <= n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int l = sc.nextInt();
			int h = sc.nextInt();

			for(int j = x; j < x + l; j++) {
				for(int k = y; k < y + h; k++) {
					if(map[j][k] != 0) {
						ans[map[j][k]]--;
					}
					map[j][k] = i;
					ans[i]++;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.println(ans[i]);
		}

	}
}
