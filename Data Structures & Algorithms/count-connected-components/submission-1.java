class Solution {
    public int countComponents(int n, int[][] edges) {

        int[] parent = new int[n];


        //node to itself declare 
        for(int i = 0; i < parent.length; i++) parent[i] = i;

            for(int[] edge : edges) union(edge[0], edge[1], parent);

            //ouput result
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < parent.length; i++) set.add(find(i, parent));

            return set.size();
    }


    private void union(int edge1, int edge2, int[] parent){

        int parent1 = find(edge1, parent);
        int parent2 = find(edge2, parent);

        parent[parent1] = parent2;
    }

    private int find(int edge, int[] parent){

        if(parent[edge] != edge) 

        parent[edge] = find(parent[edge], parent);

        return parent[edge];
    }
}
