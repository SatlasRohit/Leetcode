#include <vector>
#include <unordered_map>
#include <algorithm>
#include <climits>

class Solution {
public:
    int minimumDistance(std::vector<int>& nums) {
        std::unordered_map<int, std::vector<int>> pos;
        for (int i = 0; i < nums.size(); ++i) {
            pos[nums[i]].push_back(i);
        }

        int min_dist = INT_MAX;

        for (const auto& [num, indices] : pos) {
            if (indices.size() >= 3) {
                for (size_t i = 0; i + 2 < indices.size(); ++i) {
                    int dist = 2 * (indices[i + 2] - indices[i]);
                    min_dist = std::min(min_dist, dist);
                }
            }
        }

        return min_dist == INT_MAX ? -1 : min_dist;
    }
};