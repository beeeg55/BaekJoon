package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_1251 {

	private static int N;
	private static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N];
			int[][] land = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				land[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				land[i][1] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			ArrayList<Road> list = new ArrayList<>();
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					list.add(new Road(i,j,getDistance(land[i][0],land[i][1],land[j][0],land[j][1])));
				} 
			}
			Collections.sort(list);
			make();
			int build = 0;
			double sum = 0;
			for(Road r:list) {
				if(build == N-1) break;
				if(union(r.start,r.end)) continue;
				build++;
				sum += Math.pow(r.len, 2)*E;
			}
			System.out.println("#"+t+" "+Math.round(sum));
		}
	}
	
	private static void make() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	private static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parent[rootA] = rootB;
			return false;
		}
		return true;
	}

	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1, 2));
	}
	static class Road implements Comparable<Road>{
		int start;
		int end;
		double len;
		public Road(int start, int end, double len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}
		@Override
		public int compareTo(Road o) {
			if(this.len<o.len)
		          return -1;
		    else if(o.len<this.len)
		          return 1;
		    return 0;
		}
		
		
	}
}
