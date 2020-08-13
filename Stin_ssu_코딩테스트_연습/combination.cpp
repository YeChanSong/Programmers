#include <string>
#include <vector>
#include <utility>
#include <iostream>
#include <map>

using namespace std;

int *check;
int comb;
vector<int> cbook;
int total = 0;

void combination(int idx, int cnt, int size){
    if(cnt == size){
        int semi = 1;
        for(int i=0; i<comb; i++){
            if(check[i] == 1){
                semi*=cbook[i];
            }
        }
        total += semi;
        return;
    }
    
    for(int i=idx; i<comb; i++){
        if(check[i] != 1){
            check[i] = 1;
            combination(i, cnt+1, size);
            check[i] = 0;
        }
    }
}

int main(){
    
    /*
        조합 문제
        재귀로 조합
        combination(0,0, 돌리고 싶은 만큼); 으로 풀면 됌.
    */
    
}