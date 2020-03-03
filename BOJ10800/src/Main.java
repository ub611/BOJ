import java.util.*;
//컬러볼
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Info[] list = new Info[n];
//		ArrayList<Info> list = new ArrayList<Info>();			//n == 20만개 -> ArrayList로 구현하면 런타임에러, 구조체의 배열로 구현
		int[] arr = new int[n];
		int[] color = new int[n + 1];
				
		for(int i = 0; i < n; i++) {
			int col = sc.nextInt();
			int size = sc.nextInt();
			
			list[i] = new Info(col, size, i);
		}
		
		Arrays.sort(list);

		int sum = 0;
		int max = -1;
		long maxSum = 0;
		
		for(int i = 0; i < list.length; i++) {
			Info ele = list[i];

			if(ele.size == max) {	
				arr[ele.num] = (int) (sum - color[ele.col] - maxSum);
				maxSum += ele.size;
			}else {
				arr[ele.num] = sum - color[ele.col];
				maxSum = ele.size;
				
			}
			
			sum += ele.size;
			color[ele.col] += ele.size;
			max = ele.size;
		}
		
		for(int x : arr) {
			System.out.println(x);
		}

	}

}

class Info implements Comparable<Info>{
	int col;
	int size;
	int num;
	
	public Info(int col, int size, int num) {
		this.col = col;
		this.size = size;
		this.num = num;
	}

	@Override
	public int compareTo(Info o) {
		// TODO Auto-generated method stub
		return this.size - o.size;
	}
}
