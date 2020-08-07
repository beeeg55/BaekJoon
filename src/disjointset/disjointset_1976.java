package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class disjointset_1976 {
	static int N,M;
	static int[][] map;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		parents = new int[N+1];
		
		make();
		
		StringTokenizer st;
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					union(i,j); // 이어져있을 시 유니언 
				}
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int point = Integer.parseInt(st.nextToken());
		int parent = parents[point];
		for (int i = 1; i < M; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(find(next) != parent) {
				System.out.println("NO");
				break;
			}
			if(i == M-1) {
				System.out.println("YES");
			}
		}
		
		
	}
	
	public static void make() {
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a]==a) {
			return parents[a];
		}
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return false;
		}
		parents[rootB] = rootA; 
		return true;
	}
}

