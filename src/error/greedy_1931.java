package error;
//�ٽ��غ���
import java.util.Arrays;
import java.util.Scanner;

public class greedy_1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();//ȸ�ǽ� ��
		int count =0; // false ����
		int result =0; // ����� �� �ִ� ȸ�ǽ� ��
		int[][] time= new int[N][]; 
		for(int i=0;i<N;i++){
			time[i][0] = in.nextInt(); //���۽ð�
			time[i][1] = in.nextInt(); //�����½ð�
		}
		boolean[] fill = new boolean[24];
		for(int i=0;i<24;i++){
			fill[i] = false;
		}
		
		//ȸ�ǽð����Ĺ迭
		int[] ord = new int[N];
		for(int i=0;i<N;i++){
			ord[i]=time[i][1]-time[i][0];
		}
		Arrays.sort(ord);
		for(int i=0;i<ord.length;i++){
			System.out.println(ord[i]);
		}
		for(int i=0;i<ord.length;i++){
			int start=time[i][0];
			while(start<time[i][1]){
				if(fill[start]==false){
					count++;
				}
				start++;
			}
			if(count == ord[i]){
				while(start<time[i][1]){
					fill[start] = true;
					start++;
				}
				result++;
			}
		}
		System.out.println(result);
	}

}