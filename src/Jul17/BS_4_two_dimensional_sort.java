package Jul17;

public class BS_4_two_dimensional_sort {

    public static boolean findNumberIn2DArray(int[][] m, int target) {

        if ( m.length==0|| m[0].length==0|| m[0][0]>target || m[m.length-1][m[0].length-1]<target ){
            return false;
        }

        int l=m.length-1;
        int c=0;


        //主要思路就是就是末尾行的最左边元素，因为它可以排除掉一整行元素，从此元素往右上走
        while (l>0 && c < m[0].length-1) {

                if(m[l][c] == target){
                    return true;
                }else if (m[l][c] < target){
                    c++;
                }else {
                    l--;
                }

            }


        if (l==0){
            for(int j=c;j<m[0].length;j++){
                if (m[0][j]==target) {
                    return true;
                }
            }
        }else if(c==m[0].length-1){
            for (int i=0;i<=l;i++){
                if (m[i][m[0].length-1]==target){
                    return true;
                }
            }
        }

        return false;


    }



    public static void main(String[] args) {

//        int[][] m = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] m={{1},{1}};

        int[][] m= {{3,5,9,9,14},{7,8,11,15,15},{8,10,16,16,17}};
        int t = 12;
        boolean b = findNumberIn2DArray(m, t);
        System.out.println(b);

    }


}
