//택배
import java.util.*;

public class Main {

	public static class Box{
		int f;
		int t;
		int d;
		
		public Box() {}
		
		public Box(int f, int t, int d) {
			this.f = f;
			this.t = t;
			this.d = d;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();	
		int k = sc.nextInt();
		
		int[] dmax = new int[n];
		
		for(int i = 1; i < n; i++) {
			dmax[i] = d;
		}
		
		Box arr[] = new Box[k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = new Box();
			arr[i].f = sc.nextInt();
			arr[i].t = sc.nextInt();
			arr[i].d = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<Box>(){
			@Override
			public int compare(Box o1, Box o2) {
				// TODO Auto-generated method stub
				if(o1.t < o2.t)		
					return -1;
				else if(o1.t == o2.t) {
					if(o1.f < o2.f)
						return -1;	
					else
						return 1;
				}else {
					return 1;
				}
			}
			
		});
		
		for(int i = 0; i < k; i++) {
		
		}
		

		
	}

}
