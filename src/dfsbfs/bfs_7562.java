package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_7562 {

	private static int[][] arr;
	private static boolean[][] visit;
	static int[] dr = {2,2,1,1,-1,-1,-2,-2};
	static int[] dc = {1,-1,2,-2,2,-2,-1,1};
	private static int l;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			l = Integer.parseInt(br.readLine());
			arr = new int[l][l];
			visit = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int cr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int destr = Integer.parseInt(st.nextToken());
			int destc = Integer.parseInt(st.nextToken());
			System.out.println(bfs(cr,cc,destr,destc));
			
		}
	}

	private static int bfs(int cr, int cc, int destr, int destc) {
		if(destr==cr&&destc==cc) {
			return 0;
		}
		visit[cr][cc] = true;
		int step = 0;
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {cr,cc});
		while(!qu.isEmpty()) {
			int qusize = qu.size();
			for (int size = 0; size < qusize; size++) {
				int[] temp = qu.poll();
				for (int i = 0; i < 8; i++) {
					int nr = temp[0] + dr[i];
					int nc = temp[1] + dc[i];
					if(isRange(nr,nc)&&!visit[nr][nc]) {
						if(destr==nr&&destc==nc) {
							return step+1;
						}
						visit[nr][nc] = true;
						qu.add(new int[] {nr,nc});
					}
				}
			}
			step++;
		}
		return step;
	}

	private static boolean isRange(int nr, int nc) {
		if(nr>=0&&nr<l&&nc>=0&&nc<l) {
			return true;
		}
		return false;
	}

}
