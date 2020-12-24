package flappy;

import java.awt.*;

public class Bird {


    private int flappyHeight = Constants.HEIGHT / 4;
    private int flappyVelocity = 0;
    private int flappyAcceleration = 8;
    private int flappyImpose = 1;

    public static final int BIRDSIZE = 25;

    public int getFlappyHeight() {
        return flappyHeight;
    }

    public void setFlappyHeight(int flappyHeight) {
        this.flappyHeight = flappyHeight;
    }

    public int getFlappyVelocity() {
        return flappyVelocity;
    }

    public void setFlappyVelocity(int flappyVelocity) {
        this.flappyVelocity = flappyVelocity;
    }

    public int getFlappyAcceleration() {
        return flappyAcceleration;
    }

    public void setFlappyAcceleration(int flappyAcceleration) {
        this.flappyAcceleration = flappyAcceleration;
    }

    public int getFlappyImpose() {
        return flappyImpose;
    }

    public void setFlappyImpose(int flappyImpose) {
        this.flappyImpose = flappyImpose;
    }

    public void drawFlappy(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(75, flappyHeight + flappyVelocity, BIRDSIZE, BIRDSIZE);
    }

    public void flappyFall()
    {
        flappyAcceleration += flappyImpose;
        flappyVelocity += flappyAcceleration;
    }

    public void flappyFly()
    {
        flappyAcceleration = -10;
    }

    public void reset()
    {
        flappyHeight = Constants.HEIGHT / 4;
        flappyVelocity = 0;
        flappyAcceleration = 8;
    }
}
