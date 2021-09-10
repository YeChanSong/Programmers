import java.util.*;


class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); // step1
        char tmp; StringBuilder sb = new StringBuilder();
        for(int i=0;i<new_id.length();i++){ // step2
            tmp = new_id.charAt(i);
            if(('a'<= tmp && tmp <='z') || ('0'<=tmp && tmp<='9') || tmp=='-' || tmp=='_' || tmp=='.'){
                sb.append(tmp);
            }
        }
        new_id = sb.toString();
        boolean flag = false;
        sb = new StringBuilder();
        for(int i=0;i<new_id.length();i++){ // step 3
            tmp = new_id.charAt(i);
            if(tmp == '.'){
                if(flag) continue;
                flag = true;
            }else{
                flag = false;
            }
            sb.append(tmp);
        }
        // step 4
        if(new_id.charAt(0)=='.')
            sb.deleteCharAt(0);
        if(sb.length()>0 && new_id.charAt(new_id.length()-1)=='.')
            sb.deleteCharAt(sb.length()-1);
        // step 5
        if(sb.length()==0)
            sb.append('a');
        // step 6
        if(sb.length()>=16)
            sb.delete(15,sb.length());
        if(sb.charAt(sb.length()-1)=='.')
            sb.deleteCharAt(sb.length()-1);
        // step 7
        if(sb.length()<=2){
            while(sb.length()<=2)
                sb.append(sb.charAt(sb.length()-1));
        }
        answer = sb.toString();
        return answer;
    }
}