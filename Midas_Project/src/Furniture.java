import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class FurniturePanel extends JPanel {
	Furniture f;
    public FurniturePanel(Furniture f) {
    	this.f = f;
    }
    
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
          g.drawImage(f.getImage().getImage(), 0, 0, null);
    }
}
public class Furniture {

	private int width;
	private int height;
	private String name;
	private javafx.scene.paint.Color color;
	private ImageIcon imageicon;
	private int x;
	private int y;
	public FurniturePanel panel;
	public Furniture (int width, int height, String name) {
		this.width = width;
		this.height = height;
		this.name = name;
	}
	public Furniture() {
	}
	public ImageIcon getImage() {
		Image originImg = this.imageicon.getImage(); 
		Image changedImg= originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedImg);
		return icon;
	}
	public void RemoveFurniture()
	{
		for(Furniture f : MainFrame.getInstance().panel_1.furnitureArray)
		{
			if(f == this)
			{
				MainFrame.getInstance().panel_1.furnitureArray.remove(f);
				MainFrame.getInstance().panel_1.remove(f.panel);
				MainFrame.getInstance().panel_1.revalidate();
				MainFrame.getInstance().panel_1.repaint();
			}
		}
		
	}
	public JPanel getJPanel()
	{
		return panel;
	}
	public void setJPanel()
	{
		panel = new FurniturePanel(this);
		panel.setSize(width, height);
		panel.setLocation(x,y);
		panel.repaint();
	}
	
	public void setImage(ImageIcon imageicon)
	{
		this.imageicon = imageicon;
	}

	public javafx.scene.paint.Color getColor()
	{
		return color;
	}
	public void setColor(javafx.scene.paint.Color color2)
	{
		this.color = color2;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
