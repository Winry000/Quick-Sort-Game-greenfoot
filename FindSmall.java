import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class PartitionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindSmall extends StepButton
{
    /**
     * Act - do whatever the PartitionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public FindSmall()
    {
        GreenfootImage image = getImage() ;
        image.scale( 250, 80 ) ; 
    }
    public void act() 
    {
        // Add your action code here.
        GameStateManager gm = GameStateManager.getInstance();
        GameStates gs = gm.getGameCurrentState();
        if (gs == GameStates.PivotInit && Greenfoot.mousePressed(this)) {
            this.findSmall();
            gm.doClickShortMinion();
            gm.showGameCurrentState();
        }
        else if (gs == GameStates.EndTallMinion && Greenfoot.mousePressed(this)) {
            this.findSmall();
            gm.doClickShortMinion();
            gm.showGameCurrentState();
        }
        else {
            ;
        }
    }
    private void findSmall() {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        List<MinionShort> minionShort = world.getObjects(MinionShort.class);
        List<MinionTall> minionTall = world.getObjects(MinionTall.class);
        int end = world.getEndIndex();
        int pivot = world.getPivot();
        int[] list = world.list;
        int length = list.length;
        int shortIndex = minionShort.get(0).getIndex();
        int tallIndex = minionTall.get(0).getIndex();
        while (shortIndex <= tallIndex && (shortIndex < length - 1) && list[shortIndex] < pivot) {
            int location = minionShort.get(0).getLocationX();
            System.out.println("new Location: " + location);
            location += 50;
            System.out.println("new Location: " + location);
            minionShort.get(0).moveTo(location);
            minionShort.get(0).setLocationX(location);
            shortIndex++;
            minionShort.get(0).setIndex(shortIndex);
            Greenfoot.delay(10);
        }
    }
    
}
