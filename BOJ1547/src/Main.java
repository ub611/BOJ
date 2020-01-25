import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int tmp = map.get(a);		//현재 a의 위치
			map.replace(a, map.get(b));
			map.replace(b, tmp);
		}
		
		for(int i = 1; i <= map.size(); i++) {
			if(map.get(i) == 1)
				System.out.println(i);
		}
	}

}
