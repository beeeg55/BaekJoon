package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.tools.DocumentationTool.Location;

public class dfsbfs_2178 {
	
	static int map[][];
	static boolean visit[][];
	static int rl[] = {0,0,-1,1};
	static int ud[] = {1,-1,0,0};
	static int N,M;
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		visit[x][y]=true;
		while(!q.isEmpty()){
			int l[] = q.poll();
			for(int i =0;i<4;i++){
				int r = l[0] + rl[i]; 
				int c = l[1] + ud[i];
				if(r>=0&&c>=0&&r<N&&c<M){
					if(visit[r][c]==false && map[r][c]!=0){
						visit[r][c] = true;
						map[r][c] = map[l[0]][l[1]]+1;
						q.offer(new int[] {r,c});
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++){
		 Arrays.fill(map[i],0);
		}
		for(int i=0;i<N;i++){
			 Arrays.fill(visit[i],false);
		}
		for(int i=0;i<N;i++){
			s = br.readLine();
			for(int j=0;j<M;j++){
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		bfs(0,0);
		
		System.out.println(map[N-1][M-1]);
		
	}
}
