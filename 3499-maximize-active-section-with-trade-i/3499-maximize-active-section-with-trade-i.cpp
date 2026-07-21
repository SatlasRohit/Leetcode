#include <string>
#include <vector>
#include <algorithm>
#include <numeric>

class Solution {
public:
    int maxActiveSectionsAfterTrade(std::string s) {
        std::string t = "1" + s + "1";
        std::vector<int> a, b;
        
        int i = 0, n = t.length();
        while (i < n) {
            int a_len = 0;
            while (i < n && t[i] == '1') {
                a_len++;
                i++;
            }
            a.push_back(a_len);
            
            if (i < n) {
                int b_len = 0;
                while (i < n && t[i] == '0') {
                    b_len++;
                    i++;
                }
                b.push_back(b_len);
            }
        }
        
        int initial_ones = 0;
        for (char c : s) {
            if (c == '1') initial_ones++;
        }
        
        int k = a.size();
        if (k < 3) return initial_ones;
        
        int m = b.size();
        std::vector<int> pref_max(m), suff_max(m);
        pref_max[0] = b[0];
        for (int j = 1; j < m; ++j) {
            pref_max[j] = std::max(pref_max[j - 1], b[j]);
        }
        suff_max[m - 1] = b[m - 1];
        for (int j = m - 2; j >= 0; --j) {
            suff_max[j] = std::max(suff_max[j + 1], b[j]);
        }
        
        int max_gain = 0;
        for (int idx = 1; idx < k - 1; ++idx) {
            int gain1 = b[idx - 1] + b[idx];
            
            int max_other_b = -1;
            if (idx - 2 >= 0) {
                max_other_b = std::max(max_other_b, pref_max[idx - 2]);
            }
            if (idx + 1 < m) {
                max_other_b = std::max(max_other_b, suff_max[idx + 1]);
            }
            
            int gain2 = (max_other_b != -1) ? (max_other_b - a[idx]) : 0;
            
            max_gain = std::max({max_gain, gain1, gain2});
        }
        
        return initial_ones + max_gain;
    }
};