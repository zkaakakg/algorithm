import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 1000000;
        long[] f = new long[MAX + 1];
        long[] g = new long[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                f[j] += i;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            g[i] = g[i - 1] + f[i];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(g[n]);
        }
    }
}