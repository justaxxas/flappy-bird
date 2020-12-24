package flappy;

import com.sun.org.apache.bcel.internal.Const;

import java.awt.*;

public class Wall {

    private int velocity = 5;
    private int x_position;
    private int gap_position;

    public Wall(int x_position, int gap_position)
    {
        this.x_position = x_position;
        this.gap_position = gap_position;
    }

    public int getX_position() {
        return x_position;
    }

    public void setX_position(int x_position)
    {
        this.x_position = x_position;
    }

    public int getGap_position()
    {
        return gap_position;
    }

    public void setGap_position(int gap_position)
    {
        this.gap_position = gap_position;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity)
    {
        this.velocity = velocity;
    }

    public void drawWall(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x_position, 0, Constants.WALLWIDTH, Constants.HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(x_position, gap_position, Constants.WALLWIDTH, 100);
    }

    public void move()
    {
        x_position -= velocity;
    }

    public void reset()
    {
        x_position = Constants.WIDTH;
        gap_position = (int)(Math.random() * (Constants.HEIGHT-150));
    }

}
