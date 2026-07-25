class Solution {
public:
    int maxProduct(int n) {
    std::string s = std::to_string(n);
    int max1 = -1, max2 = -1;
    for(char c:s) {
        int digit = c - '0';
        if(digit > max1) {
            max2 = max1;
            max1 = digit; 
        } else if(digit > max2) {
            max2 = digit;
        }
    }
    return max1*max2;
    }
};


