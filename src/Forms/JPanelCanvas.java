package Forms;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import Clases.TmpResolucion;

class JPanelCanvas extends JPanel{
	public JPanelCanvas(){
		
		try {
			
			bf = ImageIO.read(new File("src/Multimedia/images/test.jpg"));
			
			//setBackground(Color.RED);
			
			setPreferredSize(new Dimension(TmpResolucion.getAncho(), TmpResolucion.getAlto()));
			
			System.out.println("Ancho:" + TmpResolucion.getAncho() + "\nAlto: " + TmpResolucion.getAlto());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.RED);
		
		
		g.fillRect(100, 100, 100, 100);
		//g.drawImage(bf, 0, 0, null);
		
		//ARREGLAR ESTA INSTRUCCIÓN
		if(TmpResolucion.isActualizarUI()) {
			
			//this.setBackground(Color.RED);
			
			setPreferredSize(new Dimension(TmpResolucion.getAncho(), TmpResolucion.getAlto()));
			repaint();
			
			TmpResolucion.setActualizarUI(false);
			
			System.out.println("Nuevo ancho: " + this.getWidth());
			System.out.println("Nuevo alto: " + this.getHeight());
		}

	}
	
	ArrayList<Image> imagenes = new ArrayList<>();
	BufferedImage bf;
	
}
