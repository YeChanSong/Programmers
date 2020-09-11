#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;

vector<string> split(string s){
    vector<string> space;
    string tmp = "";
    for(int i=0; i<s.size(); i++){
        if(s[i] == ' '){
            space.push_back(tmp);
            tmp="";
        }
        else if(i==s.size()-1){
            tmp+=s[i];
            space.push_back(tmp);
        }
        else{
            tmp+=s[i];
        }
    }
    return space;
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    unordered_map<string, string> name;
    string enter = "Enter";
    string leave = "Leave";
    string change = "Change";
    
    for(int i=0; i<record.size(); i++){
        vector<string> tmp = split(record[i]);
        if(tmp[0] == enter){
            name[tmp[1]] = tmp[2];
        }
        else if(tmp[0] == change){
            name[tmp[1]] = tmp[2];
        }
    }
    
    for(int i=0; i<record.size(); i++){
        vector<string> tmp = split(record[i]);
        string ans = "";
        //cout<<tmp[0]<<endl;
        if(tmp[0]==enter){
            ans += name[tmp[1]];
            //cout<<ans<<endl;
            ans += "님이 들어왔습니다.";
            answer.push_back(ans);
        }
        else if(tmp[0] == leave){
            ans += name[tmp[1]];
            ans += "님이 나갔습니다.";
            answer.push_back(ans);
        }
        
    }
    
    // for(int i=0; i<answer.size(); i++){
    //     cout<<answer[i]<<endl;
    // }
    
    return answer;
}