import java.util.Scanner;

//동전 게임
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();		//num of Round
		int cnt = sc.nextInt();		//num of Line
		
		for(int i = 0;  i < cnt; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println(getAns(m, n, k));
		}
	}
	
	public static int getAns(int m, int n, int k) {		
		
		if(m == n) {
			return 1;
		}else if(m > n) {		//영희가 먼저 던지니깐 2점차이까지 가능 (n이 던지기 전에 끝나지만 점수는 그렇게 나올 수 있음)
			if(m - (n + k - m) <= 2) {		
				return 1;
			}
			/*
			 *k - max == 남은 판 수 => 최대로 얻을 수 있는 점수
			 *min + 남은 판 수 >= max 이면 1
			 */
		}else {		// m < n
			if(n - (m + k - n) <= 1) {		//m이 먼저 던지니깐 2점차가 나기전에 게임이 끝
				return 1;
			}
		}		
		
		return 0;
	}

}
