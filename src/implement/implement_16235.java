package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class implement_16235 {

	private static int N;
	private static int M;
	private static ArrayList[][] map;
	private static int[][] cur;
	private static int[][] add;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		add = new int[N+1][N+1];
		cur = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				cur[i][j] = 5;
			}
		}
		for (int i = 1; i < N+1; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j < N+1; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map = new ArrayList[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j] = new ArrayList<Integer>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y].add(z);
		}
		int year = 0;
		while(year++<K) {
			springAndSummer();
			autumn();
			winter();
		}
		System.out.println(findAlive());
	}

	private static void autumn() {
		int[] dr = {-1,-1,-1, 0, 0, 1,1,1};
		int[] dc = {-1, 0, 1,-1, 1,-1,0,1};
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				int size = map[i][j].size();
				if(size>0) {
					Iterator<Integer> iter = map[i][j].iterator();
					int flag = 0;
					
					while(iter.hasNext()) {
						if(iter.next()%5==0) {
							flag++;
						}
					}
					if(flag>0) {
						for (int k = 0; k < 8; k++) {
							int r = i + dr[k];
							int c = j + dc[k];
							if(0<r&&r<=N&&0<c&&c<=N) {
								for (int l = 0; l < flag; l++) {
									map[r][c].add(1);
								}
							}
						}
					}
				}
			}
		}
		
	}

	private static int findAlive() {
		int answer = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				int size = map[i][j].size();
				if(size>0) {
					answer += size;
				}
			}
		}
		return answer;
	}

	private static void springAndSummer() {
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				int size = map[i][j].size();
				if(size!=0) {
					Collections.sort(map[i][j]);
					int die = 0;
					int dieIndex = -1;
					for (int k = 0; k < size; k++) {
						int age = (int) map[i][j].get(k);
						if(age<=cur[i][j]) {
							cur[i][j] -= age;
							map[i][j].set(k, age+1);
						}else {
							dieIndex = k;
							break;
						}
					}
					if(dieIndex==-1)continue;
					for (int k = size-1; k >= dieIndex; k--) {
						int age = (int) map[i][j].get(k);
						cur[i][j] += age/2;
						map[i][j].remove(k);
					}
					
				}
			}
		}
	}
	private static void winter() {
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				cur[i][j] += add[i][j];
			}
		}
	}

}
