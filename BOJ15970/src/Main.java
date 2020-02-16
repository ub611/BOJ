//화살표 그리기
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list[] = new ArrayList[n + 1];
		int ans = 0;
		
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int c = sc.nextInt();
			
			if(list[c] == null) {
				list[c] = new ArrayList<Integer>();
			}
			
			list[c].add(x);
		}
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				Collections.sort(list[i]);
				
				for(int j = 0; j < list[i].size(); j++) {
					int min = Integer.MAX_VALUE;
					
					if(j - 1 >= 0) {
						min = Math.min(min, list[i].get(j) - list[i].get(j - 1));
					}
					
					if(j + 1 < list[i].size()) {
						min = Math.min(min, list[i].get(j + 1) - list[i].get(j));
					}
					
//					System.out.println(min);
					
					ans += min;
				}
			}
		}
		
		System.out.println(ans);
	
	}

}
