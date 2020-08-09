package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class disjointset_1717 {

	private static int[] parents;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		make();
				
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch (op) {
			case 0:
				union(a,b);
				break;
			case 1:
				if(find(a)==find(b)){
					sb.append("YES"+"\n");
				}else {
					sb.append("NO"+"\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}

	private static void make() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return;
		}
		parents[rootB] = rootA;
	}

}
