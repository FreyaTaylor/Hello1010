package Jul17;

import java.util.ArrayList;
import java.util.List;

public class BT_12_path_in_matrix {


    //一遍过了很开心，没有剪枝，但是回溯的代码看起老真的超级整齐
    //看他人解题的一些思路：
    // board临时赋值成‘/’，用来标记已访问的元素，省下了bool[][] visited的空间，巧妙噢！@SnowD 的建议也很好！
    // 四个dfs最好用数组循环写，写四个dfs有点不美观，

    public static boolean exist(char[][] board, String word) {
        boolean[][] available=new boolean[board.length][board[0].length];
        List<Integer> firstC = new ArrayList<>();
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                available[i][j]=true;//初始化
                if (board[i][j]==word.charAt(0)){//寻找word第一个字母出现的位置
                    firstC.add(i);
                    firstC.add(j);
                }

            }
        }

        for(int k=0;k<firstC.size()/2;k++) {//在所有word第一个字母出现的位置回溯
            available[firstC.get(2*k)][firstC.get(2*k+1)]=false;
            if (bt(board,word.substring(1,word.length()),available,firstC.get(2*k),firstC.get(2*k+1))) {
                return true;
            }
            available[firstC.get(2*k)][firstC.get(2*k+1)] = true;
        }

        return false;

    }

    //可行判断可以写在算法出口处
    public static boolean bt(char[][] board,String word,boolean[][] available,int x,int y){

        if (word.length()==0){
            return true;
        }

        if (x-1>=0 && board[x-1][y]==word.charAt(0) && available[x-1][y]){ //上
            available[x-1][y]=false;
            if (bt(board,word.substring(1,word.length()),available,x-1,y)){
                return true;
            }
            available[x-1][y]=true;

        }
        if (x+1<=board.length-1 && board[x+1][y]==word.charAt(0) && available[x+1][y]){ //下
            available[x+1][y]=false;
            if (bt(board,word.substring(1,word.length()),available,x+1,y)){
                return true;
            }
            available[x+1][y]=true;

        }

        if (y-1>=0 && board[x][y-1]==word.charAt(0) && available[x][y-1]){ //左
            available[x][y-1]=false;
            if (bt(board,word.substring(1,word.length()),available,x,y-1)){
                return true;
            }
            available[x][y-1]=true;

        }

        if (y+1<=board[0].length-1 && board[x][y+1]==word.charAt(0) && available[x][y+1]){ //右
            available[x][y+1]=false;
            if (bt(board,word.substring(1,word.length()),available,x,y+1)){
                return true;
            }
            available[x][y+1]=true;

        }



        return false;

    }



    public static void main(String[] args){

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCEDG";
        boolean b=exist(board, word);
        System.out.println(b);


    }
}


