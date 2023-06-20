class LFUCache {

    private int cap;
    private int min = 1;

    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> keyFrequencyMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> frequencyKeyMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.cap = capacity;
        frequencyKeyMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)) {
            return -1;
        }

        int frequency = keyFrequencyMap.get(key);
        frequencyKeyMap.get(frequency).remove(key);

        if(frequency == min && frequencyKeyMap.get(min).size() == 0) {
            min++;
        }

        if(!frequencyKeyMap.containsKey(frequency + 1)) {
            frequencyKeyMap.put(frequency + 1, new LinkedHashSet<>());
        }

        frequencyKeyMap.get(frequency + 1).add(key);
        keyFrequencyMap.put(key, frequency + 1);

        return keyValueMap.get(key);

    }
    
    public void put(int key, int value) {
        if(keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);
            return;
        }

        if(keyValueMap.size() == cap) {
            int keyToBeEvicted = frequencyKeyMap.get(min).iterator().next();
            frequencyKeyMap.get(min).remove(keyToBeEvicted);
            keyValueMap.remove(keyToBeEvicted);
            keyFrequencyMap.remove(keyToBeEvicted);
        }

        keyValueMap.put(key, value);
        keyFrequencyMap.put(key, 1);
        min = 1;
        frequencyKeyMap.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
