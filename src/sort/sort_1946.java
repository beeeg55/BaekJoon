package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class sort_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = 0; // 지원자 수 
		int[][] arr; 
		int count; // 신입사원 수  
		int max; // 두번째 점수의 최저 등수 
		for(int i=0;i<n;i++){
			t = Integer.parseInt(br.readLine());
			arr= new int[t][2];
			for(int j=0;j<t;j++){
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s," ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			// 서류순위 기준 정렬 
			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			count = 1;
			max = arr[0][1]; // 1위면 무조건 붙음으로 초기화 시 1위의 면접점수 등수를 넣는다. 
			for(int j=1;j<t;j++){
				if(arr[j][1]<max){ // 현재까지 면접 최고 등수보다 높으면 카운트 후 값 갱신 
					max = arr[j][1]; 
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
		
	}

}