class Solution {
    public int minStickers(String[] stickers, String target) {
        //create map of character count for each sticker

        List<Map<Character, Integer>> stickersCount = new ArrayList<>();

        for(String sticker : stickers) {
            Map<Character, Integer> characterCount = new HashMap<>();
            for(char c : sticker.toCharArray()) {
                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
            }
            stickersCount.add(characterCount);
        }

// cache the min stickers needed to form remaining String in 'target'
        Map<String, Integer> cache = new HashMap<>(); 
        Map<Character, Integer> stickerCharacterCount = new HashMap<>();

        int result = dfs(target, stickersCount, stickerCharacterCount, cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String target, List<Map<Character, Integer>> stickersCount, Map<Character, Integer> currentStickerCharacterCount, Map<String, Integer> cache) {

        if(cache.containsKey(target)) {
            return cache.get(target);
        }

        //initialize result variable for the given target - initially it'll be 0'
        
        int result = currentStickerCharacterCount.isEmpty() ? 0 : 1;

        //Exhaust all the characters in target for a given sticker an then Create StringBuilde instance to store remaining characters in target

        StringBuilder remaining = new StringBuilder();

        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            Integer charCount = currentStickerCharacterCount.get(c);

            if(charCount != null && charCount > 0) {
                currentStickerCharacterCount.put(c, charCount - 1);
            }

            else {
                remaining.append(c);
            }
        }

        if(!remaining.isEmpty()) {
            int stickersUsed = Integer.MAX_VALUE;

            for(Map<Character, Integer> stickerCount : stickersCount) {
                if(!stickerCount.containsKey(remaining.charAt(0))) continue;

                stickersUsed = Math.min(stickersUsed, dfs(remaining.toString(), stickersCount, new HashMap<>(stickerCount), cache));
            }

            cache.put(remaining.toString(), stickersUsed);
            result = stickersUsed == Integer.MAX_VALUE ? stickersUsed : result + stickersUsed;
        }

        return result;

    }
}
