package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_1303 {

	private static char[][] map;
	private static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int B = 0;
		int W = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					int point = Bfs(i,j);
					if(map[i][j]=='B') {
						B += Math.pow(point, 2);
					}else {
						W += Math.pow(point, 2);
					}
				}
			}
		}
		System.out.println(W+" "+B);
		

	}

	private static int Bfs(int i, int j){
		int cnt = 1;
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {i,j});
		visit[i][j] = true;
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < 4; k++) {
				int r =  temp[0] + dr[k];
				int c =  temp[1] + dc[k];
				if(0<=r&&r<M&&0<=c&&c<N&&!visit[r][c]&&map[r][c]==map[i][j]) {
					qu.add(new int[] {r,c});
					visit[r][c] = true;
					cnt++;
				}
			}
			
		}
		return cnt;
	}

}
