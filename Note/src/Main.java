//서울에서 경산까지
import java.util.*;

public class Main {
	public static class Info{
		int t;
		int m;
		
		public Info(int t, int m) {
			this.m = m;
			this.t = t;
		}
		
	}
	static Info arr[][];
	static int dp[][];
	static boolean check[];
	static int n;
	static int k;
	static int ans = 0;
	static int ret = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		check = new boolean[n];
		arr = new Info[n][2];
		dp = new int[n][100001];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = new Info(sc.nextInt(), sc.nextInt());
			arr[i][1] = new Info(sc.nextInt(), sc.nextInt());
			check[i] = false;
		}
		
		System.out.println(ans);

	}
	
	public static void dfs(int depth, int t) {
		if(depth >= n || t >= k) {
			for(int i = 0; i < n; i++) {
				if(!check[i]) {
					return;
				}
			}
			ans = Math.max(ret, ans);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			ret += arr[i][0].m;
			check[i] = true;
			dfs(depth + 1, t + arr[i][0].t);
			ret -= arr[i][0].m;
			ret += arr[i][1].m;
			dfs(depth + 1, t + arr[i][1].t);
			ret -= arr[i][1].m;
			check[i] = false;
		}
	}

}
