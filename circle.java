import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class circle extends JComponent {
    double x;
    double y;
	double width;
	double height;
	public circle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}  
	protected void paintComponent(Graphics g)
    {
		g.setColor(Color.BLUE);
		g.drawOval((int)x,(int) y,(int) width,(int) height);
    }
}
