package org.ike.ebbinghaus;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author: ike
 * @Date: 2019-02-20 09:15
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        log.info("add   : {}+{}={}", 100, 100, add(100, 100));
        log.info("minus : {}-{}={}", 100, 1, minus(100, 1));
        log.info("multi : {}*{}={}", 20, 5, multi(20, 5));
        log.info("sub   : {}/{}={}", 4, 2, sub(4, 2));
        long start = new Date().getTime();
//        log.info("tailfib({}): {}",45, tailfib(45, 1, 1));
        log.info("tailfac({}): {}",10, tailfac(10, 1));
//        log.info("fib({}): {}",45,fib(45));
        long end = new Date().getTime();
        log.info("use time: {}", end - start);
    }

    public static int add(int x, int y) {
        int res;
        int xor = x ^ y;
        int forward = (x & y) << 1;
        if (forward != 0) {
            res = add(xor, forward);
        } else {
            res = xor;
        }
        return res;
    }

    public static int minus(int x, int y) {
        int sub = ~(y - 1);
        return add(x, sub);
    }

    public static int multi(int x, int y) {
        int res=0;
        int i=0;
        while (y != 0) {
            if ((y & 1) == 1) {
                res += x << i;
                y = y >> 1;
                ++i;
            } else {
                y = y >> 1;
                ++i;
            }
        }
        return res;
    }

    public static int sub(int x, int y) {
        int res = -1;
        if (x < y) {
            return 0;
        } else {
            res = sub(minus(x, y), y) + 1;
        }
        return res;
    }

    /** 尾递归 */
    public static int tailfib(int n, int var1, int var2) {
        if (n < 2) {
            return var1;
        }
        return tailfib(n - 1, var2, var1 + var2);
    }

    public static int tailfac(int n, int sum) {
        if (n == 1) {
            return sum;
        }
        return tailfac(n - 1, n * sum);
    }

    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
