#include <string>
#include <vector>
#include <iostream>

using namespace std;
/*
string solution(string number, int k) {
    string answer = "";
    int start = 0;
    vector<int> num;
    
    for(int i=0; i< number.size()-k; i++){
        if(number[i]>number[start])
            start = i;
    }
    
    int ans_size = number.size() - k;
    int ping = start;
    int cnt = 0;
    int trash_num = k - start;
    cout<<"trash_num: "<<trash_num<<endl;
    
    for(int i = 0; i< trash_num; i++){
        int min = number[ping];
        int min_idx = 0;
        cout<<"ping: "<<ping<<endl;
        for(int j=ping; j<ping+ans_size; j++){
            if(min > number[j]){
                min = number[j];
                min_idx = j;
            }
        }
        cout<<"min_idx: "<<min_idx<<endl;
        ans_size -= min_idx - ping;
        //number.replace(min_idx,1," ");
        num.push_back(min_idx);
        ping = min_idx+1; 
    }
    
    for(int i=num.size()-1; i>= 0; i--){
        number.erase(num[i], 1);
    }


    for(int i=start; i< number.size(); i++){
        answer+=number[i];
    }

    cout<<answer<<endl;
    return answer;
}
*/

string solution(string number, int k) {
    string answer = "";
    int start = 0;
    vector<int> num;
    
    for(int i=0; i< number.size()-k; i++){
        if(number[i]>number[start])
            start = i;
    }
    
    int ans_size = number.size() - k;
    int ping = start;
    
    while(1){
        if(number.size() - ping == ans_size)
            break;
        int max = number[ping];
        int max_idx = ping;
        
        for(int i=ping; i<ping+ans_size; i++){
            if(max < number[i]){
                max = number[i];
                max_idx = i;
            }
        }
        
        ping = max_idx + 1;
        answer+=number[max_idx];
        ans_size--;
    }   
    
    cout<<answer<<endl;
    return answer;
}

int main(){
    //string number="4177252841";
    string number = "1231234";
    int k = 3;

    solution(number,k);
}


