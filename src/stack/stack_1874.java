package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> input = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}
		boolean[] visit = new boolean[N+1];
		boolean possible = true;
		StringBuilder sb = new StringBuilder();
		int turn = 0;
		st.push(1);
		sb.append("+\n");
		int cur = 1;
		int find = 0;
			while(turn<N && possible) {
				find = input.poll();
				if(find<cur) {
					if(!st.isEmpty()&&st.peek()==find) {
						visit[find] = true;
						st.pop();
						sb.append("-\n");
					}else {
						possible = false;
					}
				}else if(find>cur) {
					for (int i = cur+1; i <= find; i++) {
						if(visit[i] == true) continue;
						st.push(i);
						sb.append("+\n");
						cur++;
					}
					visit[find] = true;
					st.pop();
					sb.append("-\n");
				}else {
					visit[find] = true;
					st.pop();
					sb.append("-\n");
				}
				turn++;
			}
			if(possible) {
				System.out.println(sb.toString());
			}else {
				System.out.println("NO");
			}
		
	}

}
