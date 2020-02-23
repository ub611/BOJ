import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int max = 15;
		char[][] arr= new char[max][n];
		
		for(int i = 0; i < n; i++) {
			String tmp = sc.next();
			char[] carr = tmp.toCharArray();
			for(int j = 0; j < carr.length; j++) {
				arr[j][i] = carr[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != ' ' && arr[i][j] != '\0')
					sb.append(arr[i][j]);
			}
		}
		
		System.out.print(sb);
		
		sc.close();
	}

}
