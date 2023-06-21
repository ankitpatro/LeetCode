class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return result;
        int[][] visited = new int[matrix.length][matrix[0].length];
        moveRight(0, 0, matrix, visited);

        return result;
    }

    private void moveRight(int i, int j, int[][] matrix, int[][] visited) {

        while(j < matrix[0].length && visited[i][j] == 0) {
            visited[i][j] = 1;
            result.add(matrix[i][j]);
            j++;
        }
        if( i < matrix.length - 1 && j > 0 && visited[i+1][j-1] == 0)
        moveDown(i + 1, j - 1, matrix, visited);
    }

    private void moveDown(int i, int j, int[][] matrix, int[][] visited) {
        while(i < matrix.length && visited[i][j] == 0) {
            visited[i][j] = 1;
            result.add(matrix[i][j]);
            i++;
        }

        if(i > 0 && j > 0 && visited[i-1][j-1] == 0)
        moveLeft(i - 1, j - 1, matrix, visited);
    }

    private void moveLeft(int i, int j, int[][] matrix, int[][] visited) {
        while(j >= 0 && visited[i][j] == 0) {
            visited[i][j] = 1;
            result.add(matrix[i][j]);
            j--;
        }
        if(i > 0 && j < matrix[0].length -1 && visited[i-1][j+1]==0)
        moveUp(i-1, j+1, matrix, visited);
    }

    private void moveUp(int i, int j, int[][] matrix, int[][] visited) {
        while(i >= 0 && visited[i][j] == 0 ) {
            visited[i][j] = 1;
            result.add(matrix[i][j]);
            i--;
        }
        if(i< matrix.length-1 && j < matrix[0].length - 1 && visited[i+1][j+1] == 0)
        moveRight(i+1, j+1, matrix, visited);
    }



}
