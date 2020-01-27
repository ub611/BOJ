import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		if(a % c != 0) {
			a = a / c + 1;
		}
		else
			a = a / c;
		if(b % d != 0) {
			b = b / d  + 1;
		}
		else
			b = b / d;

		a = Math.max(a, b);
		
		System.out.println(l - a);
		
		
	}

}
