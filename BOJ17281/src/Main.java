//⚾

import java.util.*;

public class Main {
	static int arr[][];
	static int seq[] ;
	static int dp[];
	static int ret = 0;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][10];
		seq = new int[10];
		dp = new int[10];

		for(int i = 0; i < n; i++) {
			for(int j = 1; j < 10; j++) {
				arr[i][j] = sc.nextInt();	
			}
		}

		//--------input-----------------------
		dp[4] = 1;
		seq[4] = 1;
		
		getOrder(2);
		
		System.out.println(ret);
	}

	public static int solution() {
		int[] base = new int[3];
		int idx = 1;
		int ans = 0;

		for(int i = 0; i < n; i++) {		//이닝 반복
			int outCnt = 0;		//새 이닝이면 아웃 카운트 초기화
			base = new int[3];	//이닝끝나면 베이스도 초기화 ㅠㅠㅠㅠ
			
			while(outCnt != 3) {
				int s = arr[i][seq[idx]];

				if(idx == 9)		//1 ~ 9
					idx = 1;
				else
					idx++;

				if(s == 0) {
					outCnt++;
				}
				else if(s == 1) {		//한 칸 전진
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
					base[0] = 1;		//타자 전진

				}
				else if(s == 2) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							if(j == 1 || j == 2) {
								ans++;
								base[j] = 0;
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
					base[2] = 1;
				}else if(s == 4) {
					for(int j = 2; j >= 0; j--) {
						if(base[j] == 1) {
							ans++;
							base[j] = 0;
						}
					}
					ans++;
				}//----if문 끝---
			}//while문 끝
		}//for문 끝

		return ans;
	}

	public static void getOrder(int cnt) {
		if(cnt == 10) {
			ret = Math.max(solution(), ret);
			return;
		}

		for(int i = 1; i <= 9; i++) {
			if(dp[i] == 1) {
				continue;
			}
			dp[i] = 1;
			seq[i] = cnt;
			getOrder(cnt+1);
			dp[i] = 0;
		}
	}

}
