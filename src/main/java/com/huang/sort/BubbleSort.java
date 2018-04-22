package com.huang.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by h on 2018/3/24.
 */
@Slf4j
public class BubbleSort {
    public static void sort(int[] mess) {
        int length = mess.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (mess[j] > mess[j + 1]) {
                    int temp = mess[j];
                    mess[j] = mess[j + 1];
                    mess[j + 1] = temp;
                }
            }
        }
    }

    public static void sortX(int[] mess) {
        int length = mess.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i -1; j++) {
                if (mess[j] > mess[j + 1]) {
                    int temp = mess[j];
                    mess[j] = mess[j + 1];
                    mess[j + 1] = temp;
                }
            }
        }
    }
}
