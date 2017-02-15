import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rankTag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rankTag extends Actor
{
    /**
     * Act - do whatever the rankTag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public rankTag(String str) {
        GreenfootImage image = getImage() ;
        image.scale( 180, 180 );
        image.setColor(java.awt.Color.BLACK);
        image.drawString(str, 0, 70); 
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
