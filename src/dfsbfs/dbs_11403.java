package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dbs_11403 {
	static int map[][];
	static boolean visit[];
	static boolean r;
	public static void dfs(int a,int b) {
		if(a!=b){
			visit[a]=true;
		}
		for(int i=0;i<map.length;i++){
			if(map[a][i]==1&& visit[i]==false){
				if(i==b){
					r=true;
					break;
				}
				dfs(i,b);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n];
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dfs(i,j);
				if(r==true){
					map[i][j]=1;
					r=false;
				}
				Arrays.fill(visit,false);
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
