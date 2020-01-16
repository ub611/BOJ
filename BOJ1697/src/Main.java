import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//현재 수빈의 위치 0 < n < 100000
		int m = sc.nextInt();		//동생의 위

		int[] arr = new int[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);

		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n == m) {
				System.out.println(arr[n]);
				break;
			}

			if(n + 1 <= 100000) {
				if(arr[n + 1] != 0)
					arr[n + 1] = arr[n] + 1 < arr[n + 1] ? arr[n] + 1 : arr[n + 1];
				else {
					arr[n + 1] = arr[n] + 1;
					q.add(n + 1);		//없으면 메모리 초과
				}
			}
			if(n - 1 >= 0) {
				if(arr[n - 1] != 0)
					arr[n - 1] = arr[n] + 1 < arr[n - 1] ? arr[n] + 1 : arr[n - 1];
				else {
					arr[n - 1] = arr[n] + 1;
					q.add(n - 1);
				}
			}

			if(2 * n <= 100000) {
				if(arr[2*n] != 0)
					arr[2*n] = arr[n] + 1 < arr[n * 2] ? arr[n] + 1 : arr[n * 2];
				else {
					arr[2*n] = arr[n] + 1;
					q.add(2 * n);
				}
			}

		}

		//		for(int i = 0; i < 30; i++) {
		//			System.out.print(arr[i] + " ");
		//		}

	}

}
