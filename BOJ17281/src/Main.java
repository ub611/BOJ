//⚾

import java.util.*;

public class Main {
	static int arr[][];
	static int seq[];
	static int dp[];
	static int ans;
	static int ret = 0;
	
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][9];
		seq = new int[9];
		dp = new int[9];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();	
			}
		}
		
		//--------input-----------------------
		dp[3] = 1;
		seq[3] = 1;
		getOrder(1);
		System.out.println(ret);
	}
	
	public static void solution() {
		int[] base = new int[3];
		int outCnt = 0;
		
		for(int i = 0; i < 9; i++) {
			if(seq[i] == 1) {
				int tmp = seq[3];
				seq[3] = 1;
				seq[i] = tmp;
			}
		}		//1번선수는 4번타자 고정
		
		int idx = 0;
		for(int i = 0; i < n; i++) {
			while(outCnt < 3) {
				int s = arr[i][seq[idx++]];
				idx %= 9;
				if(s == 0) {
					outCnt++;
				}
				else if(s == 1) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							if(j == 2) {
								ans++;
								base[j] = 0;
							}else {
								base[j + 1] = 1;
								base[j] = 0;
							}
						}
					}
					base[0] = 1;
					
				}
				else if(s == 2) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							if(j == 1 || j == 2) {
								ans++;
								base[j] = 1;
							}else {
								base[j + 2] = 1;
								base[j] = 0;
							}
						}
					}
					base[1] = 1;
				}else if(s == 3) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							ans++;
							base[j] = 0;
						}
					}
					base[2] = 2;
				}else if(s == 4) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							ans++;
							base[j] = 0;
						}
					}
					ans++;
				}
			}
		}
	}
	
	public static void getOrder(int cnt) {
		if(cnt == 8){
			for(int x : seq) {
				System.out.print(x + " ");
			}
			System.out.println("");
			ans = 0;
		//	solution();
		//	ret = Math.max(ans, ret);
			return;
		}
	
		for(int i = 0; i < 9; i++) {
			if(dp[i] == 1)
				continue;
			dp[i] = 1;
			seq[i] = cnt;
			getOrder(cnt + 1);
			dp[i] = 0;
		}
	}

}
