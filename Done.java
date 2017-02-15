import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Done here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Done extends StepButton
{
    private boolean finishFlag;
    /**
     * Act - do whatever the Done wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Done()
    {
        GreenfootImage image = getImage() ;
        image.scale( 250, 80 ) ; 
        this.finishFlag = false;
    }
    public void act() 
    {
        // Add your action code here.
        GameStateManager gm = GameStateManager.getInstance();
        GameStates gs = gm.getGameCurrentState();
        if (gs == GameStates.BeforeSwap && meet() == true && Greenfoot.mousePressed(this)) {
            this.doneFunction();
            gm.doClickDone();
            gm.showGameCurrentState();
            if (isStackEmpty() == false) {
                gm.doGotoInitArray();
                gm.showGameCurrentState();
            }
            else if (this.finishFlag == true && isStackEmpty() == true) {
                System.out.println("********QuickSort Finish*********");
                gm.showGameCurrentState();
            }
            else {               
                gm.doGotoInitArray();
                gm.showGameCurrentState();
            }
        }
    }    
    private void doneFunction() {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        List<MinionShort> minionShort = world.getObjects(MinionShort.class);
        List<MinionTall> minionTall = world.getObjects(MinionTall.class);
        List<Pivot> pivot = world.getObjects(Pivot.class);
        int pivotX = world.getPivotX();
        int pivotIndex = world.getPivotIndex();
        int shortIndex = minionShort.get(0).getIndex();
        int shortX = minionShort.get(0).getLocationX();
        int[] list =  world.list;
        int tmp = list[pivotIndex];
        list[pivotIndex] = list[shortIndex];
        list[shortIndex] = tmp;
        world.updateList();
        pivot.get(0).moveTo(shortX);
        minionShort.get(0).moveTo(pivotX);
        Greenfoot.delay(20);
        Stack<Integer> stack = world.stack;
        if (shortIndex - 1 > world.getStartIndex()) {
            stack.push(world.getStartIndex());
            stack.push(shortIndex - 1);
        }
        if (shortIndex + 1 < world.getEndIndex()) {
            stack.push(shortIndex + 1);
            stack.push(world.getEndIndex());
        }
        if (stack.isEmpty()) {
            System.out.println("********done*********");
            this.finishFlag = true;
            if (isStackEmpty() == true) {
                System.out.println("World Stack is Empty!");
            }
            else {
                System.out.println("World Stack isn't Empty!");
            }
            return;
        }
        int rightIndex = stack.pop();
        int leftIndex = stack.pop();
        world.setStartIndex(leftIndex);
        world.setEndIndex(rightIndex);
        world.setStartX(leftIndex);
        world.setEndX(rightIndex);
        minionShort.get(0).moveTo(world.getStartX());
        minionTall.get(0).moveTo(world.getEndX());
        minionShort.get(0).setIndex(world.getStartIndex());
        minionTall.get(0).setIndex(world.getEndIndex());
        minionShort.get(0).setLocationX(world.getStartX());
        minionTall.get(0).setLocationX(world.getEndX());
    }
    private boolean meet() {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        List<MinionShort> mshort = world.getObjects(MinionShort.class);
        List<MinionTall> mtall = world.getObjects(MinionTall.class);
        if (mtall.size() != 0) {
            int right = mtall.get(0).getIndex();
            int left = mshort.get(0).getIndex();
            if (left >= right) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    private boolean isStackEmpty() {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        Stack<Integer> stack = world.stack;
        if (stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
