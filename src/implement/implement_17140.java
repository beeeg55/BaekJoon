package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class implement_17140 {
	static int maxR;
	static int maxC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		
		maxR = 3;
		maxC = 3;
		int[][] result = null;
		while(time<101) {
			if(r<maxR&&c<maxC&&arr[r][c]==k) {
				System.out.println(time);
				System.exit(0);
			}
			
			if(maxR >= maxC) {
				arr = funcR(arr);
			}else {
				arr = funcC(arr);
			}
			time++;
			
		}
		System.out.println(-1);
		
	}

	private static int[][] funcR(int[][] arr) {
		int max = 0;
		ArrayList[] result = new ArrayList[arr.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<Integer>();
 		}
		for (int i = 0; i < maxR&&i<101; i++) {
			int[] cnt = new int[101];
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < maxC &&j<101; j++) {
				if(arr[i][j]==0) continue;
				if(cnt[arr[i][j]]==0) {
					list.add(arr[i][j]);
				}
				cnt[arr[i][j]]++;
			}
			Num[] temp = new Num[list.size()];
			for (int j = 0; j < list.size(); j++) {
				int k = list.get(j);
				temp[j] = new Num(k,cnt[k]);
			}
			Arrays.sort(temp);
			for (Num num: temp) {
				result[i].add(num.n);
				result[i].add(num.countN);
			}
			if(list.size()*2>max) {
				max = list.size()*2;
			}
			
		}
		maxC = max;
		
		int N = Math.max(maxR, maxC);
		int[][] newarr = new int[N][N];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].size(); j++) {
				newarr[i][j] = (int) result[i].get(j);
			}
		}
		return newarr;
		
	}
	
	private static int[][] funcC(int[][] arr) {
		int max = 0;
		ArrayList[] result = new ArrayList[arr[0].length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<Integer>();
 		}
		for (int i = 0; i < maxC&&i<101; i++) {
			int[] cnt = new int[101];
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < maxR&j<101; j++) {
				if(arr[j][i]==0) continue;
				if(cnt[arr[j][i]]==0) {
					list.add(arr[j][i]);
				}
				cnt[arr[j][i]]++;
			}
			Num[] temp = new Num[list.size()];
			for (int j = 0; j < list.size(); j++) {
				int k = list.get(j);
				temp[j] = new Num(k,cnt[k]);
			}
			Arrays.sort(temp);
			for (Num num: temp) {
				result[i].add(num.n);
				result[i].add(num.countN);
			}
			if(list.size()*2>max) {
				max = list.size()*2;
			}
			
		}
		
		maxR = max;
		
		int N = Math.max(maxR, maxC);
		int[][] newarr = new int[N][N];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].size(); j++) {
				newarr[j][i] = (int) result[i].get(j);
			}
		}
		return newarr;
		
	}
	static class Num implements Comparable<Num>{
		int n;
		int countN;
		
		public Num(int n, int countN) {
			this.n = n;
			this.countN = countN;
		}

		@Override
		public int compareTo(Num o) {
			if(this.countN == o.countN) {
				return this.n - o.n;
			}
			return this.countN - o.countN;
		}
	}

}
