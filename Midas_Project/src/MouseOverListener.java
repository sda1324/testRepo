

import javax.swing.JPanel;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.Cursor;

public class MouseOverListener extends JPanel implements MouseListener {

	MainFrame main;
	Object source;
	public MouseOverListener(Object t)//DefaultMap main)
	{
		main = MainFrame.getInstance();
		source = t;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger()) 
		{
			//0: blank
			//1: wall
			//2: point
			//3: furniture
			//4: window
			//5: door
			PopupMenuWindow popupT = new PopupMenuWindow(source);
			popupT.SetItem(source.getClass().getSimpleName());
			popupT.show(e.getXOnScreen()-100, e.getYOnScreen()-100);
			System.out.println("here");
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor cursor;
		//System.out.println(e.getSource().getClass().getName());

		//String t = e.getSource().getClass().getName().toString();
		
		System.out.println(source.getClass().getSimpleName());
		//System.out.println(text[0]);
		//System.out.println(((Component) e.getSource()).getName());
		switch(source.getClass().getSimpleName())
		{
		case "Wall":
			//cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
			//main.setCursor(cursor);
			//main.setCursor(ERROR);
			break;
		case "Point":

			//cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
			//main.setCursor(cursor);
			break;
		default:
			//cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
			//main.setCursor(cursor);
			break;
		}


		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
