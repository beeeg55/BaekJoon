package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class array_5567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 동기의 수  
		int m = Integer.parseInt(br.readLine()); // 리스트 길이 
		int list[][] = new int[m][2];
		int[] friends = new int[n+1]; // 친구인지 여부 
		
		int directFriendCnt = 0; // 상근이 친구 수 
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			if(list[i][0]==1) {
				directFriendCnt++;
			}
		}
		
		// 상근이 친구부터 처리하기 위한 정렬 
		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		// 1. 자신 2. 상근이 친구 3. 상근이 친구친구 
		friends[1] = 1; 
		// 상근이 친구 2로 처리 
		for (int i = 0; i < directFriendCnt; i++) {
				friends[list[i][1]] = 2;
			
		}
		
		// 상근이 친구친구 처리 
		for (int i = directFriendCnt; i < m; i++) {
			if(friends[list[i][0]]==2&&friends[list[i][1]]==2) continue; // 둘다 상근이 친구면 패스 
			// 한명이라도 상근이 친구면 친구친구로 처리 
			if(friends[list[i][0]]==2) {
				friends[list[i][1]] = 3;
				continue;
			}else if(friends[list[i][1]]==2) {
				friends[list[i][0]] = 3;
				continue;
			}
		}
		
		int answer = 0;
		for (int i = 2; i < friends.length; i++) {
			if(friends[i]>1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
