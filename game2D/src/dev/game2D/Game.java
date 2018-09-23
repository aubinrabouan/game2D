package dev.game2D;

import dev.game2D.display.Display;
import dev.game2D.gjx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	private BufferedImage testImage;

	
	public Game(String title, int width, int height){
		this.width   = width;
		this.height  = height;
		this.title   = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/test.png");
	}
	
	private void tick() {
		
	}
	
	private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear

        g.clearRect(0,0,width, height);

        //Draw here !

        g.drawImage(testImage, 20,20,null);


        //End Drawing !
        bs.show();
        g.dispose();
	}

	public void run() {
		
		init();
		
		while(running) {
			tick();
			render();
			
		}
		
		stop();
		
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
