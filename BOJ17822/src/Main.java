import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * 	System.out.println("\n1회전");
//
//			for(int i = 1; i <= n; i++) {
//				for(int e : arr[i]) {
//					System.out.print(e + " ");
//				}
//				System.out.println("");
//			}

 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//원판의 개수	
		int m = sc.nextInt();		//ㅅ원판에 쓰여진 정수의 개수
		int t = sc.nextInt();		//원판의 회전 반복 수

		ArrayList<Integer> arr[] = new ArrayList[n + 1];
		ArrayList<Integer> clone[] = new ArrayList[n + 1];
		int[][] turn = new int[t][3];

		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
			clone[i] = new ArrayList<Integer>();
			for(int j = 0; j < m; j++) {
				arr[i].add(sc.nextInt());
				clone[i].add(arr[i].get(j));
			}
		}


		for(int i = 0; i < t; i++) {
			turn[i][0] = sc.nextInt();		//x의 배수의 원판 회전 x
			turn[i][1] = sc.nextInt();		//0이면 시계 1이면 반시계	d
			turn[i][2] = sc.nextInt();		//k칸만큼 회전 k
		}
		
		sc.close();

		int idx = 0;

		while(idx < t) {
			
			//원판 회전
			for(int i = 1; i <= n; i++) {
				if(i % turn[idx][0] == 0) {		//i가 x의 배수이면
					if(turn[idx][1] == 0) {		//시계방향
						for(int j = 0; j < turn[idx][2]; j++) {		//k칸만큼 옮기니깐 k만큼 반복
							int tmp = arr[i].remove(m-1);
							arr[i].add(0, tmp);		//인덱스 하나씩 밀어야 하니깐 On만큼 한 번 더 반복할듯
						}
					}
					else {
						for(int j = 0; j < turn[idx][2]; j++) {		//k칸만큼 옮기니깐 k만큼 반복
							int tmp = arr[i].remove(0);
							arr[i].add(tmp);		
						}
					}
				}
			}

			int flag = 0;

			//map 복사를 해두고, 얘를 기준으로 지워야함 그 전에 지운 원소때문에 그 원소와 인접한 원소를 지우지 않게 됨 (0으로 바뀌니깐 5랑 다르니
			for(int i = 1; i <= n; i++) {			
				for(int j = 0; j < m; j++) {
					clone[i].set(j, arr[i].get(j));
				}
			}
			
			//인접 원소 지우기
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < m; j++) {
					int tmp = clone[i].get(j);

					if(i - 1 >= 1 && arr[i - 1].get(j) != 0 && arr[i - 1].get(j) == tmp) {
						arr[i].set(j, 0);
						arr[i - 1].set(j, 0);
						flag = 1;
					}

					if(i + 1 <= n && arr[i + 1].get(j) != 0 && arr[i + 1].get(j) == tmp) {
						arr[i].set(j, 0);
						arr[i + 1].set(j, 0);
						flag = 1;
					}

					if(arr[i].get((j + 1) % m) != 0 && arr[i].get((j + 1) % m) == tmp) {
						arr[i].set(j, 0);
						arr[i].set((j + 1) % m, 0);
						flag = 1;
					}

					if(arr[i].get(m - j - 1) != 0 && arr[i].get(m - j - 1) == tmp) {		
						arr[i].set(j, 0);
						arr[i].set(m - j - 1, 0);
						flag = 1;
					}
				}
			}

			//인접한게 없는 경우
			if(flag == 0) {
				double sum = 0;
				int cnt = 0;

				for(int i = 1; i <= n; i++) {
					for(int j = 0; j < m; j++) {
						sum += arr[i].get(j);
						
						if(arr[i].get(j) != 0)
							cnt++;
					}
				}
				
				if(cnt == 0) {
					break;		//zero devide
				}
					
				double avg = sum / (double)cnt;

				
				for(int i = 1; i <= n; i++) {
					for(int j = 0; j < m; j++) {
						double tmp = (double)arr[i].get(j);
						//평균이랑 같거나 없는 경우는 넘어감
						if(tmp == avg || tmp == 0) {//arr[i].get(j) == avg || arr[i].get(j) == 0){
//							System.out.println(tmp + ", " + avg);
							continue;
						}

						if(tmp > avg) {//arr[i].get(j) > avg) {
							arr[i].set(j, arr[i].get(j) - 1);
						}

						else {
							arr[i].set(j, arr[i].get(j) + 1);
						}

					}
				}

			}		
			
			idx++;
		}


		
		//------------촤종 정답-------------------
		int sum = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				sum += arr[i].get(j);
			}
		}

		System.out.println(sum);

	}


}
