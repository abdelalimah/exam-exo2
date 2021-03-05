package concurrent;

import java.util.LinkedList;

public class Semaphore {

    private int value = 1;
    private LinkedList<Thread> waitingList;
    private String name;

    public Semaphore(String name) {
        init(1); // mutual exclusion semaphore
        this.name = name;
    }

    public Semaphore(String name,int value) {
        init(value);
        this.name = name;
    }

    synchronized public void init(int value){
        this.value = value;
        waitingList = new LinkedList<>();
    }

    synchronized public void waitDijkstra(){ // lock
        value--;
        if(value < 0) {
            suspend();
        };
    }

    synchronized public void signalDijkstra(){ // unlock
        System.out.println();
        value++;
        if(value <= 0) resume();
    }

    synchronized public void suspend(){
        waitingList.add(Thread.currentThread());
        message("blocking");
        try{
            wait();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        waitingList.remove(Thread.currentThread());
        message("Waking up");

    }

    synchronized public void resume(){
        message("Asking for waking up blocked process");
        notify();
    }

    public void message(String message){
        System.out.println("++ "+Thread.currentThread().getName() + " : "+message+ " => "+ name + " = " +waitingList);
    }

    public String getName() {
        return name;
    }
}
