package robot;


import java.awt.event.KeyEvent;

public class Robot {
	java.awt.Robot r;
	
	public Robot(){
		try{
			r = new java.awt.Robot();
		}catch(Exception e){
            System.out.println("ROBOT FAILED TO INITIALIZE");
            System.exit(1);
        }
	}

    public void moveMouse(int x, int y){
        r.mouseMove(x,y);
    }
    public void mousePress(int button){
        r.mousePress(button);
    }
    public void mouseRelease(int button) {
        r.mouseRelease(button);
    }
    public void mouseWheel(int amount) {
        r.mouseWheel(amount);
    }

    public void pressKey(int key){
        r.keyPress(key);
    }
    public void releaseKey(int key){
        r.keyRelease(key);
    }

    public void wait(int millis){
        try{
            Thread.sleep(millis);
        } catch (Exception e){}
    }
    public void wait(int millis, int nano){
        try{
            Thread.sleep(millis, nano);
        } catch (Exception e){}
    }

}
