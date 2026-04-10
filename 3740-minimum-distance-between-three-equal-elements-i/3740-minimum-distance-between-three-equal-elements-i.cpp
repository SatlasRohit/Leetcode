#include <vector>
#include <unordered_map>
#include <algorithm>
#include <climits>

class Solution {
public:
    int minimumDistance(std::vector<int>& nums) {
        std::unordered_map<int, std::vector<int>> index_map;
        for (int i = 0; i < nums.size(); ++i) {
            index_map[nums[i]].push_back(i);
        }

        long long min_dist = LLONG_MAX;
        bool found = false;

        for (auto const& [val, indices] : index_map) {
            if (indices.size() >= 3) {
                found = true;
                for (size_t m = 0; m <= indices.size() - 3; ++m) {
                    long long current_dist = 2LL * (indices[m + 2] - indices[m]);
                    if (current_dist < min_dist) {
                        min_dist = current_dist;
                    }
                }
            }
        }

        return found ? (int)min_dist : -1;
    }
};