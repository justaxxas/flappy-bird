package flappy;

public class Collision {
    public static boolean collides_edges(Bird bird)
    {
        if(bird.getFlappyHeight() + bird.getFlappyVelocity() <= 0 || bird.getFlappyVelocity() + bird.getFlappyHeight() + Bird.BIRDSIZE >= Constants.HEIGHT)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean collides_wall(Bird bird, Wall wall)
    {
        if (wall.getX_position() <= 100 && wall.getX_position() + Constants.WALLWIDTH >= 100 || wall.getX_position() <= 75 && wall.getX_position() + Constants.WALLWIDTH >= 75)
        {
            if ((bird.getFlappyHeight() + bird.getFlappyVelocity()) >= 0 && (bird.getFlappyHeight() + bird.getFlappyVelocity()) <= wall.getGap_position()
                    || (bird.getFlappyHeight() + bird.getFlappyVelocity() + Bird.BIRDSIZE) >= wall.getGap_position() + 100 && (bird.getFlappyHeight() + bird.getFlappyVelocity() + Bird.BIRDSIZE) <= Constants.HEIGHT)
            {
                return true;
            }
        }
        return false;
    }
}
