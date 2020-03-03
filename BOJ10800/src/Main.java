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
		
		sc.close();
		
		Arrays.sort(list);

		int sum = 0;
		int bef = -1;
		
		for(int i = 0; i < list.length; i++) {
			Info ele = list[i];

			arr[ele.num] = sum - color[ele.col];
					
			if(ele.size == bef) {
				int idx = i - 1;
				
				while(list[idx].size == ele.size ) {		//크기가 같은 경우
					if(list[idx--].col != ele.col)		//같은 색인 경우 제외해야함
						arr[ele.num] -= ele.size;

					if(idx < 0)
						break;
				}
			}
	
			sum += ele.size;
			color[ele.col] += ele.size;
			bef = ele.size;
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
