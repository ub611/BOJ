//택배
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();	
		int k = sc.nextInt();

		int arr[][] = new int[n + 1][n + 1];

		for(int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			arr[a][b] = c;
		}

		int delivery[] = new int[n + 1];
		int sum = 0;
		int ans = 0;

		for(int i = 1; i <= n; i++) {
			int idx = i + 1;

			if(delivery[i] > 0) {
				sum -= delivery[i];
				ans += delivery[i];
			}

			while(sum != d) {
				if(idx > n)
					break;
				if(arr[i][idx] > 0) {
					if(d < sum + arr[i][idx]) {
						delivery[idx] += (d - sum);
						sum += d - sum;
					}
					else {
						delivery[idx] += arr[i][idx];
						sum += arr[i][idx];
					}
				}
				idx++;
			}
			
		}
		
		System.out.println(ans);
	}

}
