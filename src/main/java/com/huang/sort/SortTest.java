package com.huang.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by h on 2018/3/24.
 */
@Slf4j
public class SortTest {
    private int[] mess = new int[]{10, 1, 20, 3, 5, 99, 7, 10};
    @Test
    public void insert() {
        InsertSort.sort(mess);
        log.info(Arrays.toString(mess));
    }

    @Test
    public void bubble() {
        BubbleSort.sort(mess);
        log.info(Arrays.toString(mess));
    }

    @Test
    public void bubbleX() {
        BubbleSort.sortX(mess);
        log.info(Arrays.toString(mess));
    }

    @Test
    public void quick() {
        QuickSort.sort(mess, 0, mess.length - 1);
        log.info(Arrays.toString(mess));
    }
}
