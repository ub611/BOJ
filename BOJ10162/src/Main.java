//전자레인

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] ans= new int[3];
		
		while(t != 0) {
			if(t >= 300) {
				t -= 300;
				ans[0]++;
			}else if(t < 300 && t >= 60) {
				t -= 60;
				ans[1]++;
			}else {
				t-= 10;
				ans[2]++;
			}
			
			if(t < 0) {
				System.out.println("-1");
				return;
			}
		}
		
		for(int x : ans) {
			System.out.print(x + " ");
		}
		
	}

}
