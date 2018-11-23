package Forms;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Principal extends JFrame{

	public Principal(){
		setSize(700, 400);
		setLocationRelativeTo(null);
		setTitle("Pixel Art - Bienvenido");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		add(new Container());
	}
	
	private class Container extends JPanel{
		
		public Container(){
			JPanelMenu jP_Menu = new JPanelMenu();
			JPanelCanvas jP_Canvas = new JPanelCanvas();
			setLayout(new BorderLayout());
			add(jP_Menu, BorderLayout.NORTH);
			add(jP_Canvas, BorderLayout.CENTER);
		}
		
		
		private class JPanelMenu extends JPanel{
			public JPanelMenu(){
				
				JMenuBar jMenuBar = new JMenuBar();
				
				containerItems.add(itemFile);
				containerItems.add(itemOptions);
				containerItems.add(itemHelp);
				containerItems.add(itemAbout);
				
				for(int i = 0; i < nameMenu.length; i++){
					jMenuBar.add(CreateMenu(nameMenu[i], containerItems.get(i)));
				}
				
				setJMenuBar(jMenuBar);
			}
			
			private JMenu CreateMenu(String nMenu, String []items){
				JMenu menu = new JMenu(nMenu);
				for(int i = 0; i < items.length; i++)
					menu.add(new JMenuItem(items[i]));
				return menu;
			}
			
			private String []nameMenu = {"Archivo", "Opciones", "Ayuda", "Acerca de"};
			private String []itemFile = {"Nuevo", "Guardar como", "Salir"};
			private String []itemOptions = {"Imagenes", "Resolucion"};
			private String []itemHelp = {"Ayuda"};
			private String []itemAbout = {"Acerca de"};
			private ArrayList <String[]>containerItems = new ArrayList<>();
			
			private ImageIcon []icon;
		}
		
		
		private class JPanelCanvas extends JPanel{
			public JPanelCanvas(){
				setBackground(Color.GRAY);
			}
		}
	}
}
