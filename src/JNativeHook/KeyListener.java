package JNativeHook;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener {
        public void nativeKeyPressed(NativeKeyEvent e) {
        	
        	if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Space")){
        		System.out.print(" ");
        	} else {
        		System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
        	}
        	
              /*
                if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
                        GlobalScreen.unregisterNativeHook();
                }
              */
        }

        public void nativeKeyReleased(NativeKeyEvent e) {
               // System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
               // System.out.print(NativeKeyEvent.getKeyText(e.getKeyCode()));
        }
        
        public static void main(String[] args) {
            try {
                    GlobalScreen.registerNativeHook();
            }
            catch (NativeHookException ex) {
                    System.out.println("There was a problem registering the native hook.");
                    System.out.println(ex.getMessage());

                    System.exit(1);
            }

            //Construct the example object and initialze native hook.
            GlobalScreen.getInstance().addNativeKeyListener(new KeyListener());
        }
}