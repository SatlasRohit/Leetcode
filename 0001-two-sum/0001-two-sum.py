class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        num_map = {} 
        # for i, num in enumerate(nums):
        #     complement = target - num  
        #     if complement in num_map:

        #         return [num_map[complement], i] 
        #     num_map[num] = i  
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if(nums[i]+nums[j]==target):
                    return[i,j]