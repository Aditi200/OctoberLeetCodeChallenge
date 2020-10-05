class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int ans = 0, i = 0;
        while (N > 0) {
            if (N % 2 == 0) 
                ans = setBit(ans, i);
            i += 1;
            N /= 2;
        }
        return ans;
    }
    
    int setBit(int x, int k) {
        return (1 << k) | x;
    }
}