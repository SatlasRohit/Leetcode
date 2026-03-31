#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string generateString(string str1, string str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        string word(len, '?');
        vector<bool> fixed(len, false);

        for (int i = 0; i < n; ++i) {
            if (str1[i] == 'T') {
                for (int j = 0; j < m; ++j) {
                    if (fixed[i + j] && word[i + j] != str2[j]) {
                        return "";
                    }
                    word[i + j] = str2[j];
                    fixed[i + j] = true;
                }
            }
        }

        for (int i = 0; i < len; ++i) {
            if (!fixed[i]) {
                word[i] = 'a';
            }
        }

        for (int i = 0; i < n; ++i) {
            if (str1[i] == 'F') {
                bool match = true;
                for (int j = 0; j < m; ++j) {
                    if (word[i + j] != str2[j]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    bool changed = false;
                    for (int j = m - 1; j >= 0; --j) {
                        if (!fixed[i + j]) {
                            word[i + j] = 'b';
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) return "";
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            bool match = true;
            for (int j = 0; j < m; ++j) {
                if (word[i + j] != str2[j]) {
                    match = false;
                    break;
                }
            }
            if (str1[i] == 'T' && !match) return "";
            if (str1[i] == 'F' && match) return "";
        }

        return word;
    }
};