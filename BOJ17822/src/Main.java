import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int input[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//원판의 개수	
		int m = sc.nextInt();		//ㅅ원판에 쓰여진 정수의 개수
		int t = sc.nextInt();		//원판의 회전 반복 수

		input = new int[n + 1][m];
		
		ArrayList<Integer> arr[] = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
			for(int j = 0; j < m; j++) {
				input[i][j] = sc.nextInt();
				arr[i].add(sc.nextInt());
			}
		}

		int x = sc.nextInt();		//x의 배수의 원판 회전
		int d = sc.nextInt();		//0이면 시계 1이면 반시계	
		int k = sc.nextInt();		//k칸만큼 회전

		
		for(int i = 1; i <= n; i++) {
			if(i % x == 0) {		//i가 x의 배수이면
				for(int j = 0; j < k; j++) {
					int tmp = arr[i].get(0);
					arr[i].add(tmp);
				}
			}
		}


	}


}
