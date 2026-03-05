class DiningPhilosophers {
    // to lock fork
    private final Semaphore[] fork = new Semaphore[5];
    // to lock order
    private Lock lock  = new ReentrantLock();

    public DiningPhilosophers() {

        for (int i = 0; i < 5; i++) {

            fork[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int rightFork = philosopher;
        int leftFork = (philosopher + 1) % 5;

        lock.lock();

        try {

            fork[leftFork].acquire();
            pickLeftFork.run();

            fork[rightFork].acquire();
            pickRightFork.run();

            // both forks are taken, can eat
            eat.run();

            // put fork back
            putLeftFork.run();
            fork[leftFork].release();

            // put fork back
            putRightFork.run();
            fork[rightFork].release();

        } finally {
            lock.unlock();
        }
    }
}