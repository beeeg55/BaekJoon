package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarysearch_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String hasCard = br.readLine(); 
		StringTokenizer st = new StringTokenizer(hasCard," ");
		int[] card = new int[n];
		for(int i=0;i<n;i++){
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card); // 이분탐색을 위한 정렬
		
		int m = Integer.parseInt(br.readLine());
		String searchCard = br.readLine(); 
		st = new StringTokenizer(searchCard," ");
		for(int i=0;i<m;i++){
			int k = Integer.parseInt(st.nextToken());
			while()
		}
		
	}

}
