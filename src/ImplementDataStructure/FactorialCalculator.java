package ImplementDataStructure;

public class FactorialCalculator implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread id = " + Thread.currentThread().getId() +
                " Name "  + Thread.currentThread().getName() +
              " Thread Priority = " +   Thread.currentThread().getPriority());
    }
}
