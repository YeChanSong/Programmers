#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

bool check(string p){
    int t = 0;
    for (int i = 0; i < p.length(); i++) {
        if (p[i] == '(')       t++;
        else {
            if (t==0)     return false;
            t--;
        }
    }
    return true;
}

string recurrsion(string p){
    if(p == "") return p;
    int leftcount = 0;
    int rightcount = 0;
    string u = "", v = "";
    for(int i=0; i<p.size(); i++){
        if(p[i] == '(') leftcount++;
        else    rightcount++;    
        
        if(leftcount == rightcount){
            u = p.substr(0,i+1);
            v = p.substr(i+1);
            break;
        }
    }
    
    if(check(u)) return u+recurrsion(v);
    
    else{
        string tmp = "(";
        tmp += recurrsion(v);
        tmp += ")";

        for(int i=1; i<u.size()-1; i++){
            if(u[i] == '(')
                tmp+=")";
            else
                tmp+="(";
        }
        return tmp;
    }
    
}

string solution(string p) {
    string answer = "";
    if(check(p))
        return p;
    else{
        answer = recurrsion(p);
        return answer;
    }
}