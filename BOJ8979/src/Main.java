//올림픽
import java.util.*;

public class Main {
	public static class Nation{
		int na;
		int g;
		int s;
		int b;
		
		public Nation(int na, int g, int s, int b) {
			this.na = na;
			this.g = g;
			this.s = s;
			this.b = b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ret = 0;
		int idx = 0;

		Nation[] arr = new Nation[n + 1];
		
		for(int i = 1; i <= n; i++) {
			int na = sc.nextInt();
			int g  = sc.nextInt();
			int s = sc.nextInt();
			int b = sc.nextInt();
			
			if(na == k)
				idx = i;
			
			arr[i] = new Nation(na, g, s, b);
		}
		
		sc.close();
		
		for(int i = 1; i <= n; i++) {
			if(arr[i].g > arr[idx].g) {
				ret++;
			}else if(arr[i].g == arr[idx].g){
				if(arr[i].s > arr[idx].s) {
					ret++;
				}else if(arr[i].s == arr[idx].s) {
					if(arr[i].b > arr[idx].b) {
						ret++;
					}
				}
			}
		}
		
		System.out.println(ret + 1);
	}

}
