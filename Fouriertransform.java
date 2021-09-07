import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Fouriertransform {
    static JFrame jfrm=new JFrame("Fourier Transform");
	static double x[];
	static double y[];
	static double[][] fourierX;
	static double[][] fourierY;
	static double time=0;
	static ArrayList<double[]> path=new ArrayList<double[]>();
	static private Graphics g;
	static private Graphics g2;
double[] epicycles(double x,double y,double rotation,double[][] fourier)
	{
	for(int i=0;i<fourier.length;i++)
	{
		double prevx=x;
		double prevy=y;
		double freq=fourier[i][2];
		double radius=fourier[i][3];
		double phase=fourier[i][4];
		x+=radius*Math.cos(freq*time+phase+rotation);
		y+=radius*Math.sin(freq*time+phase+rotation);	
		circle q=new circle(prevx,prevy,radius*2,radius*2);
		q.paintComponent(g);
		g.drawLine((int)prevx,(int)prevy,(int)x,(int) y);
		JPanel j=new JPanel();
		j.add(q);
		jfrm.add(j);
	}
	double[] t= {x,y};
	return t;
}
void draw()
{
	double[] vx=epicycles(jfrm.getWidth()/2+100,100,0,fourierX);
	double[] vy=epicycles(100,jfrm.getHeight()+100,Math.PI/2,fourierY);
	double v[]= {vx[0],vy[1]};
	path.add(0,v);
	drawing d=new drawing(path);
	d.paintComponent(g2);
	jfrm.add(d);
    double dt=2*Math.PI/fourierY.length;
    time+=dt;
    if(time>2*Math.PI)
    	path.clear();
    draw();
}
public static void main(String args[])
{
	Fouriertransform ft=new Fouriertransform();
	input l=new input();
	ArrayList<int[]> newarray=l.inp;
	jfrm.setSize(800,600);
	jfrm.setBackground(Color.WHITE);
	jfrm.setLayout(new FlowLayout());
	jfrm.setVisible(true);
	for(int i=0;i<newarray.size();i++)
	{
		x[i]=newarray.get(i)[0];
		y[i]=newarray.get(i)[1];
	}
	fourier f=new fourier();
	fourierX=f.dft(x);
	fourierY=f.dft(y);
	ft.draw();
}
}
