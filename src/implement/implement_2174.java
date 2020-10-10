package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class implement_2174 {
	static int[] dr = { 1, 0, -1, 0 }; // 북, 동, 남, 서
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[B + 1][A + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] robot = new int[N + 1][3];

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			robot[i][1] = Integer.parseInt(st.nextToken());
			robot[i][0] = Integer.parseInt(st.nextToken());
			map[robot[i][0]][robot[i][1]] = i;
			String dir = st.nextToken();
			switch (dir) {
			case "N":
				robot[i][2] = 0;
				break;
			case "E":
				robot[i][2] = 1;
				break;
			case "S":
				robot[i][2] = 2;
				break;
			case "W":
				robot[i][2] = 3;
				break;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int rob = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			int step = Integer.parseInt(st.nextToken());
			int r = robot[rob][0];
			int c = robot[rob][1];
			int d = robot[rob][2];
			map[r][c] = 0;
			for (int j = 0; j < step; j++) {
				switch (dir) {
				case "F":
					r = r + dr[d];
					c = c + dc[d];
					if(r<1||B+1<=r||c<1||A+1<=c) {
						System.out.println("Robot "+rob+" crashes into the wall");
						System.exit(0);
					}
					if(map[r][c]!=0) {
						System.out.println("Robot "+rob+" crashes into robot "+map[r][c]);
						System.exit(0);
					}
					break;
				case "L":
					if(d==0) {
						d = 4;
					}
					d = d-1;
					break;
				case "R":
					d = (d+1)%4;
					break;
				}
			}
			robot[rob][0] = r;
			robot[rob][1] = c;
			robot[rob][2] = d;
			map[r][c] = rob;

		}
		System.out.println("OK");

	}

}

