package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarysearch_10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sang = new int[n];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		for(int i=0;i<n;i++){
			sang[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sang);
		int m = Integer.parseInt(br.readLine());
		int[] search = new int[m];
		s = br.readLine();
		st = new StringTokenizer(s," ");
		for(int i=0;i<m;i++){
			search[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++){
			System.out.print(findCard(sang,search[i])+" ");
		}
	}
	public static int findCard(int[] sang, int t){
		int left = 0;
		int right = sang.length;
		while(right-left>1){
			int medium = (left+right)/2;
			if(sang[0]==t) return 1;
			if(sang[sang.length-1]==t) return 1;
			if(t<sang[medium]){
				right = sang[medium]-1;
			}else if(t>sang[medium]){
				left = sang[medium]+1;
			}else{
				return 1;
			}
		}
		return 0;
	}
}
