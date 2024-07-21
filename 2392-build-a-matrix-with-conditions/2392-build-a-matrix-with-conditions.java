import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[] rowOrder = topoSort(k, rowConditions);
        int[] colOrder = topoSort(k, colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][];
        }

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder[i]] = i;
            colPos[colOrder[i]] = i;
        }

        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }

    private int[] topoSort(int n, int[][] conditions) {
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] condition : conditions) {
            graph[condition[0]].add(condition[1]);
            inDegree[condition[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] order = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            for (int neighbor : graph[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return index == n ? order : null;
    }
}
