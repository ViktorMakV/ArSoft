package com.service.calcualtion;

/**
 * @author Viktor Makarov
 */
public enum Part {
    DEBIT {
        public long action (long a, long b) {
            return a + b;
        }
    } ,
    CREDIT {
        public long action (long a, long b) {
            return a - b;
        }
    } ,
    DEFAULT {
        public long action (long a, long b) {
            return a;
        }
    };

    public abstract long action (long a, long b);
}
