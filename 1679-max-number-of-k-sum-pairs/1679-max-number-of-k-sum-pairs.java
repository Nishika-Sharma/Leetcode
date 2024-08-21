public class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (map.containsKey(k - nums[i])) {
                if (k - nums[i] == nums[i] && map.get(nums[i]).size() == 1) continue;

                int index = map.get(k - nums[i]).remove(map.get(k - nums[i]).size() - 1);
                if (map.get(k - nums[i]).isEmpty()) {
                    map.remove(k - nums[i]);
                }

                map.get(nums[i]).remove(0);
                if (map.get(nums[i]).isEmpty()) {
                    map.remove(nums[i]);
                }

                nums[index] = Integer.MAX_VALUE;
                nums[i] = Integer.MAX_VALUE;
                counter++;
            }
        }

        return counter;
    }
}