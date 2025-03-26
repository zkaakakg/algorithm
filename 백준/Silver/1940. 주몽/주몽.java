import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] input = br.readLine().split(" ");
    for(int i  = 0; i < n; i++){
      arr[i] = Integer.parseInt(input[i]);
    }

    int cnt = 0;
    for(int i = 0 ; i < n; i++){
      for(int j = i + 1;  j < n; j++){
        int sum = arr[i] + arr[j] ;
        if(sum == m){
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
