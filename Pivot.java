import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pivot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pivot extends Minions
{
    /**
     * Act - do whatever the Pivot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void moveTo(int x) {
        this.setLocation(x, 250);
    }
    
    public Pivot()
    {
        GreenfootImage image = getImage() ;
        image.scale( 30, 30 ) ; 
    }

    public void act() 
    {
        // Add your action code here.
    }  
    
}
