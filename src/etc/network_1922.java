package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class network_1922 {
	static int map[][];
	static boolean visit[];
	public static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(e);
		visit[e]=true;
		while(!q.isEmpty()){
		int temp = q.poll();
		System.out.print(temp+" ");
		for(int i=1;i<map.length;i++){
			if(visit[i]==false && map[temp][i]==1){
				q.add(i);
				visit[i]=true;
			}
		}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0;i<N+1;i++){
		 Arrays.fill(map[i],0);
		}
		Arrays.fill(visit,false);
		int min = 0;
		int mina = 0;
		int minb = 0;
		for(int i=0;i<M;i++){
			for(int j=0;j<3;j++){
				String s = br.readLine();
				StringTokenizer st =new StringTokenizer(s," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(j==0){
					mina = a;
					minb = b;
					min = c;
				}else{
					if(c<min){
						mina = a;
						minb = b;
						min = c;
					}
				}
				map[a][b] = c;
				map[b][a] = c;
			}
		}
		bfs(mina,minb);
		
		
	}

}
