import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		if(n % 2 == 0)
			System.out.println(arr[(n / 2) - 1]);
		else
			System.out.println(arr[n / 2]);
		
		sc.close();
	
	}

}
