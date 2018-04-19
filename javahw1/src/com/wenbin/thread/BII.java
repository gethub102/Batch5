package com.wenbin.thread;

import com.wenbin.rjt.AII;

public class BII extends AII {

    public static void main(String[] args) {
        AII aii = new AII();
        BII bii = new BII();

        AII aii1 = new BII();
        System.out.println(bii.a);
    }

    public BII() {
    }

    public BII(int a) {
        super(a);
    }
}
