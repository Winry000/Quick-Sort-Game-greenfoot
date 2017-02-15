import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuickSortWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int numTagHeight = 50;
    public int numTagWidth = 50;
    int startX = 0;
    int endX = 0;
    int startIndex = 0;
    int endIndex = 0;
    int pivot = 0;
    int pivotIndex = 0;
    int pivotX = 0;
    long timeBegan = 0;
    int number = 0;
    String palyername = "";
    String res = "";
    // GameStateManager gameStateManager = null;
    public int[] list;
    public Stack<Integer> stack = new Stack();
    public QuickSortWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        // this.gameStateManager = new GameStateManager();
        prepare();
    }
    private void prepare() {
        addObject(new Number(), 80, 500);
        
        
        addObject(new five(), 200, 550);
        addObject(new eight(), 300, 550);
        addObject(new ten(), 400, 550);
        
        addObject(new toprank(), 650,50);
        addObject(new SetPivotButton(), 650, 240);
        addObject(new FindSmall(), 650, 320);
        addObject(new FindBig(), 650, 400);
        addObject(new Swap(), 650, 480);
        addObject(new Done(), 650, 560);
        addObject(new Submit(), 50,50);
        addObject(new NameText(), 300,50);
        GameStateManager gm = GameStateManager.getInstance();
        gm.reset();
    }
    public String getFinalResult() {
        return res;
    }
    public void setFinalResult(String x) {
        res = x;
    }
    public String getPlayerName() {
        return palyername;
    }
    public void setPlayerName(String text) {
        palyername = text;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int x) {
        number = x;
    }
    public long getTimeBegan(){
        return timeBegan;
    }
    public void setTimeBegan(long x) {
        timeBegan = x;
    }
    public int getStartX() {
        return startX;
    }
    public int getEndX() {
        return endX;
    }
    public int getStartIndex() {
        return startIndex;
    }
    public int getEndIndex() {
        return endIndex;
    }
    public int getPivot() {
        return pivot;
    }
    public int getPivotIndex() {
        return pivotIndex;
    }
    public int getPivotX() {
        return pivotX;
    }
    // public GameStateManager getGameStateManager()
    // {
    //    return this.gameStateManager;
    // }
    public void setStartX(int x) {
        startX = 70 + x * numTagWidth;
    }
    public void setEndX(int x) {
        endX = 70 + x * numTagWidth;
    }
    public void setStartIndex(int x) {
        startIndex = x;
    }
    public void setEndIndex(int x) {
        endIndex = x;
    }
    public void setPivot() {
        pivot = list[pivotIndex];
    }
    public void setPivotIndex() {
        pivotIndex = endIndex;
    }
    public void setPivotX() {
        pivotX = startX + (endIndex - startIndex) * numTagWidth;
    }
    public void drawList(int[] list) {
        this.list = list;
        int size = list.length;
        startX = 70;//400 - size / 2 * numTagWidth;
        endX = startX + (size - 1)*numTagWidth; //(size - 1) * numTagWidth + startX;
        startIndex = 0;
        endIndex = size - 1;
        setPivotIndex();
        setPivot();
        setPivotX();
        
        MinionShort minionShort = new MinionShort();
        addObject(minionShort, startX, 200);
        minionShort.setLocationX(startX);
        minionShort.setIndex(startIndex);
        System.out.println("ShortLocation: " + startX);
  
        MinionTall minionTall = new MinionTall();
        addObject(minionTall, endX, 200);
        minionTall.setLocationX(endX);
        minionTall.setIndex(endIndex);
        
        int start = startX;
        for (int i = 0; i < size; i++) {
            System.out.println("1:"+ start);
            addObject(new NumberTag(String.valueOf(list[i])), start + 40, 200);
            start += numTagWidth;
        }
    }
    
    public void updateList() {
         List<NumberTag> num = getObjects(NumberTag.class);
         for (NumberTag j: num) {
              removeObject(j);
            }
        int start = 70;
        for (int i = 0; i < list.length; i++) {
            System.out.println("2:" + start);
            addObject(new NumberTag(String.valueOf(list[i])), start + 40, 200);
            start += numTagWidth;
        }
    }
    
    public void drawRank(String[] toprank) { 
        int start = 80;
         for (int i = 0; i < toprank.length; i++) {
            addObject(new rankTag(toprank[i]), 650, start + 30);
            start += 20;
        }
    }
}
