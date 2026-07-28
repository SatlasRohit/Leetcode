from collections import Counter

class Solution:
    def smallestPalindrome(self, s: str) -> str:
        counts = Counter(s)
        
        half = []
        mid = ""
    
        for i in range(26):
            ch = chr(ord('a') + i)
            if counts[ch] > 0:
                if counts[ch] % 2 != 0:
                    mid = ch
                half.append(ch * (counts[ch] // 2))
                
        first_half = "".join(half)
        return first_half + mid + first_half[::-1]