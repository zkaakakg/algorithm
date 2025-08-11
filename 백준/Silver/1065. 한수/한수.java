import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 100) {
            System.out.println(n);
        } else {
            int cnt = 99;
            for (int i = 100; i <= n; i++) {
                int num1 = i / 100;
                int num2 = (i / 10) % 10;
                int num3 = i % 10;
                
                if ((num1 - num2) == (num2 - num3)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    
}