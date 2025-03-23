import java.io.*;

public class Main {
	static int n , k;
	static String[] words;
	static boolean[] visited = new boolean[26];
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		words = new String[n];
		for(int i = 0; i < n; i++) {
			words[i] = br.readLine().replaceAll("anta|tica", "");
		}
		
		if(k < 5) {
			System.out.println(0);
			return;
		}else if(k == 26) {
			System.out.println(n);
			return;
		}
		
		visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;
        
        back(0,5);
        System.out.println(max);

	}
	
	static void back(int alpha, int cnt) {
		if(cnt == k) {
			int temp = 0;
			for(int i = 0; i < n; i++) {
				boolean canRead = true;
				for(char c : words[i].toCharArray()) {
					if(!visited[c-'a']){
						canRead = false;
						break;
					}
				}
				if(canRead) temp++;
			}
			
			max = Math.max(max,temp);
			return;
		}
		
		for(int i = alpha; i < 26; i++) {
            if (!visited[i]) {  // 아직 배우지 않은 글자라면
                visited[i] = true; // 선택
                back(i + 1, cnt + 1); // 다음 글자 선택
                visited[i] = false; // 선택 해제 (백트래킹)
            }
        }
	}
}