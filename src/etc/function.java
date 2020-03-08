package etc;

public class function {
    public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		long result = sum(arr);
		System.out.println(result);
		
	}
    static long sum(int[] a) {
        long ans = 0;
        for(int i:a){
			ans += i;
		}
        return ans;
    }
}
