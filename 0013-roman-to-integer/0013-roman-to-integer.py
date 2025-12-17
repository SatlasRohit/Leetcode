class Solution(object):
    def romanToInt(self, s):  # Added 'self' parameter
        """
        :type s: str
        :rtype: int
        """
        # Map Roman symbols to their integer values
        roman = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        
        result = 0
        prev_value = 0
        
        # Iterate from right to left
        for i in range(len(s) - 1, -1, -1):
            current_value = roman[s[i]]  # Get value of current symbol
            if current_value >= prev_value:
                result += current_value  # Add if current >= previous
            else:
                result -= current_value  # Subtract if current < previous
            prev_value = current_value
        
        return result

# Test the solution
 # Should output 3
            