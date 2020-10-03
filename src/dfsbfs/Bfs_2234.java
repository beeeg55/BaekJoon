package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2234 {
	static int[] dr = {0,-1,0,1};
	static int[] dc = {-1,0,1,0};
	private static int[][] visit;
	private static boolean[][][] wall;
	private static int n;
	private static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		wall = new boolean[m][n][4]; // 0: 서 1: 북 2: 동 3: 남 
		//1: 서 2: 북 4: 동 8: 남
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				for (int k = 0; k < 4; k++) {
					if((temp&(1<<k))>0) {
						wall[i][j][k] = true;
					}
				}
			}
		}
		visit = new int[m][n];
		int area = 1;
		int max1 = 0;
		LinkedList<Integer> size = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(visit[i][j]==0) {
					int sum = bfs(i,j,area);
					if(max1<sum) {
						max1 = sum;
					}
					size.add(sum);
					area++;
				}
			}
		}
		int max2 = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int r = i+dr[k];
					int c = j+dc[k];
					if(0<=r&&r<m&&0<=c&&c<n&&wall[i][j][k]&&visit[r][c]!=visit[i][j]) {
						int sum = size.get(visit[r][c]-1)+ size.get(visit[i][j]-1);
						if(max2<sum) {
							max2 = sum;
						}
					}
				}
			}
		}
		System.out.println(area-1);
		System.out.println(max1);
		System.out.println(max2);
	}
	private static int bfs(int i, int j, int area) {
		int sum = 1;
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {i,j});
		visit[i][j] = area;
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < 4; k++) {
				int r = temp[0]+dr[k];
				int c = temp[1]+dc[k];
				if(0<=r&&r<m&&0<=c&&c<n&&!wall[temp[0]][temp[1]][k]&&visit[r][c]==0) {
					visit[r][c]=area;
					qu.add(new int[] {r,c});
					sum++;
				}
			}
		}
		return sum;
	}

}
