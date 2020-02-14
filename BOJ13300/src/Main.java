//방배정 
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//num of student
		int k = sc.nextInt(); 		//capacity
		int ans = 0;
		
		
		int arr[][] = new int[2][7];
		
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			arr[s][y]++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length; j++) {
				int t = arr[i][j] / k;
				
				if(t * k < arr[i][j])
					ans += t + 1;
				else
					ans += t;
			}
		}
		
		System.out.println(ans);
	}

}
