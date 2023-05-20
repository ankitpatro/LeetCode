class Solution {
    int row;
    int col;

    int[][] landHeights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

         row = heights.length;
         col = heights[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col]; 

        landHeights = heights;

        for(int c = 0; c < col; c++) {
            dfs(pac, 0, c, heights[0][c]);
            dfs(atl, row - 1, c, heights[row - 1][c]);
        }

         for(int r = 0; r < row; r++) {
            dfs(pac, r, 0, heights[r][0]);
            dfs(atl, r, col - 1, heights[r][col - 1]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(pac[r][c] && atl[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(boolean[][] visit, int r, int c, int prevHeight) {
        if(r < 0 || c < 0 || r == row || c == col || visit[r][c] || landHeights[r][c] < prevHeight) {
            return;
        }

        visit[r][c] = true;

        dfs(visit, r-1, c, landHeights[r][c]);
        dfs(visit, r+1, c, landHeights[r][c]);
        dfs(visit, r, c-1, landHeights[r][c]);
        dfs(visit, r, c+1, landHeights[r][c]);
    }
}
