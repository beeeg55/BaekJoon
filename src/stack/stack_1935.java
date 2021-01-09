package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Double> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='+') {
				double a = st.pop();
				double b = st.pop();
				st.push(a+b);
			}else if(s.charAt(i)=='-') {
				double a = st.pop();
				double b = st.pop();
				st.push(b-a);
			}else if(s.charAt(i)=='*') {
				double a = st.pop();
				double b = st.pop();
				st.push(a*b);
			}else if(s.charAt(i)=='/') {
				double a = st.pop();
				double b = st.pop();
				st.push(b/a);
			}else {
				int index = s.charAt(i)-'A';
				st.push(arr[index]);
			}
		}
		System.out.printf("%.2f", st.pop());


	}

}
