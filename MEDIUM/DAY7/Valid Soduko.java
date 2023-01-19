class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N=9;

        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] cells = new HashSet[N];

        for(int i=0;i<9;i++)
        {
            rows[i]=new HashSet<Character>();
            cols[i]=new HashSet<Character>();
            cells[i]=new HashSet<Character>();
            
        }

        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                continue;

                if(rows[i].contains(board[i][j]))
                return false;
                rows[i].add(board[i][j]);

                if(cols[j].contains(board[i][j]))
                return false;
                cols[j].add(board[i][j]);

                int idx =(i/3)*3  + j / 3;
                if(cells[idx].contains(board[i][j]))
                return false;
                cells[idx].add(board[i][j]);
                
            }
        }
        return true;
    }
}
