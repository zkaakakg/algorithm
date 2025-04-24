import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int w, h;
    static int[][] arr;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
