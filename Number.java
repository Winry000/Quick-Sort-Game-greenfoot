import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Number here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number extends Actor
{
    /**
     * Act - do whatever the Number wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Number()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 40 ) ; 
    }
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    public int[] pickRandomNum(int n) {
        int[] list = new int[n];
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (n)) + 1;
            while (set.contains(num)) {
                num = (int) (Math.random() * (n)) + 1;
            }
            set.add(num);
            list[i] = num;
        }
        return list;
    }  
}
