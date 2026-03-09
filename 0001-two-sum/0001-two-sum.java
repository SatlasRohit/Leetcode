class Solution {
    public int[] twoSum(int[] nums, int target) {
        int capacity = 1;
        while (capacity < nums.length * 2) {
            capacity <<= 1;
        }
        
        int[] keys = new int[capacity];
        int[] values = new int[capacity];
        boolean[] occupied = new boolean[capacity]; // Отслеживаем занятые ячейки
        
        int mask = capacity - 1;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Вычисляем индекс с обработкой отрицательных чисел
            int hash = complement;
            int idx = (hash & 0x7FFFFFFF) % capacity; // Гарантируем положительный индекс
            
            // Поиск complement
            while (occupied[idx]) {
                if (keys[idx] == complement) {
                    return new int[] { values[idx], i };
                }
                idx = (idx + 1) & mask;
            }
            
            // Вставка текущего числа
            int currHash = nums[i];
            int currIdx = (currHash & 0x7FFFFFFF) % capacity;
            
            while (occupied[currIdx]) {
                currIdx = (currIdx + 1) & mask;
            }
            
            keys[currIdx] = nums[i];
            values[currIdx] = i;
            occupied[currIdx] = true;
        }
        
        return new int[0];
    }
}