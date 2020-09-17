package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_19238 {

	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };
	private static int N;
	private static int[][] map;
	private static int destR;
	private static int destC;
	private static int oil;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		int driverR = Integer.parseInt(st.nextToken());
		int driverC = Integer.parseInt(st.nextToken());
		int[][] dest = new int[M + 1][2];
		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int destR = Integer.parseInt(st.nextToken());
			int destC = Integer.parseInt(st.nextToken());
			map[startR][startC] = i;
			dest[i][0] = destR;
			dest[i][1] = destC;
		}
		while (M-- > 0) {
			// 손님 최단거리 찾기
			int startR;
			int startC;
			if (map[driverR][driverC] > 0) {
				startR = driverR;
				startC = driverC;
				destR = dest[map[driverR][driverC]][0];
				destC = dest[map[driverR][driverC]][1];
			} else {
				// 목적지까지 최단경로 찾기
				int[] pick = pickCustomer(driverR, driverC);
				if (oil - pick[0] <= 0) {
					System.out.println(-1);
					System.exit(0);
				}
				oil -= pick[0];
				destR = dest[pick[1]][0];
				destC = dest[pick[1]][1];
				startR = pick[2];
				startC = pick[3];

			}
			map[startR][startC] = 0;
			int len = go(startR, startC);
			driverR = destR;
			driverC = destC;
			if (oil - len < 0) {
				System.out.println(-1);
				System.exit(0);
			}
			// 목적지에서 오일 더해주기
			oil += len;

		}
		System.out.println(oil);
	}

	private static int go(int startR, int startC) {
		boolean[][] visit = new boolean[N + 1][N + 1];
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { startR, startC });
		visit[startR][startC] = true;
		int len = 0;
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int s = 0; s < size; s++) {
				int[] temp = qu.poll();
				for (int i = 0; i < 4; i++) {
					int r = temp[0] + dr[i];
					int c = temp[1] + dc[i];
					if (1 <= r && r < N + 1 && 1 <= c && c < N + 1 && map[r][c] != -1 && !visit[r][c]) {
						visit[r][c] = true;
						qu.add(new int[] { r, c });
						if (r == destR && c == destC) {
							return len + 1;
						}
					}
				} // end of for find
			} // end of for size
			len++;
			if (oil - len < 0) {
				System.out.println(-1);
				System.exit(0);
			}
		} 
		// 벽때매 목적지 도달 못할 경우  
		System.out.println(-1);
		System.exit(0);
		return len;
	}

	public static int[] pickCustomer(int drivR, int drivC) {
		boolean[][] visit = new boolean[N + 1][N + 1];
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] { drivR, drivC });
		visit[drivR][drivC] = true;
		int len = 0;
		int find = Integer.MAX_VALUE; // 출발지점 선택
		int findR = Integer.MAX_VALUE;
		int findC = Integer.MAX_VALUE;
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int s = 0; s < size; s++) {
				int[] temp = qu.poll();
				for (int i = 0; i < 4; i++) {
					int r = temp[0] + dr[i];
					int c = temp[1] + dc[i];
					if (1 <= r && r < N + 1 && 1 <= c && c < N + 1 && map[r][c] != -1 && !visit[r][c]) {
						visit[r][c] = true;
						if (map[r][c] == 0) {
							qu.add(new int[] { r, c });
						} else {
							// 우선순위 적용 
							if (findR > r || findR == r && findC > c) {
								find = map[r][c];
								findR = r;
								findC = c;
							}
						}
					}
				} // end of for find
			} // end of for size
			len++;
			// 출발지를 들어갈때까지 
			if (find != Integer.MAX_VALUE) {
				break;
			}
		} // end of while
		// 벽때매 어느 출발지로도 못갈경우 
		if (find == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		return new int[] { len, find, findR, findC };
	}
}
