import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
 class input
{
	 ArrayList<int[]> inp=new ArrayList<int[]>();
	input()
	{
		try {
	
		BufferedImage bimage = ImageIO.read(new File("src/mahatmagandhi.jpg"));
		int height= bimage.getHeight();
		int width = bimage.getWidth();
		int array[][]=new int[height][width];
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
			array[i][j]=bimage.getRGB(i,j);
			}
		}
		ArrayList<int[]> a=new ArrayList<int[]>();
		for(int i=0;i<height;i++)
		{
		for(int k=0;k<width;k++)
			{
			if(array[i][k]<=100000)
			{
			int temp[]= {i,k};
			a.add(temp);
			}
	        }	
		}
		inp=a;
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	}