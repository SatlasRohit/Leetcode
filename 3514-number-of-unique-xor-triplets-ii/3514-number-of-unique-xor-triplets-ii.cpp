#include <vector>
#include <unordered_set>
#include <algorithm>

class Solution {
public:
    int uniqueXorTriplets(std::vector<int>& nums) {
        int n = nums.size();
        
        std::unordered_set<int> unique_nums(nums.begin(), nums.end());
        std::vector<int> distinct_nums(unique_nums.begin(), unique_nums.end());
        int m = distinct_nums.size();

        std::unordered_set<int> pair_xors;
        for (int i = 0; i < m; ++i) {
            for (int j = i; j < m; ++j) {
                pair_xors.insert(distinct_nums[i] ^ distinct_nums[j]);
            }
        }

        std::unordered_set<int> triplet_xors;
        for (int px : pair_xors) {
            for (int num : distinct_nums) {
                triplet_xors.insert(px ^ num);
            }
        }

        return triplet_xors.size();
    }
};