import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Windows extends Actor
{
    private int offsetX = 5;
    private int offsetY = 5;
    private static int nextOffset = 5;
    
    public Windows(){
        offsetX = nextOffset;
        offsetY = nextOffset;
        
        nextOffset += 3;
    }
    
    public void act()
    {
        int x = getX();
        int y = getY();
        
        setLocation(x + offsetX, y + offsetY);
        
        if(getY() >= 380 || getY() <= 0){
            offsetY *= -1;
        }
        if(getX() >= 575 || getX() <= 0){
            offsetX *= -1;
        }
        
        Linux linux = (Linux)getOneIntersectingObject(Linux.class);
        
        Bomb bomb = new Bomb();
        
        if(linux != null){
            offsetX = 0;
            offsetY = 0;
            
            World world = getWorld();
            world.removeObject(linux);
            
            world.addObject(bomb, getX(),getY());
            
            world.removeObject(this);
        }
    }
}
