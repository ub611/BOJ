import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(64);
		
		int sum = getSum(arr);
		
		while(sum != x) {
			int tmp = arr.remove(arr.size() - 1) / 2;		//제일 작은거 2로 나눈 숫자
			arr.add(tmp);
			
			if(getSum(arr) < x)
				arr.add(tmp);
			
			sum = getSum(arr);
			
		}
		
		System.out.println(arr.size());
			
	}
	
	public static int getSum(ArrayList<Integer> list) {
		int sum = 0;
		
		for(int e : list) {
			sum += e;
		}
		
		return sum;
	}

}
