package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bfs_2638 {
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,1,-1,0};
	private static boolean[][] visit;
	private static int[][] map;
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheese++;
				}
			}
		}
		Bfs(0,0);
		int time = 0;
		while(true) {
			if(cheese==0) {
				break;
			}
			time++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int r = i + dr[k];
							int c = j + dc[k];
							if(0<=r&&r<N&&0<=c&&c<M&&visit[r][c]&&map[r][c]==2) {
								cnt++;
							}
						}
						if(cnt>1) {
							visit[i][j] = true;
							map[i][j] = 0;
							cheese--;
						}
					}
					
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0&&visit[i][j]) {
						Bfs(i,j);
					}
				}
			}
			
		}
		
		System.out.println(time);
	
	}



	private static void Bfs(int a, int b) {
		LinkedList<int[]> qu = new LinkedList<>();
		qu.add(new int[] {a,b});
		map[a][b] = 2;
		visit[a][b] = true;
		while(!qu.isEmpty()) {
			int temp[] = qu.poll();
			for (int i = 0; i < 4; i++) {
				int r = temp[0] + dr[i];
				int c = temp[1] + dc[i];
				if(0<=r&&r<N&&0<=c&&c<M&&map[r][c]==0&&!visit[r][c]) {
					map[r][c] = 2;
					visit[r][c] = true;
					qu.add(new int[] {r,c});
				}
				
			}
		}
		
	}

}
