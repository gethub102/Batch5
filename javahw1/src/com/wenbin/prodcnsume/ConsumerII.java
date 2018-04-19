package com.wenbin.prodcnsume;

public class ConsumerII implements Runnable {


    QII qii = new QII(0);

    public ConsumerII(QII qii) {
        this.qii = qii;
        new Thread(this, "Consumer").start();
    }

    public QII getQii() {
        return qii;
    }

    public void setQii(QII qii) {
        this.qii = qii;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            qii.getN();
        }
    }
}
