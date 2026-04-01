#include <vector>
#include <string>
#include <algorithm>
#include <numeric>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        int n = positions.size();
        vector<int> indices(n);
        iota(indices.begin(), indices.end(), 0);

        sort(indices.begin(), indices.end(), [&](int i, int j) {
            return positions[i] < positions[j];
        });

        stack<int> st;
        for (int i : indices) {
            if (directions[i] == 'R') {
                st.push(i);
            } else {
                while (!st.empty() && healths[i] > 0) {
                    int top = st.top();
                    if (healths[top] < healths[i]) {
                        healths[i] -= 1;
                        healths[top] = 0;
                        st.pop();
                    } else if (healths[top] > healths[i]) {
                        healths[top] -= 1;
                        healths[i] = 0;
                    } else {
                        healths[top] = 0;
                        healths[i] = 0;
                        st.pop();
                    }
                }
            }
        }

        vector<int> result;
        for (int i = 0; i < n; ++i) {
            if (healths[i] > 0) {
                result.push_back(healths[i]);
            }
        }
        return result;
    }
};