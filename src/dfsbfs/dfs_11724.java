package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dfs_11724 {
	static int map[][];
	static boolean visit[];
	public static void dfs(int e) {
		visit[e]=true;
		for(int i=1;i<map.length;i++){
			if(visit[i]==false && map[i][e]==1){
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Character.getNumericValue(0);
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0;i<n+1;i++){
			 Arrays.fill(map[i],0);
			}
		Arrays.fill(visit,false);
		
		for(int i=0;i<m;i++){
			String s2 = br.readLine();
			StringTokenizer st2 =new StringTokenizer(s2," ");
			
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		int count = 0;
		for(int i=1;i<n+1;i++){
			if(visit[i]==false){
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

}
