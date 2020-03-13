//저울
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int map[][] = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = 1;
		}
		
		for(int i = 1; i <= n; i++) {			//인덱스 잘 보기
			for(int j = 1; j <= n; j++){
				for(int k = 1; k <= n; k++) {
					if(map[j][i] == 1 && map[i][k] == 1)
						map[j][k] = 1;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			int cnt = -1;	//본인 제외
			
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 0 && map[j][i] == 0)
					cnt++;
			}
			
			System.out.println(cnt);
		}
	

	}

}
