class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //bucket 

        List<Integer>[] bucket = new List[nums.length + 1];

        //freqhashmap

        Map<Integer, Integer> freqmap = new HashMap<>();

        for(int num : nums){

            freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
        }

        //putting keys in bucket freqmap

        for(Integer num : freqmap.keySet()){

            int frequency = (int)freqmap.get(num);

            if(bucket[frequency] == null){

                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        //output

        int[] output = new int[k];

        int index = 0;

        for(int i = bucket.length - 1; i >= 0 && index < k; i--){

            if(bucket[i] != null){

                for(Integer value : bucket[i]){

                    output[index] = value;
                    index++;

                    if(index == k) break;
                }
            }
        }

        return output;
        
    }
}
