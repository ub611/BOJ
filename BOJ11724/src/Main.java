import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[] = new int[n + 1];
		int ans = 0;

		ArrayList<Integer> arr[] = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[a].add(b);
			arr[b].add(a);
		}

		for(int i = 1; i <= n; i++) {
			if(dp[i] != 0)
				continue;

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			
			dp[i] = 1;

			while(!q.isEmpty()) {
				int idx = q.poll();

				if(arr[idx] != null) {
					for(int t : arr[idx]) {
						if(dp[t] == 0) {
							q.add(t);
							dp[t] = 1;
							//방문 체크는 큐에서 뺀 다음이 아닌, 큐에 넣을 때 해야 중복 방문을 하지 않습니다.
							//여러 정점에서 한 정점으로 동시에 들어가려고 할 수 있기 때문입니다. -> 시간초과 발생가
						}
					}
				}
			}
			ans++;
		}

		System.out.println(ans);

	}

}
