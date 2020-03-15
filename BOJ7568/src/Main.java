//덩치
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = 0; i < n; i++) {
			ans[i] = 1;
			
			for(int j = 0; j < n; j++) {
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					ans[i]++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}