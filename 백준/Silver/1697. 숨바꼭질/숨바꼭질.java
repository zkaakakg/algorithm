import java.util.*;

public class Main {
	public static int bfs(int n, int k) {
		if(n==k) {
			return 0;
		}
		
		int max = 1000000;
		boolean[] visited = new boolean[max+1];
		int[] time = new int[max+1];
	
		
		Queue<Integer> queue  = new LinkedList<>();
		
		queue.add(n);
		visited[n] = true;
		time[n] = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current - 1 >= 0 && !visited[current-1]) {
				visited[current-1] = true;
				time[current-1] = time[current] + 1;
				queue.add(current -1);
			}
			if(current + 1 <= max && !visited[current+1]) {
				visited[current + 1] = true;
				time[current + 1] = time[current] + 1;
				queue.add(current + 1);
			}
			if(current * 2 <= max && !visited[current *2]) {
				visited[current*2] = true;
				time[current*2] = time[current] + 1;
				queue.add(current*2);
			}
			else if(visited[k]) {
				return time[k]-1;
			}
		}
		return -1;
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		System.out.print(bfs(n,k));
		
	}
	
}