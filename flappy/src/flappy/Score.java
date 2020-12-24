package flappy;

import java.awt.*;

public class Score {

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void drawScore(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.drawString("SCORE: " + score, Constants.WIDTH / 3, 10);
        g.drawString("REPLAY: R", Constants.WIDTH / 2, 10);
        g.drawString("START: S ", Constants.WIDTH / 5, 10);
    }
    public void increaseScore()
    {
        score++;
    }
}
