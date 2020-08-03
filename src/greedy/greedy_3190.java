package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class greedy_3190 {
	static int[][] board;
	static int N, dir, second;
	static int[] dr = { -1, 0, 1, 0 }; // 상, 오, 아, 왼
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] snake;
	static boolean die = false;
	static Queue<int[]> qu = new LinkedList<int[]>(); // 꼬리 인덱스 저장용 
	private static int c;
	private static int r;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		board = new int[N+1][N+1]; // 보
		snake = new boolean[N+1][N+1]; // 뱀이 있는 구
		
		StringTokenizer st;
		int apple = Integer.parseInt(br.readLine());
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine()," ");
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		int[][] m = new int[L][2];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine()," ");
			m[i][0] = Integer.parseInt(st.nextToken()); //
			if(st.nextToken().equals("D")) {
				m[i][1] = 1; //오른쪽이면 1
			}else {
				m[i][1] = 3; // 왼쪽이면 3
			}
		}
		
		r = 1;  // 가로 
		c = 1; // 세로 
		dir = 1; // 방향 0. 위 1. 오른쪽 2. 아래 3. 왼쪽 
		second = 0; // 초 
		qu.offer(new int[] {1,1});
		snake[1][1] = true;
		for (int i = 0; i < m.length; i++) {
			while(!die&&second<m[i][0]) {
				whileOneSecond();
			}
			dir = dir + m[i][1];
		}
		while(!die) {
			whileOneSecond();
		}
	}

	private static void whileOneSecond() {
		second++;
		int row = r + dr[dir%4];
		int col = c + dc[dir%4];
		if(inBoard(row,col)==false||snake[row][col]==true) {
			System.out.println(second);
			die = true;
			return;
		}
		if(board[row][col]!=1) {
			int[] temp = qu.poll();
			snake[temp[0]][temp[1]] = false;
		}else {
			board[row][col]=0;
		}
		r = row;
		c = col;
		snake[r][c] = true;
		qu.offer(new int[] {r,c});
		
	}

	private static boolean inBoard(int row, int col) {
		if (row == 0 || row == N + 1 || col == 0 || col == N + 1) { // 죽
			return false;
		}
		return true;
	}
	

}
