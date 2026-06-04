class Solution {
    public boolean validTree(int n, int[][] edges) {

        //edge case

        if(edges.length != n - 1) return false;

        List<List<Integer>> adjlist = new ArrayList<>();

        for(int i = 0; i < n; i++)

        adjlist.add(new ArrayList<>());

        for(int[] edge : edges){

            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()){

            int node = stack.pop();

            for(int neighbors : adjlist.get(node)){

                if(visited.contains(neighbors))

                continue;

                visited.add(neighbors);
                stack.push(neighbors);
            }
        }

        if(visited.size() == n)

        return true;

        return false;


    }
}
