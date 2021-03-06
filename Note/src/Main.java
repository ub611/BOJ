//두 로봇
import java.util.*;

public class Main {
	public static class Info{
		int t;
		int f;
		int v;
	}
	static int map[][];
	static int n;
	static boolean ck[];
	static int ans = 0;
	static int ret;
	static int max = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		ck = new boolean[n + 2];
		map = new int[n + 2][n + 2];
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i = 1; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int v = sc.nextInt();

			map[x][y] = v;
			map[y][x] = v;
		}
		int max = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			if(t == b) {
				
			}
			
			for(int i = 1; i <= n; i++) {
				if(map[t][i] != 0) {
					q.add(i);
				}
			}
		}
		

//		dfs(Math.min(a, b), Math.max(a, b));
		System.out.println(ans);


	}

	public static void dfs(int x, int y) {		
		if(x == y) {
			ret -= max;
			ans = Math.max(ans, ret);
			return;
		}
		
		if(ck[x]) {
			return;
		}
		
		ck[x] = true;
			
		for(int i = 1; i <= n; i++) {
			if(map[x][i] != 0 && !ck[i]){
				int tmp = max;
				
				ret += map[x][i];
				max = Math.max(max, map[x][i]);
				
				dfs(i, y);
				
				ret -= map[x][i];
				max = tmp;
			}
		}
		
		
	}
}
