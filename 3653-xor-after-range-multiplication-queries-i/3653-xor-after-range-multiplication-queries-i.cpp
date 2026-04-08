#include <vector>

using namespace std;

class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        long long MOD = 1000000007;
        
        for (const auto& query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            long long v = query[3];
            
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (1LL * nums[idx] * v) % MOD;
            }
        }
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
};