import java.util.Vector;
import java.util.concurrent.TimeUnit;

import concurrent.Drawer;
import concurrent.Player;
import concurrent.Screen;
import concurrent.Semaphore;

/**
 * Example
 */
public class Example extends Thread {

    private Vector<Player> players = new Vector<>();

    public Example(){
        Screen screen = new Screen();
        Semaphore M = new Semaphore("M",1);
        Semaphore F = new Semaphore("F",0);
        
        int winner = 0;
        Drawer drawer = new Drawer(screen,M,F);
        Player player = new Player(screen,winner,M,F);
        Player player2 = new Player(screen,winner,M,F);
        players.add(player);
        players.add(player2);
        drawer.start();
        player.start();
    }

    @Override
    public void run() {
        int currentHighScore = 0;
        while(true){
            try{

                TimeUnit.SECONDS.sleep(3);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            for (int i = 0; i < players.size(); i++) {
                if(players.get(i).getScore() > currentHighScore){
                    currentHighScore = players.get(i).getScore();
                }
                System.out.println("The current high score is : "+currentHighScore);
                System.out.println("The current winner is : "+players.get(i).getName());
            }
        }
    }

    public static void main(String[] args) {
        new Example().start();
    }
}