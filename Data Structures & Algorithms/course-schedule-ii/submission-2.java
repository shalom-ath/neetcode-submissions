class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){

            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){

            graph.get(pre[1]).add(pre[0]);
            
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){

            if(indegree[i] == 0) 
            queue.offer(i);
        }

        int count = 0;

        int[] result = new int[numCourses];

        while(!queue.isEmpty()){

            int current = queue.poll();

            result[count++] = current;

            for(int innode : graph.get(current)){

                indegree[innode]--;

                if(indegree[innode] == 0) 

                queue.offer(innode);
            }
        }

        if(count != numCourses)

        return new int[0];

        return result;
        
    }
}
