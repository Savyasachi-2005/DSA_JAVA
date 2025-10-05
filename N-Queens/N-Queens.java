import java.util.*;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        List<List<String>> res=new ArrayList<>();
        int[] leftrow=new int[n];
        int[] updigo=new int[2*n-1];
        int[] lodigo=new int[2*n-1];
        solve(0,board,res,leftrow,updigo,lodigo);
        return res;
    }
    private void solve(int col,char[][] board,List<List<String>> res,int[] leftrow,int[] updigo,int[] lodigo){
        int n=board.length;
        if(col==n){
            res.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(leftrow[row]==0 && lodigo[row+col]==0 && updigo[n-1+col-row]==0){
                board[row][col]='Q';
                leftrow[row]=1;
                lodigo[row+col]=1;
                updigo[n-1+col-row]=1;
                solve(col+1,board,res,leftrow,updigo,lodigo);
                board[row][col]='.';
                leftrow[row]=0;
                lodigo[row+col]=0;
                updigo[n-1+col-row]=0;

            }
        }
    }
    static List<String> construct(char[][] board){
        List<String> res=new LinkedList<String>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
}