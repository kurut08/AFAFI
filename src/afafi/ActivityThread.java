package afafi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActivityThread extends Thread {
    public long start, stop;
    JPanel activityContent;
    JProgressBar progressBar;
    int tick;
    boolean running = false;

    public ActivityThread(JPanel activityContent, JProgressBar progressBar, int tick){
        this.activityContent = activityContent;
        this.progressBar = progressBar;
        this.tick = tick;
    }
    public void run() 
    {
    	running = true;
    	while(running)
    	{
    		int value = 0;
            for(int i = 0; i<tick; i++)
            {
            	if(running)
            	{
            		value = value+1;
                    progressBar.setValue(value);
                    progressBar.update(progressBar.getGraphics());
                    try 
                    {
                        sleep(1000);
                    } 
                    catch (InterruptedException a) {
                        System.out.println("Thread stopped");
                    }
            	}
            }
    	}
    }
    
    public void finish()
    {
    	running = false;
    	progressBar.setValue(0);
    	progressBar.update(progressBar.getGraphics());
    }
}