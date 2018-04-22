package com;

import com.huang.concurrent.lock.ILock;
import com.huang.concurrent.lock.NoReentrantLock;
import com.huang.concurrent.lock.YesReentrantLock;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by h on 2018/4/14.
 */
public class Print {
    @Test
    public void t1() {
        PrintStream ps = new PrintStream(System.out);
        Object obj = null;
        ps.print(obj.hashCode());
    }

    @Test
    public void t2() {
        List<String> list = new ArrayList<String>(){{
            add("1");add("2");add("3");add("4");
        }};
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals("2")) {
                list.remove(i);
                i--;
                size--;
            }
        }

        System.out.println(list);

      /*  list.forEach(s -> {
            if ("1".equals(s)) {
                list.remove(s);
            }
        });*/

        /*Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if ("1".equals(str)) {
                it.remove();
            }
        }*/
    }

    @Test
    public void t3() {
        T t = new T(new NoReentrantLock());
        t.print();
    }

    @Test
    public void t4() {
        T t = new T(new YesReentrantLock());
        t.print();
    }
}

class T {
    private ILock lock;
    public T(ILock lock) {
        this.lock = lock;
    }
    public void print() {
        lock.lock();
        System.out.println("print");
        add();
        lock.unlock();
    }

    public void add() {
        lock.lock();
        System.out.println("add");
        lock.unlock();
    }


}
