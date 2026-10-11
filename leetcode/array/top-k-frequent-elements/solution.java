class Pair{
    public int key;
    public int value;
    Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            frequencyMap.put(nums[i],frequencyMap.getOrDefault(nums[i],0)+1);
        }
        List<Pair> list = new ArrayList<>();
        frequencyMap.forEach((key,value)->{
            list.add(new Pair(key,value));
        });
        list.sort((a,b)->b.value-a.value);
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = list.get(i).key;
        }
        return result;
    }
}