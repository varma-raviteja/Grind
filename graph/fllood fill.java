
// DFS - O(N) O(N)


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}


// BFS -O(N) O(N)
class pair{
    int first;
    int second;
    public pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    private static void bfs(int i , int j , int [][] image,
    int color, int inicolor, int dist[][]){
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(i , j));
        dist[i][j] = color;
        int n = image.length;
        int m = image[0].length;

        int delrow[] = { -1 , 0 , 1 , 0};
        int delcol[] = { 0 , 1 , 0 , -1};
        while(! q.isEmpty()){
            int row  =q.peek().first;
            int col = q.peek().second;
            q.remove();

        for(int ia = 0 ;ia<4 ;ia++){
            int nrow = row + delrow[ia];
            int ncol = col + delcol[ia];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
             image[nrow][ncol] == inicolor && dist[nrow][ncol] != color){
                dist[nrow][ncol] =color;
                q.add(new pair(nrow , ncol));
            }
        }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dist[][] = image;
        int inicolor = image[sr][sc];
        bfs( sr , sc, image , color , inicolor , dist );
        return dist;
    
    
    }
}
