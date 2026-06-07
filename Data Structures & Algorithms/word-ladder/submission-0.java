class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()){

            String word = queue.poll();

            if(word == null){

                level++;

                if(!queue.isEmpty())

                    queue.add(null);
                    continue;
                }

                if(word.equals(endWord)) return level;

                for(int i = 0; i < word.length(); i++){

                    char[] chars = word.toCharArray();

                    for(char c = 'a'; c <= 'z'; c++){

                        chars[i] = c;

                        String nextword = new String(chars);

                        if(wordList.contains(nextword) && !visited.contains(nextword)){

                            visited.add(nextword);
                            queue.offer(nextword);
                        }
                    }
                }

            
        }

        return 0;

    }
}
