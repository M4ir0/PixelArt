package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreaMenu{

	public CreaMenu(JFrame jFrame){
		this.jFrame = jFrame;
	}
	
	//AGREGAR A LA CLASE LOS NOMBRES DE MENU
	public void setListMenu(String... lista){
		this.nameMenu = lista;
	}
	
	//AGREGAR A LA CLASE LOS ITEMS DE CADA MENU
	public void setListItems(String[]... lista){
		this.items = lista;
	}

	public void setListIcon(ImageIcon[]... lista){
		this.iconos = lista;
	}
	
	public void setActionListener(ActionListener[]... actionListener){
		this.actionListener = actionListener;
	}
	
	@Override
	public String toString() {
		return "Licencia General Publica - M4IR0";
	}
	
	public void Crear() throws DimensionException{
		
		//EVALUAR QUE LAS PROPIEDADES DE LA CLASE TENGAN EL MISMO TAMAÑO
		
		if(!((nameMenu.length == items.length) && (iconos.length == actionListener.length))) {
			throw new DimensionException
			("Comprobar que [ListMenu, ListItems, ListIcon, ActionListener] tengan la misma cantidad de parametros");
		}
		
		JMenuItem jMenuItem;
		JMenu jMenu = new JMenu();
		JMenuBar jMenuBar = new JMenuBar();
		
		for(int i = 0; i < nameMenu.length; i++) {
		
			jMenu = new JMenu(nameMenu[i]);
				
				for(int j = 0; j < items[i].length; j++) {
					
					jMenuItem = new JMenuItem(items[i][j]);
					jMenuItem.setIcon(iconos[i][j]);
					jMenuItem.addActionListener(actionListener[i][j]);
					jMenu.add(jMenuItem);
				}
				
			jMenuBar.add(jMenu);		
		}
		
		jFrame.setJMenuBar(jMenuBar);
	}
	
	private String []nameMenu;
	private String [][]items;
	private ImageIcon iconos[][];
	private ActionListener [][]actionListener;
	private JFrame jFrame;
}

class DimensionException extends RuntimeException{
	public DimensionException() {	}
	public DimensionException(String msj_error) {
		super(msj_error);
	}
}