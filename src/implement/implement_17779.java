package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class implement_17779 {

	private static int[][] map;
	private static int N;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int x = 1; x < N + 1; x++) {
			for (int y = 1; y < N + 1; y++) {
				for (int d1 = 1; d1 < N + 1; d1++) {
					for (int d2 = 1; d2 < N + 1; d2++) {
						if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
							divide(x, y, d1, d2);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static void divide(int x, int y, int d1, int d2) {
		int[][] visit = new int[N + 1][N + 1];
		int[] count = new int[5];
		
		int[] check = new int[N+1];
		for (int i = 0; i <= d1; i++) {
			visit[x+i][y-i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			visit[x+i][y+i] = 5;
		}
		for (int i = 0; i <= d2; i++) {
			visit[x+d1+i][y-d1+i] = 5;
		}
		for (int i = 0; i <= d1; i++) {
			visit[x+d2+i][y+d2-i] = 5;
		}
		for (int i = 1; i < N+1; i++) {
			int cnt = 0;
			for (int j = 1; j < N+1; j++) {
				if(visit[i][j]==5) {
					cnt++;
				}
			}
			if(cnt==2) {
				int start = 0;
				for (int j = 1; j < check.length; j++) {
					if(visit[i][j]==5) {
						start = j;
						break;
					}
				}
				for (int j = start+1; j < check.length; j++) {
					if(visit[i][j]==5) {
						break;
					}
					visit[i][j]=5;
				}
			}
		}

		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if(visit[i][j]==5) {
					count[4] += map[i][j];
					continue;
				}
				if (1 <= i && i < x + d1 && 1 <= j && j <= y) {
					visit[i][j] = 1;
					count[0] += map[i][j];
				} else if (1 <= i && i <= x + d2 && y < j && j <= N) {
					visit[i][j] = 2;
					count[1] += map[i][j];
				} else if (x + d1 <= i && i <= N && 1 <= j && j < y - d1 + d2) {
					visit[i][j] = 3;
					count[2] += map[i][j];
				} else if (x + d2 < i && i <= N && y - d1 + d2 <= j && j <= N) {
					visit[i][j] = 4;
					count[3] += map[i][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] < min) {
				min = count[i];
			}
			if (count[i] > max) {
				max = count[i];
			}
		}
		
		if(min==0) return;
		if (max - min < answer) {
			answer = max - min;
		}

	}

}
