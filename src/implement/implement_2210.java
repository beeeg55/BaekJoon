package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class implement_2210 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	private static int[][] map;
	private static HashSet<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		set = new HashSet<Integer>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				permutation(0,0,i,j);
			}
		}
		System.out.println(set.size());
	}

	private static void permutation(int cnt, int sum, int r, int c) {
		if(cnt==6) {
			set.add(sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(0<=nr&&nr<5&&0<=nc&&nc<5){
				permutation(cnt+1,sum*10+map[nr][nc],nr,nc);
			}
		}
	}
	
}
