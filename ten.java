import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ten extends Number
{
    /**
     * Act - do whatever the ten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ten()
    {
        GreenfootImage image = getImage() ;
        image.scale( 80, 80 ) ; 
    }
    public void act() 
    {
        GameStateManager gm = GameStateManager.getInstance();
        GameStates gs = gm.getGameCurrentState();
        if (gs == GameStates.BeforeStart && Greenfoot.mousePressed(this)) {
             QuickSortWorld world = (QuickSortWorld)this.getWorld();
            world.setNumber(10);
            this.ten();
            gm.doClickNumber();
            world.setTimeBegan(System.currentTimeMillis());
        } // Add your action code here.
    }    
    public void ten() {
         Number a = new Number();
         int[] list = a.pickRandomNum(10);
         QuickSortWorld world = (QuickSortWorld)this.getWorld();
         List<NumberTag> num = world.getObjects(NumberTag.class);
         for (NumberTag j: num) {
              world.removeObject(j);
            }
             List<MinionShort> small = world.getObjects(MinionShort.class);
         for (MinionShort i: small) {
              world.removeObject(i);
            }
         List<MinionTall> big = world.getObjects(MinionTall.class);
         for (MinionTall i: big) {
              world.removeObject(i);
            }
         List<Pivot> p = world.getObjects(Pivot.class);
         for (Pivot i: p) {
              world.removeObject(i);
            }
         world.drawList(list);
         //world.drawList(list);
    }   
}
