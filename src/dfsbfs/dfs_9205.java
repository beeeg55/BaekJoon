package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_9205 {
	private static int[][] map;
	private static boolean happy;
	private static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int csN = Integer.parseInt(br.readLine());
			map = new int[csN+2][csN+2]; 
			int[][] point = new int[csN+2][2];
			visit = new boolean[csN+2];
			st = new StringTokenizer(br.readLine(), " ");
			point[0][0] = Integer.parseInt(st.nextToken()); // 시작 지점 x
			point[0][1] = Integer.parseInt(st.nextToken()); // 시작 지점 y 
			for (int j = 1; j < 1 + csN; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[j][0] = Integer.parseInt(st.nextToken()); // 편의점 x
				point[j][1] = Integer.parseInt(st.nextToken()); // 편의점 y
			}
			st = new StringTokenizer(br.readLine(), " ");
			point[csN+1][0] = Integer.parseInt(st.nextToken()); // 축제 x
			point[csN+1][1] = Integer.parseInt(st.nextToken()); // 축제 y
			for (int i = 0; i < map.length; i++) {
				for (int j = 1+i; j < map.length; j++) {
					if(i==j) continue;
					map[i][j] = Math.abs(point[i][0]-point[j][0])+ Math.abs(point[i][1]-point[j][1]); // 거리 계산 
					map[j][i] = map[i][j]; // 무방향 
				}
			}
			happy = false;
			// 시작지점에서 축제가 1000이하이면 바로 해피 
			if(map[0][csN+1]<=1000) { 
				happy = true;
			}else {
				Dfs(0);
			}
			if(happy) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}			
			
		}
		System.out.println(sb.toString());

	}
	public static void Dfs(int start) {
		if(start == map.length - 1) {
			happy = true;
			return;
		}
		for (int i = 1; i < map.length&& !happy; i++) {
			if(map[start][i]<=1000&&!visit[i]&& !happy) { 
				visit[i] = true;
				Dfs(i);
			}
		}
	}

}
