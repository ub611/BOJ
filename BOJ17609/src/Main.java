//회문
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			String str = sc.next();
			char[] tmp = str.toCharArray();

			if(ckPalin(tmp)) {
				System.out.println("0");
				continue;
			}else {
				for(int j = 0; j < tmp.length / 2; j++) {
					if(tmp[j] != tmp[tmp.length - 1 - j]) {
						char[] t = str.substring(j + 1, tmp.length - j).toCharArray();

						if(ckPalin(t)) {
							System.out.println("1");
							break;
						}
						
						t = str.substring(j, tmp.length - 1 - j).toCharArray();
 
						if(ckPalin(t)) {
							System.out.println("1");
							break;
						}


						System.out.println("2");
						break;
					}
				}
			}

		}
		
		sc.close();
	}


	public static boolean ckPalin(char[] arr) {		
		//		System.out.println(new String(arr));
		for(int i = 0; i < arr.length / 2; i++) {
			if(arr[i] == arr[arr.length - 1 - i])
				continue;
			else
				return false;
		}

		return true;
	}

}

