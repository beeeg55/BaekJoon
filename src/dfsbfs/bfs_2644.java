package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2644 {

	static int map[][];
	static int visit[];
	static int count = 0;
	public static void bfs(int e, int tar2) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(e);
		visit[e]=1;
		while(!q.isEmpty()){
			int temp = q.poll();
			for(int i=1;i<map.length;i++){
				if(visit[i]==0 && map[temp][i]== 1){
					map[temp][i]= 1;
					q.add(i);
					visit[i]=visit[temp]+1;
				}
			}
			if(visit[tar2]!=0) break;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		int tar1 = Integer.parseInt(st.nextToken());
		int tar2 = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		visit = new int[n+1];
		for(int i=0;i<n+1;i++){
		 Arrays.fill(map[i],0);
		}
		Arrays.fill(visit,0);
		
		for(int i=0;i<k;i++){
			String s2 = br.readLine();
			StringTokenizer st2 =new StringTokenizer(s2," ");
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfs(tar1,tar2);
		if(visit[tar2]!=0){
			System.out.println(visit[tar2]-1);
		}else{
			System.out.println(-1);
		}
		
	}

}
