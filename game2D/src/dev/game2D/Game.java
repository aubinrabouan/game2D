package dev.game2D;

import dev.game2D.display.Display;

public class Game implements Runnable {
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	public Game(String title, int width, int height){
		this.width   = width;
		this.height  = height;
		this.title   = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
	}
	
	private void tick() {
		
	}
	
	private void render() {
		
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
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
