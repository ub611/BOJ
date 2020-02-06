//예산

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		int arr[] = new int[k];
		int sum = 0;
		int max = 0;
		int l;
		int r;

		for(int i = 0 ; i < k; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			max = Math.max(arr[i], max);
		}

		int totalM = sc.nextInt();		//예산

		if(totalM >= sum) {
			System.out.println(max);
			return;
		}else {
			l = 0;		//min으로 하면 배열의 최소값보다 예산이 작으면 틀림
			r = max;

			while(l <= r) {		//가장 큰 값중에 제일 작은값이 되게 해줌
//				System.out.println(l + " " + r);
				int mid = (l + r) / 2;
				int tmp = 0;
				for(int i = 0; i < k; i++) {
					tmp += arr[i] > mid ? mid : arr[i];
				}

				if(tmp < totalM) {
					l = mid + 1;
				}else if(tmp == totalM) {
					System.out.println(mid);
					return;
				}else {
					r = mid - 1;
				}
			}
		}

		System.out.println(r);

	}

}
