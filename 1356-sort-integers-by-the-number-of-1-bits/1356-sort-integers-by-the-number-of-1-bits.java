class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA == bitsB) {
                return a - b;   // smaller number first
            }
            return bitsA - bitsB; // fewer bits first
        });

        return Arrays.stream(boxed).mapToInt(i -> i).toArray();
    }
}