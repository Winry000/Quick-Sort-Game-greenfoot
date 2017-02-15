import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class NameText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameText extends Actor
{
    /**
     * Act - do whatever the NameText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static final int MAX_INPUT_LENGTH = 20;
    String text = "Enter Your Name";
     
    public NameText()
    {
        updateImage();
        text = "";
    }
     
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(15*MAX_INPUT_LENGTH, 30);
        image.setColor(new Color(128, 0, 0));
        image.fill();
        image.setColor(Color.lightGray);
        image.fillRect(3, 3, image.getWidth()-6, 24);
        GreenfootImage textImage = new GreenfootImage(text, 24, Color.black, null);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, 15-textImage.getHeight()/2);
        setImage(image);
    }
 
    public void act()
    {
        QuickSortWorld world = (QuickSortWorld)this.getWorld();
        String key = Greenfoot.getKey();
        if (key == null) return;
        if ("enter".equals(key) && text.length() > 0)
        {
            System.out.println("Entered Your Name "+text);
            text = "";
            updateImage();
            return;
        }
        if ("backspace".equals(key) && text.length() > 0) text = text.substring(0, text.length() - 1);
        if ("escape".equals(key)) text = "";
        if ("space".equals(key)) key = " ";
        if (key.length() == 1 && text.length() < MAX_INPUT_LENGTH) text += key;
        updateImage();
        world.setPlayerName(text);
        
    }
}
