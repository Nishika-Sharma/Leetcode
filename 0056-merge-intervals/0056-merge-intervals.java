class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)
        return new int [0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]>result = new LinkedList<>();
        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] lastAddedInterval = result.getLast();
            if(lastAddedInterval[1] >= intervals[i][0]) {
                lastAddedInterval[1] = Math.max(lastAddedInterval[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}