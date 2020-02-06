//카드 놀이

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] A = new int[10];
		int[] B = new int[10];
		char win = 0;
		
		int scoreA = 0;
		int scoreB = 0;
		
		for(int i = 0; i < 10; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 10; i++) {
			if(A[i] > B[i]) {
				scoreA += 3;
				win = 'A';
			}else if(A[i] == B[i]) {
				scoreA += 1;
				scoreB += 1;
			}else {
				scoreB += 3;
				win = 'B';
			}
		}
		
		if(scoreA != scoreB) {
			win = (scoreA == (scoreA > scoreB ? scoreA : scoreB)? 'A' : 'B');
			System.out.println(scoreA + " " + scoreB + "\n" + win);
		}else {
			if(win == 0) {
				System.out.println(scoreA + " " + scoreB + "\nD");
			}else {
				System.out.println(scoreA + " " + scoreB + "\n" + win);
			}
		}
	
	
	}

}
