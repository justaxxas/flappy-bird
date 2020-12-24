package flappy;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlappyPanel extends JPanel implements KeyListener, ActionListener {

    Wall[] walls;
    Bird bird;
    Score score;
    boolean gameOver = false;
    Timer time = new Timer(40, this);

    public FlappyPanel()
    {
        score = new Score();
        bird = new Bird();
        InitializeWalls();
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        if (!gameOver)
        {
            score.drawScore(g);

            for(Wall wall: walls)
            {
                wall.drawWall(g);
            }
            logic();
            bird.drawFlappy(g);

        } else
            {
                score.drawScore(g);
            }
    }

    private void logic()

    {
        if(Collision.collides_edges(bird))
        {
            gameOver = true;
        }

        for(Wall wall: walls)
        {
            if(Collision.collides_wall(bird, wall))
            {
                gameOver = true;
            }

            if (75 > wall.getX_position() + Constants.WALLWIDTH)
            {
                score.increaseScore();
            }

            if (wall.getX_position() + Constants.WALLWIDTH <= 0)
            {
               wall.reset();
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        bird.flappyFall();

        for(Wall wall: walls)
        {
            wall.move();
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE)
        {
            bird.flappyFly();
        }

        if (code == KeyEvent.VK_S)
        {
            time.start();
        }

        if(code == KeyEvent.VK_R)
        {
            time.stop();
            bird.reset();
            score.setScore(0);
            InitializeWalls();
            gameOver = false;
            repaint();
        }
    }

    private void InitializeWalls()
    {
        walls = new Wall[]
                {
                new Wall(Constants.WIDTH, (int) (Math.random() * (Constants.HEIGHT - 150))),
                new Wall(Constants.WIDTH + Constants.WIDTH / 2, (int) (Math.random() * (Constants.HEIGHT - 100)))
        };
    }

    public void keyReleased(KeyEvent e) {}
}
