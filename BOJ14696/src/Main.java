//딱지놀이
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int scoreA[] = new int[5];
			int scoreB[] = new int[5];

			int k = sc.nextInt();
			for(int j = 0; j < k; j++) {
				int idx = sc.nextInt();
				scoreA[idx]++;
			}
			
			k = sc.nextInt()	;
			for(int j = 0; j < k; j++) {
				int idx = sc.nextInt();
				scoreB[idx]++;
			}
			
			
			boolean flag = false;
			for(int j = 4; j >= 0; j--) {
				if(scoreA[j] > scoreB[j]) {
					flag = true;
					System.out.println("A");
					break;
				}else if(scoreA[j] < scoreB[j]){
					flag = true;
					System.out.println("B");
					break;
				}
			}
			
			if(!flag) {
				System.out.println("D");
			}
		}

	}

}
