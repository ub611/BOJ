import java.util.Scanner;

public class Main {
	static class Node{
		String data;
		Node left;
		Node right;
		
		public Node(String data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		for(int i = 0; i < cnt; i++) {
			String c = sc.next();
		}
	}
}
