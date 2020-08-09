package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2573 {

	private static int M;
	private static int N;
	private static int[][] orgMap;
	private static boolean[][] visited;
	private static int[] dr = {-1,0,1,0};
	private static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		orgMap = new int[N][M];
		
		br.readLine();
		for (int i = 1; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				orgMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.readLine();
		
		int year = 0;
		int count = 0;
		while(count < 2) {
			int sum = 0;
			int[][] storeZero = countZero();
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					orgMap[i][j] -= storeZero[i][j];
					if(orgMap[i][j]<0) orgMap[i][j] = 0;
					sum += orgMap[i][j];
				}
			}
			if(sum == 0) {
				year = 0;
				break;
			}
			count = 0;
			visited = new boolean[N][M];
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if(orgMap[i][j] > 0 && !visited[i][j]) {
						Bfs(i,j);
						count++;
					}
				}
			}
			year++;
		}
		
		System.out.println(year);
		
	}
	public static int[][] countZero(){
		int[][] storeZero = new int[N][M];
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				for (int k = 0; k < dc.length; k++) {
					int r = i + dr[k];
					int c = j + dc[k];
					if(orgMap[r][c] == 0) {
						storeZero[i][j]++;
					}
				}
			}
		}
		return storeZero;
	}
	
	public static void Bfs(int i, int j) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {i,j});
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < dc.length; k++) {
				int r = temp[0] + dr[k];
				int c = temp[1] + dc[k];
				if(r==0||c==0||r == N-1||c == M-1) continue;
				if(orgMap[r][c] > 0 && !visited[r][c]) {
					visited[r][c] = true;
					qu.add(new int[] {r,c});
				}
			}
		}
	}
}
