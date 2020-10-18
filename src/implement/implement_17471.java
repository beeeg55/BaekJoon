package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class implement_17471 {

	private static int N;
	private static int[] inputA;
	private static int min = Integer.MAX_VALUE;
	private static int R;
	private static boolean[] visit;
	private static int[][] map;
	private static int[] people;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		people = new int[N+1];
		map = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i < people.length; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int l = Integer.parseInt(st.nextToken());
				map[i][l] = 1;
			}
		}
		for (int i = 1; i < N; i++) {
			R=i;
			inputA = new int[R];
			combination(1,0);
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	private static void combination(int start, int cnt) {
		if(cnt==R) {
			visit = new boolean[N+1];
			Arrays.fill(visit, true);
			for (int i = 0; i < inputA.length; i++) {
				visit[inputA[i]] = false;
			}
			dfs(inputA[0]);
			for (int i = 0; i < inputA.length; i++) {
				if(!visit[inputA[i]]) {
					return;
				}
			}
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < inputA.length; i++) {
				set.add(inputA[i]);
			}
			
			visit = new boolean[N+1];
			Arrays.fill(visit, true);
			int temp = 0;
			for (int i = 1; i < visit.length; i++) {
				if(!set.contains(i)) {
					visit[i] = false;
					temp = i;
				}
			}
			dfs(temp);
			
			for (int i = 1; i < visit.length; i++) {
				if(!set.contains(i)) {
					if(!visit[i]) {
						return;
					}
				}
			}
			
			
			int a = 0;
			int b = 0;
			for (int i = 1; i < N+1; i++) {
				if(set.contains(i)) {
					a+= people[i];
				}else {
					b+= people[i];
				}
			}
			int dif = Math.abs(a-b);
			if(dif<min) {
				min = dif;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			inputA[cnt] = i;
			combination(i+1,cnt+1);
		}
	}

	private static void dfs(int start) {
		visit[start] = true;
		for (int i = 1; i < N+1 ; i++) {
			if(map[start][i]==1&&!visit[i]) {
				dfs(i);
			}
		}
		
	}

}
