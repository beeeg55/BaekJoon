package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_17952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Task> stack = new Stack<>();
		int total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			if(num==0) {
				if(stack.size()==0) continue;
				Task t = stack.pop();
				if(t.time==1) {
					total += t.score;
				}else {
					t.time--;
					stack.push(t);
				}
			}else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if(time==1) {
					total += score;
				}else {
					stack.push(new Task(score,time-1));
				}
			}
		}
		System.out.println(total);
	}
	static class Task{
		int score;
		int time;
		Task(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

}
