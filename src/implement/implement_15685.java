package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	private static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visit = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list = new ArrayList<Integer>();
			// 0세대
			list.add(d);
			// 1~n 세대
			for (int j = 1; j <= g; j++) {
				int size = list.size();
				for (int k = size - 1; k >= 0; k--) {
					int curD = (list.get(k) + 1) % 4;
					list.add(curD);
				}
			}
			visit[x][y] = true;
			for (int j = 0; j < list.size(); j++) {
				int curD = list.get(j);
				x += dx[curD];
				y += dy[curD];
				visit[x][y] = true;
			}
		}
		int count = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (visit[r][c] && visit[r + 1][c] && visit[r][c + 1] && visit[r + 1][c + 1]) {
//					System.out.println(r+" "+c);
					count++;
					
				}
			}
		}
		System.out.println(count);
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

