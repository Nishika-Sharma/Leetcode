class StockSpanner {
    private ArrayList<Integer> stock;

    public StockSpanner() {
        stock = new ArrayList<>();
    }
    public int next(int price) {
        stock.add(price);
        for (int i = stock.size() - 2; i >= 0; i--) {
            if (stock.get(i) > price) {
                return stock.size() - 1 -i;
            }
        }
        return stock.size();
    }
}
