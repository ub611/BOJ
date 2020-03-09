//자리배정
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if(n * c < k) {
			System.out.println("0");
			return;
		}
		
		int num = 1;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= c; j++) {
				System.out.print(num++ + " ");
			}
			System.out.println("");
		}

	}

}
