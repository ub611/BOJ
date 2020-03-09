//과자
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();
		int cnt = sc.nextInt();
		int nowMon = sc.nextInt();
		
		System.out.println(nowMon - mon * cnt > 0 ? "0" : mon * cnt - nowMon);

		sc.close();
	}

}
