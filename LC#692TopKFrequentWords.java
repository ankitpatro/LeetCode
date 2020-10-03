class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> topKFrequentWords = new ArrayList<>();
        if(words.length == 0 || words == null) return topKFrequentWords;
        
        Map<String, Integer> wordToCount = new HashMap<>();
        for(String word : words)
        {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0)+1);
        }
        
        List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String, Integer> >(wordToCount.entrySet());
        
        Collections.sort(entries,(o1, o2) -> 
            { 
                if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return (o2.getValue()).compareTo(o1.getValue());             
        });
            
        for(int i =0; i<k; i++)
        {
            topKFrequentWords.add(entries.get(i).getKey());
        }
        
        return topKFrequentWords;
    }
}
