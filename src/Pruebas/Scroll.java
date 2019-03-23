package Pruebas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Scroll {

	public static void main(String[] args) {
		
		new ScrollPanel().setVisible(true);

	}

}

class ScrollPanel extends JFrame{
	
	public ScrollPanel() {
		
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(new MiPanel());
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll, BorderLayout.CENTER);
	}
}

class MiPanel extends JPanel{
	
	public MiPanel() {
		
		try {
		
			bf = ImageIO.read(new File("src/Multimedia/images/test.jpg"));
			
			setPreferredSize(new Dimension(bf.getWidth(), bf.getHeight()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(bf, 0, 0, null);
	}
	
	BufferedImage bf;
}
