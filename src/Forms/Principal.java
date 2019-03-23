package Forms;
import Clases.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Principal extends JFrame{

	public Principal(){
		setSize(700, 400);
		setLocationRelativeTo(null);
		setTitle("Pixel Art - Bienvenido");
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		Container container = new Container();
		add(container);
	}
	
	private class Container extends JPanel{
		
		JPanelMenu jP_Menu;
		JScrollPane scroll;
		BarraHerramientasInferior barraInferior;
		
		public Container(){
			
			jP_Menu = new JPanelMenu();
			
			scroll = new JScrollPane(new JPanelCanvas());
			
			barraInferior = new BarraHerramientasInferior();
			
			setLayout(new BorderLayout());
			add(jP_Menu, BorderLayout.NORTH);
			add(scroll, BorderLayout.CENTER);
			add(barraInferior, BorderLayout.SOUTH);
			
		}
		
		private class JPanelMenu extends JPanel{
			public JPanelMenu(){
				
				CreaMenu miMenu = new CreaMenu(Principal.this);
				miMenu.setListMenu("Archivo", "Opciones", "Ayuda", "Acerca De");
				miMenu.setListItems(itemFile, itemOptions, itemHelp, itemAbout);
				miMenu.setListIcon(iconsFile, iconsOptions, iconsHelp, iconsAbout);
				miMenu.setActionListener(actList_Archivo, actList_Opciones, actList_Ayuda, actList_AcercaDe);
				miMenu.Crear();
				
				System.out.println(miMenu.toString());
			}
			
			ActionListener nuevo = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("NUEVO");
				}
			};
			
			ActionListener guardarComo = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("GUARDAR COMO");
				}
			};
			
			ActionListener salir = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Btn Salir");
					System.exit(0);
				}
			};
			
			ActionListener imagenes  = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("IMAGENES");
				}
			};
			
			ActionListener resolucion = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("RESOLUCION");
					new Resolucion().setVisible(true);;
				}
			};
			
			ActionListener ayuda = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("AYUDA");
				}
			};
			
			ActionListener acercaDe = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("ACERCA DE");
				}
			};
			
			
			//private String []nameMenu = {"Archivo", "Opciones", "Ayuda", "Acerca de"};
			private String []itemFile = {"Nuevo", "Guardar como", "Salir"};
			private String []itemOptions = {"Imagenes", "Resolucion"};
			private String []itemHelp = {"Ayuda"};
			private String []itemAbout = {"Acerca de"};
			
			private String ruta = "src/Multimedia/icons/";
			
			private ImageIcon []iconsFile = {
					new ImageIcon(ruta+"nuevo.png"), 
					new ImageIcon(ruta+"guardar.png"), 
					new ImageIcon(ruta+"salir.png")};
			
			private ImageIcon []iconsOptions = {
					new ImageIcon(ruta+"Imagenes.png"), 
					new ImageIcon(ruta+"resolucion.png")};
			
			private ImageIcon []iconsHelp = {
					new ImageIcon(ruta+"ayuda.png")};
			
			private ImageIcon []iconsAbout = {
					new ImageIcon(ruta+"ayuda.png")};
			
			ActionListener []actList_Archivo = {nuevo, guardarComo, salir};
			ActionListener []actList_Opciones = {imagenes, resolucion}; 
			ActionListener []actList_Ayuda = {ayuda};
			ActionListener []actList_AcercaDe = {acercaDe};
		}
		
		/*
		private class JPanelCanvas extends JPanel{
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
			
			int x = 0, y = 0;
			boolean actualizar = true;
			
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				
				g.setColor(Color.RED);
				
				x += 1;
				y += 1;
				
				g.fillRect(x, y, 10, 10);
				g.drawImage(bf, 0, 0, null);
				
				//ARREGLAR ESTA INSTRUCCIÓN
				if(TmpResolucion.isActualizarUI()) {
					
					//this.setBackground(Color.RED);
					
					setPreferredSize(new Dimension(TmpResolucion.getAncho(), TmpResolucion.getAlto()));
					scroll.updateUI();
					repaint();
					
					TmpResolucion.setActualizarUI(false);
					
					System.out.println("Nuevo ancho: " + this.getWidth());
					System.out.println("Nuevo alto: " + this.getHeight());
				}

			}
			
			ArrayList<Image> imagenes = new ArrayList<>();
			BufferedImage bf;
			
		}
		*/
		//FIN DE LA CLASE JPanelCanvas
		
	}

	private class BarraHerramientasInferior extends JPanel{
		
		public BarraHerramientasInferior() {
			
			JSlider jSlider = new JSlider();
			jSlider.setMinimum(20);
			jSlider.setMaximum(100);
			jSlider.setMajorTickSpacing(20);
			jSlider.setValue(100);
			jSlider.setMinorTickSpacing(10);
			jSlider.setPaintTicks(true);
			jSlider.setPaintLabels(true);
			add(jSlider);
		}
	}
}
