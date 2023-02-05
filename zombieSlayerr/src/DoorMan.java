/*
* Each DoorMan thread lets in a zombie with a 50% chance every 2ms, keeping track of the number of zombies admitted (by calling the corresponding method from the ZombieCounter).
* The DoorMan thread terminates if there are too many zombies (more than 100 zombies) in the room at any time or if the Slayer has killed more than 100 zombies.
 * */
public class DoorMan extends Thread{

    ZombieCounter zc;
    public DoorMan(ZombieCounter zombieCounter) {
        this.zc = zombieCounter;
    }


    public void run()
    {
        while(!zc.tooManyZombiesInTheRoom() && !zc.killed100Zombies())
        {
            double r= Math.random();//0-1
            if(r< 0.5)
            {
                /*50% chance every 2ms*/
                zc.zombieEntered();
            }
            try{//every 2
                Thread.sleep(2);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}