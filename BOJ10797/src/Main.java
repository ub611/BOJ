import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		
		for(int i = 0; i < 5; i++) {
			if(n == sc.nextInt())
				ans++;
		}
		
		System.out.println(ans);
	}	

}
