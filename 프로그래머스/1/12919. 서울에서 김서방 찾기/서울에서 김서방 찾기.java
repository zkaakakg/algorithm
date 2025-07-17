import java.io.*;

class Solution {
    public String solution(String[] seoul) {
       String answer = "";
        for (int i = 0; i < seoul.length; i++){
            String name = seoul[i];
            if (name.equals("Kim")){
               answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }
}