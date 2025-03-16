import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken()); // 동현이의 점수
        int b = Integer.parseInt(st.nextToken()); // 주원이의 점수
        int n = Integer.parseInt(br.readLine());  // 과녁의 개수
        
        if (b > a) { // 이미 이기고 있는 경우
            System.out.println("-1 -1");
            return;
        }
        
        int needed = a - b + 1; // 필요한 최소 점수
        int[][] targets = new int[n + 1][2];
        
        // 과녁 정보 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            targets[i][0] = Integer.parseInt(st.nextToken()); // 왼손 점수
            targets[i][1] = Integer.parseInt(st.nextToken()); // 오른손 점수
        }
        
        // 각 과녁의 오른손 점수만 저장한 배열 (이분 탐색용)
        int[][] rightScores = new int[n][2]; // [점수, 인덱스]
        for (int i = 0; i < n; i++) {
            rightScores[i][0] = targets[i+1][1];
            rightScores[i][1] = i+1;
        }
        
        // 오른손 점수 기준으로 정렬 (이분 탐색을 위해)
        Arrays.sort(rightScores, Comparator.comparingInt(a1 -> a1[0]));
        
        int minScore = Integer.MAX_VALUE;
        int bestX = -1, bestY = -1;
        
        // 경우 1: 왼손만 사용
        for (int i = 1; i <= n; i++) {
            int score = targets[i][0];
            if (score >= needed && score < minScore) {
                minScore = score;
                bestX = i;
                bestY = -1;
            }
        }
        
        // 경우 2: 오른손만 사용
        for (int i = 1; i <= n; i++) {
            int score = targets[i][1];
            if (score >= needed && score < minScore) {
                minScore = score;
                bestX = -1;
                bestY = i;
            }
        }
        
        // 경우 3: 양손 모두 사용 (서로 다른 과녁)
        for (int left = 1; left <= n; left++) {
            int leftScore = targets[left][0];
            
            // 남은 필요 점수
            int remainingNeeded = needed - leftScore;
            
            // 남은 점수가 0 이하면 이미 충분한 점수를 얻었음
            if (remainingNeeded <= 0) continue;
            
            // 이분 탐색으로 필요한 최소 오른손 점수 찾기
            int idx = lowerBound(rightScores, remainingNeeded);
            
            // 적합한 점수를 찾지 못했거나, 배열 범위를 벗어난 경우
            if (idx >= n) continue;
            
            // 필요 점수를 만족하는 오른손 점수와 해당 과녁 번호
            int rightScore = rightScores[idx][0];
            int right = rightScores[idx][1];
            
            // 같은 과녁을 노리는 경우, 다음 과녁 확인
            if (left == right) {
                // 다음 과녁 찾기
                idx++;
                if (idx >= n) continue;
                
                rightScore = rightScores[idx][0];
                right = rightScores[idx][1];
                
                // 여전히 같은 과녁이면 패스 (불가능한 경우)
                if (left == right) continue;
            }
            
            // 총점 계산
            int totalScore = leftScore + rightScore;
            
            // 최소 필요 점수를 만족하면서 최소 점수 업데이트
            if (totalScore < minScore) {
                minScore = totalScore;
                bestX = left;
                bestY = right;
            }
        }
        
        // 결과 출력
        if (minScore == Integer.MAX_VALUE) {
            System.out.println("No");
        } else {
            System.out.println(bestX + " " + bestY);
        }
    }
    
    // 이분 탐색: target 이상의 값이 처음 나타나는 인덱스 반환
    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (arr[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}