package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class implement_1952 {

	private static boolean[] visit;
	private static int min = Integer.MAX_VALUE;
	private static int day;
	private static int oneM;
	private static int threeM;
	private static int year;
	private static int[] use;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			 min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			day = Integer.parseInt(st.nextToken());
			oneM = Integer.parseInt(st.nextToken());
			threeM = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			visit = new boolean[12];
			st = new StringTokenizer(br.readLine()," ");
			use = new int[12];
			for (int j = 0; j < 12; j++) {
				use[j] = Integer.parseInt(st.nextToken());
				if(use[j]==0) {
					visit[j] = true;
				}
			}
			search(0,visit,0);
			System.out.println("#"+i+" "+Math.min(year, min));
		}
		
	}

	private static void search(int mon, boolean[] visit, int sum) {
		if(mon>=12) {
			if(sum<min) {
				min = sum;
			}
			return;
		}
		if(visit[mon]) {
			search(mon+1,visit,sum);
			return;
		}
		boolean[] copyVisit = Arrays.copyOf(visit, visit.length);
		copyVisit[mon] = true;
		search(mon+1,copyVisit, sum + use[mon]*day);
		search(mon+1,copyVisit, sum + oneM);
		search(mon+3,copyVisit, sum + threeM);
	}

}
