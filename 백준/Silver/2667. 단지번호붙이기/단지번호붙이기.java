import java.util.*;

public class Main {
	static int n;
	static int[][] a;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		ArrayList<Integer> aptCnt = new ArrayList<>();
		
		for(int i =0; i <n;i++) {
			String row = sc.next();
			for(int j = 0; j < n; j++) {
				a[i][j] = row.charAt(j)-'0';
			}
		}
		
		int total = 0;
		for(int i =0; i <n;i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1) {
					int count = dfs(i,j);
					aptCnt.add(count);
					total++;
				}
			}
		}
		
		System.out.println(total);
		Collections.sort(aptCnt);
		for(int count : aptCnt) {
			System.out.println(count);
		}
	}	
	
	public static int dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n || a[x][y] == 0) {
			return 0;
		}
		a[x][y] = 0;
		int count = 1;
		for(int i = 0; i < 4 ; i++) {
			count += dfs(x+dx[i], y+dy[i]);
		}
		return count;
	}
}