package com.huang.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by h on 2018/3/24.
 */
public class InsertSort {

    public static void sort(int[] mess) {
        int length = mess.length;   // 单独把数组长度拿出来，提高效率
        int insertNum;  // 要插入的数
        for (int i = 1; i < length; i++) {  // 因为第一次不用，所以从1开始
            insertNum = mess[i];    // 已排好序的下一个元素
            int j = i - 1 ; // 已排好序的最大下标，对应 mess[j] 是已排好序的最后一个元素
            while(j > 0 && mess[j] > insertNum) {
                mess[j + 1] = mess[j];    // 从后向前循环，将大于insertNum的数向后移动
                j--;
            }
            mess[j] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] mess = new int[]{10, 1, 20, 3, 5, 99};
        InsertSort.sort(mess);
    }
}
