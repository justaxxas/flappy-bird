package flappy;

import javax.swing.JFrame;


public class FlappyFrame extends JFrame
{
    public  FlappyFrame()
    {
        add(new FlappyPanel());

        setSize(Constants.WIDTH, Constants.HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new FlappyFrame();
    }

}
