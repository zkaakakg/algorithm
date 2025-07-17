class Solution {
    public int[] solution(long n) {
       String[] nums = String.valueOf(n).split("");
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = Integer.parseInt(nums[nums.length - 1 - i]);
        }
        return answer;
    }
}