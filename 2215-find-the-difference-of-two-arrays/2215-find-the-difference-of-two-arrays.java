class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int element:nums1){
            set1.add(element);
        }
        for(int element:nums2){
            set2.add(element);
        }
        for(Integer element :set1){
            if(!set2.contains(element)){
                list1.add(element);
            }
        }
        for(Integer element :set2){
            if(!set1.contains(element)){
                list2.add(element);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}