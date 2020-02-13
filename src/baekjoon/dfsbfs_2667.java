package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;
//¹Ì¿Ï·á
public class dfsbfs_2667 {
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		int num = Integer.parseInt(s1);

		int[][] map = new int[num+1][num+1];
		for(int i=0;i<num+1;i++){
		Arrays.fill(map[i], 0);
		}
		
		boolean[][] visit = new boolean[num+1][num+1];
		for(int i=0;i<num+1;i++){
			Arrays.fill(visit[i],false);
		}
		
		String s2 = br.readLine();
		StringTokenizer st = new StringTokenizer(s2," ");
		
		for(int i=1;i<num+1;i++){
			for(int j=1;j<num+1;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		CountApt();
		
	}

	public static void CountApt(){
		int count=0;
		for(int i=1;i<map.length;i++){
			for(int j=1;j<map.length;j++){
				if(visit[i][j]==false & map[i][j]==1){
					dfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int a,int b) {
		visit[a][b]=true;
		for(int i=1;i<map.length;i++){
			for(int j=1;j<map.length;j++){
				
			}
		}
	}
}
