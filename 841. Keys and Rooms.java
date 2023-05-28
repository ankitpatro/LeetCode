class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for(int roomKey : rooms.get(currentRoom)) {
                if(!seen[roomKey]) {
                    stack.push(roomKey);
                    seen[roomKey] = true;
                }
            }
        }

        for(boolean visited : seen) {
            if(!visited) {
                return false;
            }
        }

        return true;

    }
}
