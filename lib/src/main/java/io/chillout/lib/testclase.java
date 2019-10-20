package io.chillout.lib;



public class testclase implements Runnable {


    public static void main(String[] args) {
        Thread thread = new Thread(new testclase());
        thread.start();
    }

    @Override
    public void run() {
        for (int i=0; i<20 ; i++){
            System.err.println("Thread executed , Thread ID "+ Thread.currentThread().getId() + "\n");
            System.out.println("Therad State is "+Thread.currentThread().getState() + "\n");
            try {
                System.out.println("Waiting for user  .... 2 sec...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}