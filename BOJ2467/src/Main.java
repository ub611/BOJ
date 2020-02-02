//용액
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long arr[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		
		int st = 0;
		int fi = n-1;
		
		long ans = Long.MAX_VALUE;	//얘때문에 틀렸습니다 ㅠ 
		long ansIdx[] = new long[2];
		
		while(st < fi) {
			long sum = arr[st] + arr[fi];		//여기서 절댓값으로 해버리면 sum이 0보다 큰지작은지 몰라서 인덱스값 변경 불가능해짐
			
			if(ans > Math.abs(sum)) {
				ans = Math.abs(sum);
				ansIdx[0] = arr[st];
				ansIdx[1] = arr[fi];
			}
			
			if(sum < 0) {
				st++;
			}else if(sum == 0) {
				break;
			}else {
				fi--;
			}
			
		}
		
		System.out.println(ansIdx[0] + " " + ansIdx[1]);
		
	}

}
