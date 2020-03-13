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
				
		int tw = (t + x) % (2 * w);
		int th = (t + y) % (2 * h);
		
		if(tw > w)
			tw = w - (tw - w);
		if(th > h)
			th = h - (th - h);
		
		System.out.println(tw + " " + th);

		sc.close();
	}

}
