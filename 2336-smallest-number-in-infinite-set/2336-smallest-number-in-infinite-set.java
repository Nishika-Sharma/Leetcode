class SmallestInfiniteSet {
    private TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
        }
    }
    public int popSmallest() {
        if (set.isEmpty()) return -1;

        int min = set.first();
        set.remove(min);
        return min;
    }
    public void addBack(int num) {
        set.add(num);
    }
}