package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_1068 {

	private static int N;
	private static int[][] arr;
	private static boolean[] isDelete;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1)
				continue;
			arr[parent][i] = 1;
		}
		isDelete = new boolean[N];
		int delete = Integer.parseInt(br.readLine());
		deleteNode(delete);
		isDelete[delete] = true;

		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(isDelete[i]) continue;
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void deleteNode(int delete) {
		for (int i = 0; i < N; i++) {
			if (arr[delete][i] == 1) {
				isDelete[i] = true;
				deleteNode(i);
			}
			if (arr[i][delete] == 1) {
				arr[i][delete] = 0;
			}
		}

	}

}
