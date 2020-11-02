package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class permutation_5656 {

	private static int[] input;
	private static int W;
	private static int N;
	private static int[] top;
	private static int[][] map;
	private static int H;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			top = new int[W];
			for (int i = 0; i < W; i++) {
				for (int j = 0; j <H; j++) {
					if(map[j][i]!=0) {
						 top[i] = j;
						 break;
					}
				}
			}
			input = new int[N];
			permutation(0);
			System.out.println("#"+t+" "+min);
		}
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			Bomb();
			return;
		}
		for (int i = 0; i < W; i++) {
			input[cnt] = i;
			permutation(cnt+1);
		}
	}

	private static void Bomb() {
		int[][] copyMap = copyM();
		int[] copyTop = Arrays.copyOf(top, top.length);
		for (int i = 0; i < N; i++) {
			hit(copyMap, copyTop, input[i]);
			move(copyMap, copyTop);
		}
		int sum = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(copyMap[i][j]>0) {
					sum++;
				}
			}
		}
		if(sum<min) {
			min = sum;
		}
	}

	private static void move(int[][] copyMap, int[] copyTop) {
		for (int i = 0; i < W; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = H-1; j >= 0; j--) {
				if(copyMap[j][i]>0) {
					list.add(copyMap[j][i]);
					copyMap[j][i] = 0;
				}
			}
			for (int j = 0; j < list.size(); j++) {
				copyMap[H-1-j][i] = list.get(j);
			}
			copyTop[i] = H-list.size();
			if(list.size()==0) {
				copyTop[i]= H-1;
			}
		}
		
	}

	private static void hit(int[][] map, int[] top, int n) {
		if(map[top[n]][n]==0) {
			return;
		}
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(new Node(top[n],n,map[top[n]][n]));
		map[top[n]][n] = 0;
		while(!qu.isEmpty()) {
			Node now = qu.poll();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < now.val; j++) {
					int r = now.r + dr[i]*j;
					int c = now.c + dc[i]*j;
					if(r<0||r>=H||c<0||c>=W) continue;
					if(map[r][c]>1) {
						qu.offer(new Node(r,c,map[r][c]));
					}
					map[r][c] = 0;
				}
			}
		}
		
	}

	private static int[][] copyM() {
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	static class Node{
		int r;
		int c;
		int val;
		public Node(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}
	

}
