import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		while(list.size() != 1) {
			ans.add(list.remove(0));
			list.add(list.remove(0));
		}
		ans.add(list.remove(0));
		
		for(int e : ans) {
			System.out.print(e + " ");
		}
	}

}
