import java.util.Scanner;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int v;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	//정점의 개수
		m = sc.nextInt();	//간선의 개수
		v = sc.nextInt();	//시작할 정점

		int[][] input = new int[n + 1][n + 1];
		dp = new int[n + 1];

		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			input[x][y] = 1;
			input[y][x] = 1;
		}

		dfs(input, v);
		dp = new int[n + 1];
		System.out.println("");
		bfs(input);
		
		sc.close();
	}

	public static void bfs(int[][] arr) {
		Queue<Integer> q = new LinkedList<Integer>();		
		q.add(v);
			
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(dp[p] == 1)
				continue;
			
			dp[p] = 1;
			
			System.out.print(p + " ");
			
			for(int i = 1; i < arr.length; i++) {
				if(arr[p][i] == 1 && dp[i] == 0) {
					q.add(i);
				}
			}
		}
	}

	public static void dfs(int[][] arr, int s) {
		if(dp[s] == 1)
			return; 

		dp[s] = 1;
		System.out.print(s + " ");

		for(int i = 1; i <= n; i++) {
			if(arr[s][i] == 1 && dp[i] == 0){
				dfs(arr, i);
			}
		}
	}

}
