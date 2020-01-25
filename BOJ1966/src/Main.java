import java.util.*;

public class Main {

	//가중치 내림차순으로 따로 배열을 가지고 있
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for(int t = 0; t < tc; t++) {
			int n = sc.nextInt(); 	//문서의 개수	
			int v = sc.nextInt();	//구할 문서의 ㄴ넘버
			ArrayList<Integer> arr = new ArrayList<Integer>();			//가중치 내림차순으로 따로 배열을 가지고 있
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();		//idx, 가중치 맵

			int ans = 0;

			for(int i = 0; i < n; i++) {
				int input = sc.nextInt();
				map.put(i, input);
				arr.add(input);
			}

			Collections.sort(arr, Collections.reverseOrder());	
			
			boolean flag = true;
			int idx = 0;		//key가 될 idx

			while(flag) {
				int max = arr.remove(0);		//현재 프린트될 문서의 가중치
				int ele = 0;		//초기화
				
				while(max != ele) {		//현재 프린트될 문서 찾아서 map에서 삭제함
					
					//idx 초기화- null 처리 확실히하기
					while(map.get(idx) == null) {		
						idx++;
						
						if(idx >= n) {
							idx = 0;
						}
						
					}
					//--------------------------
					
					ele = map.remove(idx);
					
					if(max == ele) {		//현재 프린트할 문서의 가중치와 현재 찾은 원소의 가중치가 같다
						if(idx == v)		//현재 프린트할 문서의 키값과 찾을 키값이 같으면
							flag = false;
						else if(ele == map.get(v)){		//뽑고자 하는 문서의 가중치와 현재 가중치가 같은 경
							map.put(idx, ele);
							idx++;
						}
						
						break;
					}
					
					map.put(idx++, ele);				//맨 뒤로 넣기		
				}
		
				ans++;
			}
			
			System.out.println(ans);
		}

	}

}
