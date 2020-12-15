package thread.test;

import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int curNum=1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(curNum<=n){
            if(curNum%3!=0 || curNum%5==0){
                wait();
                continue;
            }
            printFizz.run();
            curNum++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(curNum<=n){
            if(curNum%5!=0 || curNum%3==0){
                wait();
                continue;
            }
            printBuzz.run();
            curNum++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(curNum<=n){
            if(curNum%15 != 0){
                wait();
                continue;
            }
            printFizzBuzz.run();
            curNum++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(curNum<=n){
            if(curNum%3==0 || curNum%5==0){
                wait();
                continue;
            }
            printNumber.accept(curNum);
            curNum++;
            notifyAll();
        }
    }
}