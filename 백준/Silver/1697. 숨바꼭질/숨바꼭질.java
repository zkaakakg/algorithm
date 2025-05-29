import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(int n, int k) {
        if (n == k) {
            return 0;
        }

        int max = 1000000;
        boolean[] visited = new boolean[max + 1];
        int[] time = new int[max + 1];


        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = true;
        time[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current - 1 >= 0 && !visited[current - 1]) {
                visited[current - 1] = true;
                time[current - 1] = time[current] + 1;
                queue.add(current - 1);
            }
            if (current + 1 <= max && !visited[current + 1]) {
                visited[current + 1] = true;
                time[current + 1] = time[current] + 1;
                queue.add(current + 1);
            }
            if (current * 2 <= max && !visited[current * 2]) {
                visited[current * 2] = true;
                time[current * 2] = time[current] + 1;
                queue.add(current * 2);
            } else if (visited[k]) {
                return time[k] - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        System.out.print(bfs(n, k));

    }

}