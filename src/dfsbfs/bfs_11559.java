package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_11559 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static LinkedList<int[]> puyo; // 터트릴 뿌요 저장 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6]; 
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int answer = 0;
		
		while(true) {
			puyo = new LinkedList<>();
			visited = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(map[i][j]!= '.'  && !visited[i][j]) {
						int cnt = countPuyo(i,j); 
						if(cnt<4) { // 4개 이하가 모이면 터트릴 뿌요에서 빼주기 
							while(cnt>=1) { 
								puyo.pollLast();
								cnt--;
							}
						}
					}
				}
			}
			// 터트릴 뿌요가 없으면 루프밖으로 이동 
			if(puyo.size()==0) {
				break;
			}
			// 터트릴 뿌요가 있으면 연쇄를 늘려주고 뿌요 터트리기 + 중력 적용 해주기 
			answer++;
			popPuyo(); // 뿌요 터트리기
			moveDown(); // 중력 적용 
		}
		System.out.println(answer);
		
	}
	
	public static int countPuyo(int i, int j) {
		int count = 1; // 자신도 카운트 
		Queue<int[]> qu = new LinkedList<int[]>();
		visited[i][j] = true;
		qu.add(new int[] {i,j});
		puyo.add(new int[] {i,j});
		while(!qu.isEmpty()) {
			int[] temp = qu.poll();
			for (int k = 0; k < dr.length; k++) {
				int r = temp[0] + dr[k]; 
				int c = temp[1] + dc[k];
				if(r>=0 && r<12 && c>=0 && c<6 && map[r][c] == map[i][j] && !visited[r][c]) {
					visited[r][c] = true;
					count++; 
					puyo.add(new int[] {r,c}); 
					qu.add(new int[] {r,c});
				}
			}
		}
		return count;
	}
	// 터트릴 뿌요 큐에 들어있는 뿌요들 좌표에 . 입력 
	public static void popPuyo() {
		for (int[] element : puyo) {
			for (int j = 0; j < element[0]-1; j++) {
				map[element[0]][element[1]] = '.';
			}
				
		}
	}
	
	// 터트린 뿌요까지 한칸씩 아래로 내려주고 맨 위칸은 . 입력 
	public static void moveDown() {
		for (int[] element : puyo) {
			for (int j = element[0]-1; j >= 0; j--) {
				map[j+1][element[1]] = map[j][element[1]];
			}
			map[0][element[1]] = '.';
		}
	}
}


