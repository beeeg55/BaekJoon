package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_1107 {

	static boolean[] broken = new boolean[10];
	static String channel;
	int[] number= {0,1,2,3,4,5,6,7,8,9};
	static int answer = 0;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		channel = br.readLine();
		min = Math.abs(Integer.parseInt(channel)-100);
		int n = Integer.parseInt(br.readLine());
		if(n==10) {
			System.out.println(Integer.parseInt(channel)-100);
			return;
		}else {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < n; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
			control(channel.length(),0);
			System.out.println(min);
		}
	}
	private static void control(int cnt, int d) {
		if(cnt==0) {
			int dif = Math.abs(answer-Integer.parseInt(channel));
			if(dif < min) {
				min = dif;
			}
			return;
		}
		int curNum = channel.charAt(channel.length()-cnt)-'0'+d;
		if(broken[curNum]) {
			while(!broken[curNum--]) {
				
			}
			System.out.println(curNum);
			control(cnt, d-1);
			while(!broken[curNum++])
			control(cnt, d+1);
		}else {
			answer += Math.pow(10, cnt-1)*curNum;
			//System.out.println(answer);
			control(cnt-1,0);
		}
		
	}
}
