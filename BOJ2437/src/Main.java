//저울

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];


		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		if(arr[0] != 1) {
			System.out.println("1");
			return;
		}
		
		long sum = 1;
		
		for(int i = 1; i < n; i++) {
			if(sum + 1 < arr[i]) {
//				System.out.println(sum + 1);			여기서 출력하면 1 1 인 경우 출력안댐 (i = 1이고 i < 1인 동안 반복하니깐. . .. )
//				return;
				break;
			}
			sum += arr[i];
		}
		
		System.out.println(sum + 1);
	}
}
