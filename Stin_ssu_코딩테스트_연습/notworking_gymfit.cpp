#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    int *check = new int[n];
    int *lost_check = new int[n];
    for(int i=0; i<n; i++){
        check[i] = 0;
        lost_check[i] = 0;
    }
    
    int cnt = 0;
    for(int i=0; i< lost.size(); i++){
        for(int j=0; j<reserve.size(); j++){
            if(lost[i]==reserve[j]){
                check[j] =1;
                lost_check[i] = 1;
                cnt++;
                break;
            }
        }
    }

    for(int i=0; i< lost.size(); i++){
        if(lost_check[i] != 1){
            for(int j=0; j<reserve.size(); j++){
                if(check[j] != 1){
                    if(lost[i] - 1 == reserve[j]){
                        check[j] = 1;
                        lost_check[i]=1;
                        cnt ++;
                        break;
                    }
                    else if(lost[i] + 1 == reserve[j]){
                        check[j] = 1;
                        lost_check[i] = 1;
                        cnt++;
                        break;
                    }
                }
            }
        }
    }
    
    answer += cnt;
    return answer;
}


int main(){
    n = 4;
    vector<int> lost;
    vector<int> reserve;

    lost.push_back(2);
    lost.push_back(3);
    reserve.push_back(3);
    reserve.push_back(4);
}