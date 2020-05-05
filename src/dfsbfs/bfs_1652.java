package dfsbfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_1652 {
	
	static char map[][];
	static boolean visit[][];
	static int N;
	public static int row(int x, int y) {
		int count = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		visit[x][y]=true;
		while(!q.isEmpty()){
			int l[] = q.poll(); 
			int c = l[1] + 1;
			if(c>=0&&c<N){
				if(visit[x][c]==false && map[x][c]=='.'){
					visit[x][c] = true;
					q.offer(new int[] {x,c});
					count++;
				}
			}
		}
		return count;
	}
	public static int column(int x, int y) {
		int count = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		visit[x][y]=true;
		while(!q.isEmpty()){
			int l[] = q.poll(); 
			int c = l[0] + 1;
			if(c>=0&&c<N){
				if(visit[c][y]==false && map[c][y]=='.'){
					visit[c][y] = true;
					q.offer(new int[] {c,y});
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++){
			String s = br.readLine();
			for(int j=0;j<N;j++){
				map[i][j] = s.charAt(j);
			}
		}

		
		for(int i=0;i<N;i++){
			 Arrays.fill(visit[i],false);
		}
		
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<N;i++){
			 for(int j=0;j<N;j++){
				 if(visit[i][j]==false&&map[i][j]=='.'){
					 if(row(i,j)>=2){
						 count1++;
					 }
				 }
			 }
		}
		for(int i=0;i<N;i++){
			 Arrays.fill(visit[i],false);
		}

		for(int i=0;i<N;i++){
			 for(int j=0;j<N;j++){
				 if(visit[i][j]==false&&map[i][j]=='.'){
					 if(column(i,j)>=2){
						 count2++;
					 }
				 }
			 }
		}
		System.out.println(count1+" "+count2);
	}
}