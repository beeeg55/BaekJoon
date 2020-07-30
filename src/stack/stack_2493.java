package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		Stack<int[]> tops = new Stack<>();
		sb.append(0+" ");
		tops.push(new int[] {0,Integer.parseInt(st.nextToken())});
		for (int i = 1; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(tops.peek()[1]>=cur) {
				sb.append(tops.peek()[0]+1+" ");
				tops.push(new int[] {i,cur});
			}else {
				while(tops.size()>0&&tops.peek()[1]<cur) {
					tops.pop();
				}
				if(tops.size()==0) {
					sb.append(0 +" ");
				}else {
					sb.append(tops.peek()[0]+1+" ");
				}
				tops.push(new int[] {i,cur});
			}
		}
		System.out.println(sb.toString());
	}

}
