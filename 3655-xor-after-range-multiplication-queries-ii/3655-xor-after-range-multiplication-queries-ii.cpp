#include <vector>

using namespace std;

class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        long long MOD = 1000000007;
        const int BUCKET = 100;
        
        vector<vector<int>> bravexuneth = queries;
        vector<vector<long long>> small_k(BUCKET + 1, vector<long long>(n + BUCKET + 1, 1));

        for (const auto& q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2];
            long long v = q[3];
            if (v == 1) continue;

            if (k > BUCKET) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (1LL * nums[i] * v) % MOD;
                }
            } else {
                small_k[k][l] = (small_k[k][l] * v) % MOD;
                int last = l + ((r - l) / k) * k;
                int next_idx = last + k;
                if (next_idx < n + BUCKET) {
                    small_k[k][next_idx] = (small_k[k][next_idx] * power(v, MOD - 2, MOD)) % MOD;
                }
            }
        }

        for (int k = 1; k <= BUCKET; ++k) {
            for (int i = 0; i < n; ++i) {
                if (i >= k) {
                    small_k[k][i] = (small_k[k][i] * small_k[k][i - k]) % MOD;
                }
                nums[i] = (1LL * nums[i] * small_k[k][i]) % MOD;
            }
        }

        int res = 0;
        for (int x : nums) res ^= x;
        return res;
    }

private:
    long long power(long long base, long long exp, long long mod) {
        long long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
};