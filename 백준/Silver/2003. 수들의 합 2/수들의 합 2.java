import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] arr = new int[n];
		
		input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = arr[i];
			if(sum == m) {
				cnt++;
			}
			for(int j = i+1; j < n; j++) {
				sum += arr[j];
				if(sum == m) {
					cnt++;
					break;
				}else if(sum > m) {
					break;
				}
			}
			
		}
		System.out.println(cnt);

	}

}
