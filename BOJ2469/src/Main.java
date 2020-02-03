//사다리타기
import java.util.*;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();		//참가자 수, 3 <= <= 26
		int n = sc.nextInt();
		String s = sc.next();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> revMap = new HashMap<Integer, Integer>();
	
		for(int i = 0; i < k; i++) {
			map.put(i + 1, i);		
		}
		
		for(int i = 0; i < s.length(); i++) {
			revMap.put((int)(s.charAt(i)) % 64, i);
		}

		char[][] input = new char[n][k - 1];

		for(int i = 0; i < n; i++) {
			String tmp = sc.next();
			char[] carr = tmp.toCharArray();

			for(int j = 0; j < k - 1; j++) {
				input[i][j] = carr[j];
			}
		}

		for(int i = 0; input[i][0] != '?'; i++) {
			for(int j = 0; j < k; j++) {
				int ci = map.get(j + 1);		//알파벳의 위치 인덱스

				if(ci - 1 >= 0 && input[i][ci - 1] == '-') {
					map.put(j + 1, ci - 1);
				}else if(ci < k - 1 && input[i][ci] == '-') {
					map.put(j + 1, ci + 1);
				}else {
					map.put(j + 1, ci);
				}
			}
		}
		
		
		//아래부터 물음표까지 올라옴
		for(int i = n - 1; input[i][0] != '?'; i--) {
			for(int j = 0; j < k; j++) {
				int ci = revMap.get(j + 1);		//알파벳의 위치 인덱스
				
				if(ci - 1 >= 0 && input[i][ci - 1] == '-') {
					revMap.put(j + 1, ci - 1);
				}else if(ci < k - 1 && input[i][ci] == '-') {
					revMap.put(j + 1, ci + 1);
				}else {
					revMap.put(j + 1, ci);
				}
				
			
			}
		}

		char[] ans = new char[k];
		
		for(int i = 0; i < k; i++) {
			int a = map.get(i + 1);
			int b = revMap.get(i + 1);
			
			if(Math.abs(a - b) >= 2) {
				System.out.println("********");
				return;
			}
			
			if(a == b) {
				ans[a] = '*';
			}else {
				int idx = Math.min(a, b);
				ans[idx] = '-';
				
				if(idx - 1 >= 0 && ans[idx - 1] == '-') {
					System.out.println("********");
					return;
				}else if(idx + 1 <= k - 1 && ans[k - 1] == '-') {
					System.out.println("********");
					return;
				}
				
				ans[Math.max(a, b)] = '*';
			}
			
		}
		
		ans[k - 1] = '\0';
		
		for(char c : ans) {
			System.out.print(c);
		}

	}

}
