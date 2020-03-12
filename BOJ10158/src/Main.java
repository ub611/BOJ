//개미
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();
				
		int tw = t % (2 * w);
		int th = t % (2 * h);
		
		x = w - Math.abs(w - (x + tw));
		y = h - Math.abs(h - (y + th));
		
		System.out.println(x + " " + y);

	}

}
