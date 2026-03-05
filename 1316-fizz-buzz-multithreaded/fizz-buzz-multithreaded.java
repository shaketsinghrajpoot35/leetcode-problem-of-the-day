class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        
        while(i<=n){

            while(i<=n && !(i%3 ==0 &&i%5 !=0)){
                wait();
            }

            if(i<=n){
               printFizz.run();
               i++;
            }

            notifyAll();

        }

    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        
        while(i<=n){

            while(i<=n && !(i%3 !=0 &&i%5 ==0)){
                wait();
            }

            if(i<=n){
               printBuzz.run();
               i++;
            }

            notifyAll();

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i<=n){

            while(i<=n && !(i%3 ==0 &&i%5 ==0)){
                wait();
            }

            if(i<=n){
                printFizzBuzz.run();
                i++;
            }
            notifyAll();

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(i<=n){

            while(i<=n && !(i%3 !=0 &&i%5 !=0)){
                wait();
            }

           if(i<=n){
               printNumber.accept(i);
               i++;
           }

            notifyAll();

        }
    }
}