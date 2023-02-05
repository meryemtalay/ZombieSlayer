/*
* Zombie Slayer
Learning Objectives
Concurrency
Introduction
You along, with a few of your friends, are cleaning out a zombie invasion.  You only have one weapon though.

After analyzing the situation, you have come up with an amazing plan.

You want to secure a large room that has multiple doors to the street. Zombies move slowly, so it’s easy to control them in general.
Each of your friends controls one door.  They let in individual zombies, keeping count of how many have entered.
You stand in the center and eliminate the zombies that have entered as fast as you can, keeping track of how many you have removed.

You don’t want too many zombies in the room for obvious reasons.  You die if there are more than 100 zombies in the room at any point in time.
You are safe if you can kill 100 zombies before getting killed. The only way to achieve this goal is to find a room with just enough doors to the street.

The objective of this project is to write code to find the maximum number of doors (door men) that would allow you to kill 100 zombies before you get killed.
* */

public class Slayer extends Thread{
    ZombieCounter zc;
    /*
    * The Slayer kills a zombie every 2ms (but he/she has to check first to see if there is a zombie)
    * keeping track of the number of zombies killed (by calling the corresponding method from the ZombieCounter object).
    * The Slayer thread terminates if  there are too many zombies (more than 100 zombies) in the room at any time or if he/she has killed more than 100 zombies.
    * */
    public Slayer(ZombieCounter zc)
    {
        this.zc=zc;
    }
    @Override
    public void run(){
        while(!zc.tooManyZombiesInTheRoom() &&!zc.killed100Zombies())
        {

            zc.zombieKilled();
            try{//every 2
                Thread.sleep(2);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}