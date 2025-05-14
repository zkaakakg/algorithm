import java.io.*;

public class Main {
    static int n;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && !arr[i][j].equals(arr[i][j + 1])) {
                    exchangeCandy(i, j, i, j + 1);
                    result = Math.max(result, maxCandy());
                    exchangeCandy(i, j + 1, i, j);
                }
                if (i + 1 < n && !arr[i][j].equals(arr[i + 1][j])) {
                    exchangeCandy(i, j, i + 1, j);
                    result = Math.max(result, maxCandy());
                    exchangeCandy(i + 1, j, i, j);
                }
            }
        }
        System.out.println(result);

    }

    static public void exchangeCandy(int x1, int y1, int x2, int y2) {
        String temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static public int maxCandy() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cntRow = 1;
            int cntCol = 1;

            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j].equals(arr[i][j + 1])) {
                    cntRow++;
                } else {
                    max = Math.max(max, cntRow);
                    cntRow = 1;
                }
                if (arr[j][i].equals(arr[j + 1][i])) {
                    cntCol++;
                } else {
                    max = Math.max(max, cntCol);
                    cntCol = 1;
                }
            }
            max = Math.max(max, cntRow);
            max = Math.max(max, cntCol);
        }
        return max;
    }
}
