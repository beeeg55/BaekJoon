package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_1697 {
	static int[] map = new int[1000001];
	static boolean[] visit =new boolean[1000001];
	
	public static void bfs(int e, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(e);
		visit[e]=true;
		while(!q.isEmpty()){
			int temp = q.poll();
			if(temp+1<=1000000){
				if(visit[temp+1]==false){
					map[temp+1]= map[temp]+1;
					visit[temp+1] = true;
					if(temp+1==k)break;
					q.add(temp+1);
				}
			}
			
			if(temp-1>=0){
				if(visit[temp-1]==false){
					map[temp-1]= map[temp]+1;
					visit[temp-1] = true;
					if(temp-1==k)break;
					q.add(temp-1);
				}
			}
			
			if(temp*2<=1000000){
				if(visit[temp*2]==false){
					map[temp*2]= map[temp]+1;
					visit[temp*2] = true;
					if(temp*2==k)break;
					q.add(temp*2);
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Arrays.fill(map,0);
		//Arrays.fill(visit,false);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N,K);
		
		System.out.println(map[K]);
	}

}
