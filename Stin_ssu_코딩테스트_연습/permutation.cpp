#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

vector<int> result;
vector<int> temp;
vector<int> s;
bool *check;

int zari(){
    int total = 0;
    for(int i=0; i<temp.size(); i++){
        total += temp[i]*pow(10,i);
    }
    
    return total;
}

////////////////////////////////////////////////
// 조합 제귀 형식                                //
////////////////////////////////////////////////
void combination(int index, int max, int size){
    if(index == max){
        result.push_back(zari());
        return;
    }
    else{
        for(int i=0; i<size; i++){
            if(check[i] != true){
                check[i] = true;
                temp.push_back(s[i]);
                combination(index+1, max, size);
                temp.pop_back();
                check[i] = false;
            }
        }
    }
}

////////////////////////////////////////////////
//프로그래머스 완전탐색 2번 문제                     //
//소수 찾기                                     //
////////////////////////////////////////////////
int solution(string numbers) {
    int answer = 0;
    check = new bool[numbers.size()];
    
    for(int i=0; i<numbers.size(); i++){
        s.push_back(numbers[i]-48);
    }
    
    for(int i=1; i<=s.size(); i++){
        combination(0,i,numbers.size());
    }
    
    vector<int> real_re;
    
    for(int i=0; i<result.size(); i++){
        vector<int>::iterator it; 
        it = find(real_re.begin(), real_re.end(), result[i]);
        
        if(it == real_re.end()){
            real_re.push_back(result[i]);
        }
    }
    
    answer = real_re.size();
    for(int i=0; i<real_re.size(); i++){
        if(real_re[i] == 1 || real_re[i] ==0)
            answer -= 1;
        else{
            cout<<real_re[i]<<endl;
            for(int j=2; j<real_re[i]; j++){
                if(real_re[i] % j==0){
                    answer -= 1;
                    break;
                }

            }
        }
    }
    cout<<answer<<endl;
    return answer;
}