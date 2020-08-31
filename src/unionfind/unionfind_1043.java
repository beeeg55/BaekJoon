package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class unionfind_1043 {
	private static int N, M;
	private static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
 		make();
 		
		st = new StringTokenizer(br.readLine()," ");
		int know = Integer.parseInt(st.nextToken()); // 진실아는 사람 수 
		// 진실아는 사람 부모 0으로 만들어주기 
		for (int i = 0; i < know; i++) {
			int person = Integer.parseInt(st.nextToken());
			parents[person] = 0;
		}
		int cnt = 0;
		int[] checkAfter = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < n-1; j++) {
				union(temp[j],temp[j+1]);
			}
			checkAfter[i] = temp[0]; // 모두 연결시켜놨으므로 맨앞 하나만 검사용으로 저장해둠 
		}
		for (int i = 0; i < M; i++) {
			if(find(checkAfter[i])!=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
	private static void make() {
		for (int i = 0; i < N+1; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(parents[a] == 0) return 0; // 무조건 부모가 0이 되게 할거기 때문에 
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		if(aRoot==0) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		return true;
	}
}
