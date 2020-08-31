package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_17142 {

	static int[][] virus;
	private static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int[][] lab;
	static int answer = Integer.MAX_VALUE;
	private static boolean[][] visit;
	private static int count;
	private static LinkedList<int[]> qu;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new int[M][2];
		lab = new int[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) count++; // 바이러스 퍼트려야 할 칸 개수 
			}
		}
		combination(0, 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	private static void combination(int start, int cnt) {
		if (cnt == M) {
			qu = new LinkedList<int[]>();
			visit = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				qu.add(new int[] { virus[i][0], virus[i][1] });
				visit[virus[i][0]][virus[i][1]] = true;
			}

			int time = Bfs();
			boolean spread = true;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (lab[i][j] == 0 && !visit[i][j]) {
						spread = false;
						break loop;
					}
				}
			}
			if (time < answer && spread) {
				answer = time;

			}

			return;

		}
		for (int i = start; i < N * N; i++) {

			if (lab[i / N][i % N] == 2) {
				virus[cnt][0] = i / N;
				virus[cnt][1] = i % N;
				combination(i + 1, cnt + 1);
			}
		}

	}

	private static int Bfs() {
		int second = 0; // 걸린 시간 
		int space = 0; // 퍼트린 칸 개수 
		if (space == count) // 이미 퍼트린 칸 개수와 퍼트릴 칸 개수가 같으면 
			return second; 
		while (!qu.isEmpty()) {
			int quSize = qu.size();
			for (int size = 0; size < quSize; size++) {
				int[] temp = qu.poll();
				for (int k = 0; k < 4; k++) {
					int r = temp[0] + dr[k];
					int c = temp[1] + dc[k];
					if (0 <= r && r < N && 0 <= c && c < N && !visit[r][c] && lab[r][c] != 1) {
						visit[r][c] = true;
						if (lab[r][c] == 0)
							space++;
						if (space == count) // 퍼트린 칸 개수와 퍼트릴 칸 개수가 같으면 
							return second+1;
						qu.add(new int[] { r, c });
					}
				}
			}
			second++;
		}
		return second;
	}

}
