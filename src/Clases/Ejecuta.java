package Clases;
import javax.swing.*;
import java.awt.*;

import Forms.*;

public class Ejecuta {

	public static void main(String[] args) {

		TmpResolucion.setAncho(500);
		TmpResolucion.setAlto(500);
		TmpResolucion.setActualizarUI(false);
		
		Principal home = new Principal();
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setVisible(true);

		//Resolucion resolucion = new Resolucion();
		//resolucion.setVisible(true);
	}

}
