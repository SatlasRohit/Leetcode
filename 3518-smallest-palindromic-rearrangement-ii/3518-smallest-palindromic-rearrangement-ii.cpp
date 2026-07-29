#include <string>
#include <vector>
#include <algorithm>

class Solution {
public:
    std::string smallestPalindrome(std::string s, int k) {
        std::vector<int> count(26, 0);
        for (char c : s) {
            count[c - 'a']++;
        }

        std::string half = "";
        char mid = 0;

        for (int i = 0; i < 26; ++i) {
            if (count[i] % 2 != 0) {
                mid = 'a' + i;
            }
            half.append(count[i] / 2, 'a' + i);
        }

        int half_len = half.length();
        long long current_k = k;

        auto nCr = [](int n, int r) -> double {
            if (r < 0 || r > n) return 0;
            if (r == 0 || r == n) return 1;
            if (r > n / 2) r = n - r;
            double res = 1;
            for (int i = 1; i <= r; ++i) {
                res = res * (n - i + 1) / i;
            }
            return res;
        };

        auto countPermutations = [&](const std::vector<int>& freq, int total) -> double {
            double res = 1;
            int current_total = total;
            for (int f : freq) {
                if (f == 0) continue;
                res *= nCr(current_total, f);
                current_total -= f;
                if (res > 1e18) return 1e18;
            }
            return res;
        };

        std::vector<int> half_count(26, 0);
        for (char c : half) {
            half_count[c - 'a']++;
        }

        double total_palindromes = countPermutations(half_count, half_len);
        if ((double)current_k > total_palindromes) {
            return "";
        }

        std::string res_half = "";
        int remaining_len = half_len;

        for (int i = 0; i < half_len; ++i) {
            for (int c = 0; c < 26; ++c) {
                if (half_count[c] == 0) continue;

                half_count[c]--;
                double ways = countPermutations(half_count, remaining_len - 1);

                if ((double)current_k <= ways) {
                    res_half += (char)('a' + c);
                    remaining_len--;
                    break;
                } else {
                    current_k -= (long long)std::min(ways, 1e18);
                    half_count[c]++;
                }
            }
        }

        std::string second_half = res_half;
        std::reverse(second_half.begin(), second_half.end());

        if (mid != 0) {
            return res_half + mid + second_half;
        }
        return res_half + second_half;
    }
};