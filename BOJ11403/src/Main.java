import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int map[][] = new int[size][size];
		
		ArrayList<Integer> arr[] = new ArrayList[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = new ArrayList<Integer>();
			
			for(int j = 0; j < size; j++) {
				int t = sc.nextInt();
				
				if(t==1)
					arr[i].add(j);
					
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < arr[i].size(); j++) {
				q.add(arr[i].get(j));
			//	map[i][arr[i].get(j)] = 1;
			}
			
			while(!q.isEmpty()) {
				int t = q.poll();		//3
				map[i][t] = 1;
				
				for(int j = 0; j < arr[t].size(); j++) {
					if(map[i][arr[t].get(j)] == 0)
						q.add(arr[t].get(j)); //4, 5
				}
			}
			
		} 
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
}