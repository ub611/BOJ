import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int max = 0;
		
		for(int i = 0 ; i < 4; i++) {
			int m = sc.nextInt();
			int p = sc.nextInt();
			
			ans = ans - m + p;
			
			max = Math.max(max, ans);
		}
		
		System.out.println(max);
		
	}

}
