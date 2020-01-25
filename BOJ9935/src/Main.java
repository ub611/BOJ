import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		//Scanner로 하면 시간초과
		String sb = br.readLine();
		String bomb = br.readLine();

		Stack<Character> stack = new Stack<Character>();

		for(int i = sb.length() - 1; i >= 0; i--) {
			stack.push(sb.charAt(i));

			if(stack.size() >= bomb.length() && stack.peek() == bomb.charAt(0)) {
				boolean flag = true;

				for(int j = 0 ; j < bomb.length(); j++) {
					if(bomb.charAt(j) != stack.get(stack.size() - 1 - j)){		//pop하고 push 다시해도 시간초과
						flag = false;
						break;
					}
				}

				if(flag) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}

			}

		}

		if(stack.size() > 0) {
			for(int i = stack.size() - 1; i >= 0; i--) {
				System.out.print(stack.pop());
			}
		}
		else {
			System.out.println("FRULA");
		}


	}

}
