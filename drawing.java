import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JComponent;

 class drawing extends JComponent{
ArrayList<double[]> path;

 drawing(ArrayList<double[]> path) {
	this.path = path;
}
protected void paintComponent(Graphics g2)
{
	Polygon p=new Polygon();
	for(int i=0;i<path.size();i++)
	{
		p.addPoint((int)path.get(i)[0],(int) path.get(i)[1]);
	}
	g2.drawPolyline(p.xpoints,p.ypoints,p.npoints);
	
}
}
