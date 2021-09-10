import java.util.*;

class Solution {
    static HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>>> infos     = new HashMap<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>> h1;
        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> h2;
        HashMap<Integer, ArrayList<Integer>> h3;
        HashMap<String, Integer> findKey = new HashMap<>();
        for(int i=0;i<3;i++){ // 언어
            infos.put(i,new HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>>());
            h1 = infos.get(i);
            for(int j=0;j<2;j++){ // 직군
                h1.put(j,new HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>());
                h2 = h1.get(j);
                for(int k=0;k<2;k++){ // 경력
                    h2.put(k, new HashMap<Integer, ArrayList<Integer>>());
                    h3 = h2.get(k);
                    for(int l=0;l<2;l++){ // 소울푸드
                        h3.put(l, new ArrayList<Integer>());
                    }
                }
            }
        }
        ArrayList<int[]> preInfo = new ArrayList<>();
        String[] temp;
        for(String data: info){
            temp=data.split(" ");
            preInfo.add(new int[]{mapper(0,temp[0].charAt(0)),mapper(1,temp[1].charAt(0)),mapper(2,temp[2].charAt(0)),mapper(3,temp[3].charAt(0)),Integer.parseInt(temp[4])});
        }
        
        preInfo.sort((a,b)->Integer.compare(a[4], b[4]));
        for(int[] tmp: preInfo){
            infos.get(tmp[0]).get(tmp[1]).get(tmp[2]).get(tmp[3]).add(tmp[4]);
        }
        String[] q, qtmp; String q3; int q4; int idx=0;
        for(String query: queries){
            q = query.split(" and ");
            qtmp = q[3].split(" ");
            q3 = qtmp[0]; q4 = Integer.parseInt(qtmp[1]);
            answer[idx]=
                findByQuery(mapper(0,q[0].charAt(0)),mapper(1,q[1].charAt(0)),mapper(2,q[2].charAt(0)),mapper(3,q3.charAt(0)),q4);
            idx++;
        }
        return answer;
    }
    public int mapper(int idx, char c){
        if(c=='-')
            return -1;
        if(idx==0){
            if(c=='c'){
                return 0;
            }else if(c=='j'){
                return 1;
            }else{
                return 2;
            }
        }else if(idx==1){
            if(c=='b'){
                return 0;
            }else{
                return 1;
            }
        }else if(idx==2){
            if(c=='j'){
                return 0;
            }else{
                return 1;
            }
        }else if(idx==3){
            if(c=='c'){
                return 0;
            }else{
                return 1;
            }
        }
        return -1;
    }
    public int findByQuery(int lang, int pos, int carr, int food, int min){
        int ret =0;
        if(lang == -1){
            for(int i=0;i<3;i++)
                ret += findByQuery(i,pos,carr,food,min);
            return ret;
        }else{
            if(pos == -1){
                for(int i=0;i<2;i++)
                    ret += findByQuery(lang,i,carr,food,min);
                return ret;
            }else{
                if(carr == -1){
                    for(int i=0;i<2;i++)
                        ret+= findByQuery(lang,pos,i,food,min);
                    return ret;
                }else{
                    if(food == -1){
                        for(int i=0;i<2;i++)
                            ret += findByQuery(lang,pos,carr,i,min);
                        return ret;
                    }
                }   
            }
        }
        ArrayList<Integer> arr = infos.get(lang).get(pos).get(carr).get(food);
        int idx=binarySearch(arr,min);
        return idx;
    }
    public int binarySearch(ArrayList<Integer> list, int score) {
        if (list == null || list.size() == 0){ 
            return 0; 
        } 
        if (list.size() == 1) {
            if (score <= list.get(0)) {
                return 1; 
            } return 0; 
        } 
        int left = 0; int right = list.size(); 
        while (left < right) {
            int middle = (left + right) / 2; 
            if (list.get(middle) < score) {
                left = middle + 1; 
            } else {
                right = middle; 
            } 
        } 
        return list.size() - left; 
    }
}