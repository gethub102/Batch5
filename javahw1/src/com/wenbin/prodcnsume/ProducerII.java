package com.wenbin.prodcnsume;

public class ProducerII implements Runnable {
    QII qii = new QII(0);

    public ProducerII(QII qii) {
        this.qii = qii;
        new Thread(this, "Producer").start();
    }

    public QII getQii() {
        return qii;
    }

    public void setQii(QII qii) {
        this.qii = qii;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            qii.setN(i++);
        }
    }

    public static void main(String[] args) {
        QII qii = new QII(0);
        ProducerII producerII = new ProducerII(qii);
        ConsumerII consumerII = new ConsumerII(qii);
    }
}
