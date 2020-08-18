package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class implement_14891 {
	static LinkedList[] wheel = new LinkedList[5];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		for (int i = 1; i < wheel.length; i++) {
			wheel[i] = new LinkedList<Character>();
			temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i].add(temp.charAt(j));
			}
		}
		
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine()); // 회전횟수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			char curL = (char) wheel[num].get(6); // 현재 오른쪽 
			char curR = (char) wheel[num].get(2); // 현재 왼쪽 
			char left_state, right_state;
			
			turn(d,num); // 현재바퀴 회전 
			
			// 왼쪽 탐색 
			int tempD = d;
			for (int j = num; j > 1; j--) {
				left_state = (char) wheel[j-1].get(2); // 왼쪽 바퀴의 오른쪽  
				// 방향이 다르면 반대방향으로 회전 
				if(curL == left_state) {
					break;
				} else {
					curL = (char) wheel[j-1].get(6); // 회전 전 상태 저장  
					tempD *= -1;
					turn(tempD, j-1); 
				}
			}
			
			// 오른쪽 탐색 
			tempD =d;
			for (int j = num; j < 4; j++) {
				right_state = (char) wheel[j+1].get(6); // 오른쪽 바퀴의 왼쪽 
				// 방향이 다르면 반대방향으로 회전 
				if(curR == right_state) {
					break;
				} else {
					curR = (char) wheel[j+1].get(2); // 회전 전 상태 저장 
					tempD *= -1;
					turn(tempD, j+1);
				}
			}
		}
		int answer = 0;
		for (int i = 1; i < wheel.length; i++) {
			char c = (char) wheel[i].get(0);
			if(c=='1') {
				answer += Math.pow(2, i-1);
			}
		}
		System.out.println(answer);
	}
	
	// d: 방향 j: 위치 
	public static void turn(int d, int j) {
		if(d==1) {
			wheel[j].addFirst(wheel[j].pollLast());
		}else {
			wheel[j].addLast(wheel[j].pollFirst());
		}
	}
	

}
