#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int maximumAmount(vector<vector<int>>& coins) {
        int m = coins.size();
        int n = coins[0].size();
        long long INF = 1e15;
        
        vector<vector<vector<long long>>> dp(m, vector<vector<long long>>(n, vector<long long>(3, -INF)));

        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (i == 0 && j == 0) continue;

                    long long prev_best = -INF;
                    if (i > 0) prev_best = max(prev_best, dp[i - 1][j][k]);
                    if (j > 0) prev_best = max(prev_best, dp[i][j - 1][k]);

                    if (prev_best != -INF) {
                        dp[i][j][k] = max(dp[i][j][k], prev_best + coins[i][j]);
                    }

                    if (k > 0 && coins[i][j] < 0) {
                        long long prev_k_minus = -INF;
                        if (i > 0) prev_k_minus = max(prev_k_minus, dp[i - 1][j][k - 1]);
                        if (j > 0) prev_k_minus = max(prev_k_minus, dp[i][j - 1][k - 1]);
                        
                        if (prev_k_minus != -INF) {
                            dp[i][j][k] = max(dp[i][j][k], prev_k_minus);
                        }
                    }
                }
            }
        }

        long long result = dp[m - 1][n - 1][0];
        result = max(result, dp[m - 1][n - 1][1]);
        result = max(result, dp[m - 1][n - 1][2]);
        
        return (int)result;
    }
};