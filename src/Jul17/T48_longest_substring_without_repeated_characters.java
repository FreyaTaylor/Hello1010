package Jul17;

import java.util.ArrayList;
import java.util.*;

/***
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcofp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class T48_longest_substring_without_repeated_characters {



    //去掉了输出语句，时间就不超限制了
    static int lengthOfLongestSubstring(String s) {
        if (s.length()==1){
            return 1;
        }
        Map<Character, Integer> pls = new LinkedHashMap<>();//present longest substring
        int longest=0;
//        int start = 0;

        for (int i = 0; i < s.length(); i++) {
//            System.out.println("**************" + i);
            char c = s.charAt(i);

            if (pls.containsKey(c)) {

                int lastcharAt = pls.get(c);
                if (pls.size() > longest) {
                    longest=pls.size();
                }

                //因为最终的长度结果是用map来计算的，因此需要动态维护map,因此耗费了较大的时间虽然remove操做总体上加起来只会操做n次，但是在提交复杂度排名上表现较差

                //热评动规思路：
                // dp[j - 1] <j−i ，说明字符 s[i]s[i] 在子字符串 dp[j-1] 区间之外 ，则 dp[j] = dp[j - 1] + 1dp[j]=dp[j−1]+1 ；
                // dp[j - 1] >j-i ，说明字符 s[i]s[i] 在子字符串 dp[j-1]dp[j−1] 区间之中 ，则 dp[j]dp[j] 的左边界由 s[i]s[i] 决定，即 dp[j] = j - idp[j]=j−i ；
                //热评解题值得学习的一点是利用了map计算相同数组O(1)的时间复杂度，但是每次计算字串长度并不采用map,而是动态改变左指针i，直接（j-i）就是当前长度了，因此不用维护map


                Iterator<Map.Entry<Character, Integer>> it = pls.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<Character, Integer> entry = it.next();
                    if(entry.getValue() <lastcharAt) {
                        it.remove();//使用迭代器的remove()方法删除元素
                    }else if (entry.getValue() ==lastcharAt){//这里要注意，当==lastcharAt,要break，不然会超时间
                        it.remove();
                        break;
                    }
                }

            }
            pls.put(c, i);
//            System.out.println(pls);

        }

        if (pls.size() > longest) {//跳出之后也要检查一遍，不然就不更新
            longest=pls.size();
        }
        return longest;
    }



    public static void main(String[] args) {
//        String s = "pwwkemwnevk";
//        String s = "abcabcbb";
//        String s=" ";
//        String s="aab";
        String s="pwcawkew";
        int l = lengthOfLongestSubstring(s);
        System.out.println(l);

    }

}

