class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list =new ArrayList<>();
        int maximumCandies=Integer.MIN_VALUE;
        for (int candie : candies){
            if(candie>maximumCandies){
                maximumCandies=candie;
            }
        }
        for(int candie :candies){
            if(candie+extraCandies>=maximumCandies){
                 list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}