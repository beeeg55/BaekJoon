package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_7576_여러지점시작 {
	static int map[][];
	static boolean visit[][];
	static int M,N;
	static int rl[] = {0,0,-1,1};
	static int ud[] = {1,-1,0,0};
	public static void bfs(){
		
		Queue<int[]> q = new LinkedList<int[]>();
		 for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (map[i][j] == 1)
	                    //익은 토마토가 있는 모든 위치를 큐에 담는다.
	                	q.offer(new int[] {i,j});
	            }
	        }
		while(!q.isEmpty()){
			int l[] = q.poll();
			for(int i =0;i<4;i++){
				int r = l[0] + rl[i]; 
				int c = l[1] + ud[i];
				if(r>=0&&c>=0&&r<N&&c<M){
					if(visit[r][c]==false && (map[r][c]==0||map[r][c]>1)){
						map[r][c]=map[l[0]][l[1]]+1;
						visit[r][c]=true;
						q.offer(new int[] {r,c});
					}
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
	
		for(int i=0;i<N;i++){
			s = br.readLine();
			st =new StringTokenizer(s," ");
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		boolean hasZero = false;
		int max = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				max = Math.max(max,map[i][j]);
				if(map[i][j]==0){
					hasZero = true;
				}
			}
		}
		if(hasZero==true){
			System.out.println(-1);
		}else{
			System.out.println(max-1);
		}
		
	}
}
