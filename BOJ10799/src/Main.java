import java.util.*;
//쇠막대
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] arr = input.toCharArray();
		Stack st = new Stack();
		int ans = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			char ele = arr[i];
			
			if(ele == '(' && arr[i + 1] == ')') {
				ans += st.size();
				i++;
			}else {
				if(ele == '(') {
					ans += 1;
					st.add(ele);
				}else {
					st.pop();
				}
			}
		}
		
		System.out.println(ans);

	}

}
