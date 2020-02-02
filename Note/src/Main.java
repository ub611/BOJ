//사다리타기
import java.util.*;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();		//참가자 수, 3 <= <= 26
		int n = sc.nextInt();
		int qidx = 0;

		char[][] map = new char[n][k - 1];

		for(int i = 0; i < n; i++) {
			String str = sc.next();
			char[] tmp = str.toCharArray();

			if(tmp[0] == '?') {
				qidx = i;
			}

			for(int j = 0; j < k - 1; j++) {
				map[i][j] = tmp[j];
			}
		}

		
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		
		for(int i = 0; i < k; i++) {
			h.put((char) ('A' + i), i);
		}
		
		int x = 0;		//세로 idx
		int y = 0;
		
		while(y < qidx) {
			x %= k;
			
			if(map[x][y] == '-') {
				h.put((char)('A' + x), x + 1);
			}
			else if(x - 1 >= 0) {
				if(map[x - 1][y] == '-') {
					h.put((char)('A' + x), x - 1);
				}
			}
			
			x++;
			y++;
		}
		
		for(int i = 0; i < k; i++) {
			System.out.println((char)('A' + i) + " = " + h.get((char)('A' + i)));
		}
		



	}

}
