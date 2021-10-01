import java.util.*;

class Solution {
    static int[][][] keys;
    static int[][] lck;
    static int klen, llen, lcntr=0;
    static boolean answer = false;
    public boolean solution(int[][] key, int[][] lock) {
        klen = key.length;
        lck = lock; llen = lock.length;
        keys = new int[4][klen][klen];
        for(int y=0;y<lock.length;y++){
            for(int x=0;x<lock.length;x++){
                if(lck[y][x]==0)
                    lcntr++;
            }
        }
        rotateAll(key);
        for(int k=0;k<4;k++)
        for(int y=-klen+1;y<lock.length;y++){
            for(int x=-klen+1;x<lock.length;x++){
                if(LockBaseMatcher(k,y,x))
                    return true;
            }
        }
        return false;
    }
    void rotateAll(int[][] key){
        keys[0] = key;
        for(int i=1;i<4;i++){
            for(int j=0;j<klen;j++){
                for(int k=0;k<klen;k++){
                    keys[i][k][klen-j-1] = keys[i-1][j][k];
                }
            }
        }
    }
    boolean LockBaseMatcher(int k, int ly, int lx){
        int dy,dx,cnt=0;
        for(int i=0;i<klen;i++){
            dy = ly+i;
            if(dy<0 || dy>=llen){
                continue;
            }
            for(int j=0;j<klen;j++){
                dx = lx+j;
                if(dx<0 || dx>=llen){
                    continue;
                }
                if(keys[k][i][j] == lck[dy][dx])
                    return false;
                if(lck[dy][dx] == 0)
                    cnt++;
            }
        }
        if(cnt == lcntr)
            return true;
        return false;
    }
}