package pizza.user;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JumpToOnEnter extends KeyAdapter {
	private Component jumpTo;
	public JumpToOnEnter(Component jumpTo) {
		this.jumpTo = jumpTo;
	}

	public void keyPressed(java.awt.event.KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			jumpTo.requestFocusInWindow();
		}
	};
}
