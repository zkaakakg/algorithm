import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if (n == 100) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[m];
        if ( m != 0){
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);

            boolean isCheck = false;
            for (int j = 0; j < num.length(); j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[k] == num.charAt(j) - '0') {
                        isCheck = true;
                        break;
                    }
                }
                if (isCheck) break;
            }

            if (!isCheck) {
                int min = Math.abs(n - i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
