package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class dfs_2667 {
	static int map[][];
	static boolean vmap[][];
	static int num = 0;
	public static int dfs(int i, int j) {
		vmap[i][j]=true;
		if(i!=0){
			if(map[i-1][j]==1&&vmap[i-1][j]==false){
				dfs(i-1,j);
			}
		}
		if(i!=map.length-1){
			if(map[i+1][j]==1&&vmap[i+1][j]==false){
				dfs(i+1,j);
			}
		}
		if(j!=0){
			if(map[i][j-1]==1&&vmap[i][j-1]==false){
				dfs(i,j-1);
			}
		}
		if(j!=map.length-1){
			if(map[i][j+1]==1&&vmap[i][j+1]==false){
				dfs(i,j+1);
			}
		}
		num++;
		return num;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n]; 
		vmap = new boolean[n][n];
		
		for(int j=0; j<n;j++){
			Arrays.fill(map[j], 0);
		}
		for(int j=0; j<n;j++){
			Arrays.fill(vmap[j], false);
		}
		for(int i=0;i<n;i++){
			s = br.readLine();
			for(int j=0;j<n;j++){
				map[i][j]=Character.getNumericValue(s.charAt(j));
			}
		}
		int count = 0;
		LinkedList<Integer> li = new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(vmap[i][j]==false&&map[i][j]==1){
					count++;
					num = 0;
					li.add(dfs(i,j));
				}
			}
		}

		System.out.println(count);
		Collections.sort(li);
		Iterator<Integer> i = li.iterator();
        
		for (int item : li) {
		    System.out.println(item);
		}
		
	}
}
