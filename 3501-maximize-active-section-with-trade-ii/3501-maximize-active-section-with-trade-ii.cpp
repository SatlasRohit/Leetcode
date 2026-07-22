#include <vector>
#include <string>
#include <algorithm>

class Solution {
    struct SparseTable {
        int n;
        std::vector<std::vector<int>> st;
        std::vector<int> lg;

        void init(const std::vector<int>& arr) {
            n = arr.size();
            if (n == 0) return;
            int max_log = 32 - __builtin_clz(n);
            st.assign(max_log, std::vector<int>(n));
            lg.assign(n + 1, 0);
            for (int i = 2; i <= n; ++i) lg[i] = lg[i / 2] + 1;

            for (int i = 0; i < n; ++i) st[0][i] = arr[i];
            for (int j = 1; j < max_log; ++j) {
                for (int i = 0; i + (1 << j) <= n; ++i) {
                    st[j][i] = std::max(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
                }
            }
        }

        int query(int l, int r) const {
            if (l > r) return 0;
            int k = lg[r - l + 1];
            return std::max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    };

    struct Group {
        int start;
        int end;
        int len;
    };

public:
    std::vector<int> maxActiveSectionsAfterTrade(std::string s, std::vector<std::vector<int>>& queries) {
        int n = s.length();
        int total_ones = 0;
        for (char c : s) {
            if (c == '1') total_ones++;
        }

        std::vector<Group> groups;
        std::vector<int> pos_to_group(n, -1);

        for (int i = 0; i < n; ) {
            if (s[i] == '0') {
                int start = i;
                while (i < n && s[i] == '0') i++;
                int end = i - 1;
                int len = end - start + 1;
                int g_idx = groups.size();
                groups.push_back({start, end, len});
                for (int j = start; j <= end; ++j) {
                    pos_to_group[j] = g_idx;
                }
            } else {
                i++;
            }
        }

        std::vector<int> next_group(n, -1), prev_group(n, -1);
        int cur = -1;
        for (int i = 0; i < n; ++i) {
            if (pos_to_group[i] != -1) cur = pos_to_group[i];
            prev_group[i] = cur;
        }
        cur = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (pos_to_group[i] != -1) cur = pos_to_group[i];
            next_group[i] = cur;
        }

        int m = groups.size();
        std::vector<int> pair_sums;
        if (m >= 2) {
            pair_sums.resize(m - 1);
            for (int i = 0; i < m - 1; ++i) {
                pair_sums[i] = groups[i].len + groups[i + 1].len;
            }
        }

        SparseTable st;
        if (!pair_sums.empty()) {
            st.init(pair_sums);
        }

        std::vector<int> ans;
        ans.reserve(queries.size());

        for (const auto& q : queries) {
            int l = q[0], r = q[1];

            int k = next_group[l];
            int p = prev_group[r];

            if (k == -1 || p == -1 || k > p || groups[k].start > r || groups[p].end < l) {
                ans.push_back(total_ones);
                continue;
            }

            if (k == p) {
                ans.push_back(total_ones);
                continue;
            }

            int max_gain = 0;

            auto get_trunc_len = [&](int idx) {
                int st_pos = std::max(groups[idx].start, l);
                int ed_pos = std::min(groups[idx].end, r);
                return std::max(0, ed_pos - st_pos + 1);
            };

            int gain_k = get_trunc_len(k) + get_trunc_len(k + 1);
            max_gain = std::max(max_gain, gain_k);

            int gain_p = get_trunc_len(p - 1) + get_trunc_len(p);
            max_gain = std::max(max_gain, gain_p);

            if (k + 1 <= p - 2) {
                int mid_max = st.query(k + 1, p - 2);
                max_gain = std::max(max_gain, mid_max);
            }

            ans.push_back(total_ones + max_gain);
        }

        return ans;
    }
};