//방 배정하기
import java.util.*;

public class Main {
	static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		
	
		for(int i = 0; i <= 300 / a; i++) {
			for(int j = 0; j <= 300 / b; j++) {
				for(int m = 0; m <= 300 / c; m++) {
					if(a * i + b * j + c * m == k) {
						System.out.println("1");
						return;
					}
				}
			}
		}
		System.out.println("0");
		

	}

}
