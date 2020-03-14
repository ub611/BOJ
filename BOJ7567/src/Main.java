//그릇
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		char[] arr = str.toCharArray();
		
		char b = arr[0];
		int ans = 10;
		for(int i = 1; i <arr.length; i++) {
			if(b == arr[i])
				ans += 5;
			else
				ans += 10;
			b = arr[i];
		}
		
		System.out.print(ans);

	}

}
