class Foo {

    private int turn ;
    public Foo() {
        turn = 0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        turn = 1;
        notifyAll();

    }

    public synchronized  void second(Runnable printSecond) throws InterruptedException {
        

        while(turn !=1){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        turn = 2;
        notifyAll();
    }

    public synchronized  void third(Runnable printThird) throws InterruptedException {
        
        while(turn != 2){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();


    }
}