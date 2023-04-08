class Solution {
    boolean flag;
    public boolean exist(char[][] board, String word) {
        if(word == null || board == null || board.length == 0) return false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                backtrack(0, board, word, i, j);
            }
        }
        return flag;
    }

    private void backtrack(int index, char[][] board,String word, int i, int j) {
        if( index == word.length()) {
            flag = true; 
            return;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) ) {
            return;
        }

        index++;
        char currentCharacter = board[i][j];
        board[i][j] = '#';

        backtrack(index, board, word, i - 1, j);
        backtrack(index, board, word, i + 1, j);
        backtrack(index, board, word, i, j - 1);
        backtrack(index, board, word, i, j + 1);

        board[i][j] = currentCharacter;

    }
}
