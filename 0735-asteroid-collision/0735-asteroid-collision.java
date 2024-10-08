class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && cur < 0) {
                if (stack.peek() < -cur) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -cur) {
                    stack.pop();
                }
                isDestroyed = true;
                break;
            }
            if (!isDestroyed) {
                stack.push(cur);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}