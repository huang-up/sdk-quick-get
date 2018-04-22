package com.huang.sort;

/**
 * Created by h on 2018/3/24.
 */
public class QuickSort {
    public static void sort(int[] mess, int start, int end) {
        // 终止条件
        if (start < end) {
            int baseNum = mess[start];  //选基准值
            int midNum; //记录中间值
            int i = start;
            int j = end;
            do {
                while (mess[i] < baseNum && i < end) {
                    i++;    // 遇到一个大于baseNum的为止
                }

                while (mess[j] > baseNum && j > start) {
                    j--;    // 遇到一个小于baseNum的为止
                }

                if (i <= j) {   // 大于和小于的进行交换
                    midNum = mess[i];
                    mess[i]= mess[j];
                    mess[j] = midNum;
                    i++;
                    j--;    // 一直向i <= j 逼近
                }

            } while (i <= j);

            if(start < j){
                sort(mess, start, j);
            }
            if(end > i){
                sort(mess, i, end);
            }
        }
    }
}
