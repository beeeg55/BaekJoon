package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2583 {

	static int map[][];
	static boolean visit[][];
	static int rl[] = {0,0,-1,1};
	static int ud[] = {1,-1,0,0};
	static int M,N,K;
	public static int bfs(int y, int x) {
		int max = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {y,x});
		visit[y][x]=true;
		while(!q.isEmpty()){
			int l[] = q.poll();
			for(int i =0;i<4;i++){
				int r = l[0] + rl[i]; 
				int c = l[1] + ud[i];
				if(r>=0&&c>=0&&r<M&&c<N){
					if(visit[r][c]==false){
						max++;
						visit[r][c] = true;
						map[r][c] = map[l[0]][l[1]]+1;
						q.offer(new int[] {r,c});
					}
				}
			}
			
		}
		return max;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visit = new boolean[M][N];
		for(int i=0;i<M;i++){
			Arrays.fill(map[i],0);
		}
		for(int i=0;i<M;i++){
			Arrays.fill(visit[i],false);
		}
		for(int i=0;i<K;i++){
			s = br.readLine();
			st =new StringTokenizer(s," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int y=y1;y<y2;y++){
				for(int x=x1;x<x2;x++){
					visit[y][x] = true;
				}
			}
		}
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int y=0;y<M;y++){
			for(int x=0;x<N;x++){
				if(visit[y][x]==false){
					count++;
					arr.add(bfs(y,x)+1);
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(arr);
		for(int i:arr){
			System.out.print(i+" ");
		}
		
		
	}
}
