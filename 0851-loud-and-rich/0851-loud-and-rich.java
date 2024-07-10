class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] quietest = new int[quiet.length];
        for(int i = 0; i < quiet.length; i++){
            quietest[i] = searchForQuietest(richer, quiet, i, quietest);
        }
        return quietest;
    }
    public int searchForQuietest(int[][] richer, int[] quiet, int person, int[] quietest){
        int leastQuiet = person;
        for(int i = 0; i < richer.length; i++){
            if(richer[i][1] == person){
                int leastQuietPerson;
                if(quietest[richer[i][0]] != 0)
                    leastQuietPerson = quietest[richer[i][0]];
                else leastQuietPerson = searchForQuietest(richer, quiet, richer[i][0], quietest);
                leastQuiet = Math.min(quiet[leastQuietPerson], quiet[leastQuiet]) == quiet[leastQuiet]?leastQuiet: leastQuietPerson;
            }
        }
    return leastQuiet;
    }
}