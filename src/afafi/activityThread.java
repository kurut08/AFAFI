package afafi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class activityThread extends Thread {
    public long start, stop;
    JPanel activityContent;
    JProgressBar progressBar;
    int tick;

    public activityThread(JPanel activityContent, JProgressBar progressBar, int tick){
        this.activityContent = activityContent;
        this.progressBar = progressBar;
        this.tick = tick;
    }
    public void run() {
        activityContent.addMouseListener( new MouseAdapter()
        {
            public void mouseEntered( MouseEvent e )
            {
                activityContent.setBackground(new Color(0, 32, 64));
            }
            public void mouseExited(MouseEvent e)
            {
                activityContent.setBackground(new Color(0, 32, 128));
            }
            public void mousePressed(MouseEvent e)
            {
                //start activity
                int value = 0;
                for(int i = 0; i<tick; i++){
                    value = value+1;
                    progressBar.setValue(value);
                    progressBar.update(progressBar.getGraphics());
                    try {
                        sleep(1000);
                    } catch (InterruptedException a) {
                        System.out.println("Thread stopped");
                    }
                }
                interrupt();
                System.out.println("DZIAŁA");
                //needs to and exp after finishing Thread
            }
        } );
    }
}