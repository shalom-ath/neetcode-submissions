class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){

            while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]){

                int popped = stack.pop();
                
                res[popped] = i - popped;
            }

            stack.push(i);
        }

        return res;
        
    }
}
