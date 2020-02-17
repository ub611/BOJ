//막대기
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int ans = 1;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[n - 1];
		
		for(int i = n - 2; i >= 0 ; i--) {
			if(max < arr[i]) {
				max = arr[i];
				ans++;
			}
		}
		
		System.out.println(ans);

	}

}
