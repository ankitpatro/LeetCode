/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        
        if(bottomLeft[0] > topRight[0] || bottomLeft[1] > topRight[1]) {
            return 0;
        }

        if(!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if(bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) {
            return 1;
        }

        int midX = (bottomLeft[0] + topRight[0]) / 2;
        int midY = (bottomLeft[1] + topRight[1]) / 2;

        return countShips(sea, new int[]{midX, midY}, bottomLeft) +
        countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
        countShips(sea, new int[]{topRight[0], midY}, new int[] {midX + 1, bottomLeft[1]}) +
        countShips(sea, topRight, new int[]{midX + 1, midY + 1}); 
    }
}
