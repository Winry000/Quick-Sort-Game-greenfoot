import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Minions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minions extends Actor
{
    /**
     * Act - do whatever the Minions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int index;
    private int location;
    private int y = 200;
    public int getIndex() {
        return index;
    }
    public void setIndex(int x) {
        this.index = x;
    }
    public int getLocationX() {
        return location;
    }
    public void setLocationX(int x) {
        this.location = x;
    }
    public void moveTo(int x) {
        this.setLocation(x, y);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
