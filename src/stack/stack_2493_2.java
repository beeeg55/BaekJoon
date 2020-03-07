package stack;
//메모리초과
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_2493_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int to[] = new int[num];
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		for(int i = 0;i<num;i++){
			to[i]=Integer.parseInt(st.nextToken());
		}
		bw.write(0+" ");
		for(int i=0;i<num;i++){
			Stack<Integer> stack = new Stack<Integer>();
			for(int j=0;j<=i;j++){
				stack.push(to[j]);
			}
			
			int c = stack.pop();
			while(!stack.empty()){
				if(stack.peek()>c){
					bw.write(stack.size()+" ");
					break;
				}
				else{
					stack.pop();
				}
				if(stack.empty()){
					bw.write(0+" ");
				}
			}
		}
		bw.flush();
	}

}
