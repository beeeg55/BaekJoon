package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_2606 {
	static int map[][];
	static boolean visit[];
	static int count = 0;
	public static void dfs(int e) {
		visit[e]=true;
		for(int i=1;i<map.length;i++){
			if(visit[i]==false && map[i][e]==1){
				count++;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		map = new int[c+1][c+1];
		visit = new boolean[c+1];
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		dfs(1);
		System.out.println(count);
	}
	

}
