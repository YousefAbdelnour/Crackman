import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Ghost2 extends Ghosts
{
    public GifImage Ghost1 =  new  GifImage("Ghost2Gif.gif");
int speed = Level.speed;


    /**
     * Act - do whatever the Ghost2 wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (!(win())){
            mouvement();
        }
        setImage(Ghost1.getCurrentImage());
    }

    /**
     * 
     */
    public void mouvement()
    {

        if(getWall () == false){
            move(3);
        } else {
            int rand = Greenfoot.getRandomNumber(4);
            move(-3);
            if (rand == 0){
                turn(90);
            }
            else if (rand == 1){
                turn(-90);
            }
            else {
                turn(180);
            }
        }
       
    }

    public boolean win(){
        boolean win = false;
        Actor cracked = getOneIntersectingObject(CrackMan.class);
        if (cracked != null){
            win = true;
        }
        return win;
    }

    private boolean getWall(){
        int distance = 50/2;
        int xOffset = (int) Math.ceil(distance * Math.cos(Math.toRadians(getRotation())));
        int yOffset = (int) Math.ceil(distance * Math.sin(Math.toRadians(getRotation())));
        Actor wall = getOneObjectAtOffset(xOffset, yOffset, Wall2.class );
        Actor wallV2 = getOneObjectAtOffset(xOffset, yOffset, Wall.class );
        Actor wallH = getOneObjectAtOffset(xOffset, yOffset, WallHorizontal.class );
        Actor wallH2 = getOneObjectAtOffset(xOffset, yOffset, WallHorizontal2.class );
        Actor wallD = getOneObjectAtOffset(xOffset, yOffset, Wall_Down.class );
        Actor wallL = getOneObjectAtOffset(xOffset, yOffset, Wall_Left.class );
        Actor wallR = getOneObjectAtOffset(xOffset, yOffset, Wall_Right.class );
        Actor wallU = getOneObjectAtOffset(xOffset, yOffset, Wall_Up.class );
        return (wall!=null) || (wallV2!=null) ||(wallH!=null) || (wallH2!=null) || (wallD!=null) || (wallR!=null) || (wallL!=null) || (wallU!=null); 
    }
}
