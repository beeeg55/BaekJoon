package error;
//�̿ϼ�
import java.util.Scanner;
import java.util.Stack;

public class stack_2493 {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt(); // Ÿ�� ��
		int result[] = new int[num]; // ��Ÿ���� ��� ���� �迭
		int t=0;
		//Ÿ������ ���ÿ� �ֱ�
		for(int i=0;i<num;i++){
			t = in.nextInt();
			stack.push(t);
		}
		
		for(int i=num-1;i>=0;i--){
			t =stack.peek();
			int pop=i+1;
			while(stack.empty()==false){
				int s = stack.peek();
				if(s>t){
					result[i]= pop;
					break;
				}
				else{
					stack.pop();
					pop--;
				}
			}
			if(stack.empty()==true){
				result[i] = 0;
			}
			stack.pop();
		}
		for(int i=0;i<num;i++){
			System.out.println(result[i]);
		}
	}
}
