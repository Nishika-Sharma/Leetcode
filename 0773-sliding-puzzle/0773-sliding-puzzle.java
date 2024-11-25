class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        String startState = start.toString();
        if (startState.equals(target)) return 0;

        int[][] neighbors = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startState);
        visited.add(startState);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return moves;

                int zeroIndex = current.indexOf('0');
                for (int neighbor : neighbors[zeroIndex]) {
                    StringBuilder nextState = new StringBuilder(current);
                    nextState.setCharAt(zeroIndex, current.charAt(neighbor));
                    nextState.setCharAt(neighbor, '0');
                    String next = nextState.toString();
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
