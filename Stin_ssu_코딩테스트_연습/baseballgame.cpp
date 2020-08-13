#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

bool check[9];
vector<int> tmp;
vector<vector<int> >permut_num;
int vec_cnt = 0;

int one2ten[9] = {1,2,3,4,5,6,7,8,9};

void permutation(int index, int cnt){
    if(index == 3){
        for(int i=0; i<3; i++){
            permut_num[vec_cnt].push_back(tmp[i]);
        }
        vec_cnt++;
        return;
    }
    else{
        for(int i=0; i<9;i++){
            if(check[i] != 1){
                check[i] = 1;
                tmp.push_back(one2ten[i]);
                permutation(index+1,cnt+1);
                tmp.pop_back();
                check[i] = 0; 
            }
        }
    }
}

vector<vector<int> > split_number(vector<vector<int>> baseball){
    vector<vector<int> > numbers;
    
    for(int i=0; i<baseball.size(); i++){
        vector<int> temp;
        numbers.push_back(temp);
    }
    
    for(int i=0; i<baseball.size(); i++){
        while(baseball[i][0] != 0){
            int num = baseball[i][0] % 10;
            numbers[i].push_back(num);
            baseball[i][0] /= 10;
        }
    }
    for(int i=0; i<numbers.size(); i++){
        reverse(numbers[i].begin(), numbers[i].end());
    }
    
    return numbers;
}

int strike(vector<int> num, vector<int> input){
    int cnt = 0;
    for(int i=0; i<3; i++){
        if(num[i] == input[i])
            cnt++;
    }
    return cnt;
}

int ball(vector<int> num, vector<int> input){
    int cnt = 0;
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(num[i] == input[j] && i!=j)
                cnt++;
        }
    }
    
    return cnt;
}

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    vector<vector<int> > numbers;
    numbers = split_number(baseball);
    
    for(int i=0; i<504; i++){
        vector<int> tmp;
        permut_num.push_back(tmp);
    }
    
    permutation(0,0);
    vector<int > result;
    vector<vector<int>> per_temp = permut_num;
    
    for(int i=0; i<numbers.size(); i++){
        int real_s = baseball[i][1];
        int real_b = baseball[i][2];
        vector<vector<int>> storage;
        
        for(int j=0; j<per_temp.size(); j++){
            int s_cnt = strike(numbers[i], per_temp[j]);
            int b_cnt = ball(numbers[i], per_temp[j]);
            
            if(s_cnt == real_s && b_cnt == real_b){
                storage.push_back(per_temp[j]);
            }
        }
        per_temp = storage;
    }
    
    
    answer = per_temp.size();
    
    return answer;
}