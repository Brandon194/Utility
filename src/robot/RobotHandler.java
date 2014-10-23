package robot;

import java.awt.Robot;

public class RobotHandler {
	Robot r;
	
	public RobotHandler(){
		try{
			r = new Robot();
		}catch(Exception e){}
		
		while (true){
			r.mouseMove(50, 50);
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
			r.mouseMove(100, 100);
			try{
				Thread.sleep(10000);
			}catch(Exception e){}
			
		}
	}
}
