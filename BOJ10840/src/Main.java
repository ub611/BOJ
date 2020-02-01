import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//구간 성분

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//		String sa = sc.next();
		char[] sa = sc.next().toCharArray();
		char[] sb = sc.next().toCharArray();
		
		int[] dpA = new int[sa.length];
		int[] dpB = new int[sb.length];

		
		for(int i = 0; i < sa.length; i++) {
			for(int j = 0; j < sb.length; j++) {
				if(sa[i] == sb[j]) {
					dpA[i]++;
					dpB[j]++;
				}
			}
		}
		
		int tmpA = 0;
		int ansA = 0;
		for(int i = 0; i < sa.length; i++) {
			System.out.print(dpA[i] + " ");
			if(dpA[i] > 0) {
				tmpA++;
			}else {
				ansA = ansA > tmpA ? ansA : tmpA;
				tmpA = 0;
			}
		}
		
		ansA = ansA > tmpA? ansA : tmpA;
		
		System.out.println("");
		int tmp = 0;
		int ans = 0;
		for(int i = 0; i < sb.length; i++) {
			System.out.print(dpB[i] + " ");
			if(dpB[i] > 0)
				tmp++;
			else {
				ans = ans > tmp? ans : tmp;
				tmp = 0;
			}
		}
		ans = ans > tmp ? ans : tmp;
	
		System.out.println("");

		System.out.println(ans > ansA? ansA : ans);
	}
}
