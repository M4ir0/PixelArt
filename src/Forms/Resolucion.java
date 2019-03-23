package Forms;

import javax.swing.*;
import Clases.TmpResolucion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resolucion extends JFrame{

	public Resolucion() {
		Contenedor contenedor = new Contenedor();
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		add(contenedor);
	}
	
	private class Contenedor extends JPanel{
		
		public Contenedor() {
			
			setLayout(new BorderLayout());
			JPanel auxRes = new JPanel();
			auxRes.setBackground(Color.LIGHT_GRAY);
			JLabel jL_Resolucion = new JLabel("Resolución");
			auxRes.add(jL_Resolucion);
			add(auxRes, BorderLayout.NORTH);
			
			
			JPanel auxCentro = new JPanel();
			auxCentro.setLayout(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints();
			
			JLabel jL_Ancho = new JLabel("Ancho");
			jS_Ancho = new JSpinner(new SpinnerNumberModel(TmpResolucion.getAncho(), 500, 3000, 100));
			
			JLabel jL_Alto = new JLabel("Alto");
			jS_Alto = new JSpinner(new SpinnerNumberModel(TmpResolucion.getAlto(), 500, 3000, 100));

			gbc.anchor = GridBagConstraints.NORTHWEST;
			gbc.ipady = 5;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			auxCentro.add(jL_Ancho, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			auxCentro.add(jS_Ancho, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			auxCentro.add(jL_Alto, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 1;
			auxCentro.add(jS_Alto, gbc);
			
			add(auxCentro, BorderLayout.CENTER);
			
			
			JButton jB_Aceptar = new JButton("Aceptar");
			jB_Aceptar.addActionListener(new btnAceptar());
			JButton jB_Cancelar = new JButton("Cancelar");
			jB_Cancelar.addActionListener(new btnCancelar());
			
			JPanel auxBtn = new JPanel();
			auxBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			auxBtn.setBackground(Color.LIGHT_GRAY);
			auxBtn.add(jB_Cancelar);
			auxBtn.add(jB_Aceptar);
			add(auxBtn, BorderLayout.SOUTH);			
			
		}
		
		private class btnAceptar implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TmpResolucion.setAncho(Integer.parseInt(jS_Ancho.getValue().toString()));
				TmpResolucion.setAlto(Integer.parseInt(jS_Alto.getValue().toString()));
				
				TmpResolucion.setActualizarUI(true);
				
				Resolucion.this.setVisible(false);
				
				System.out.println(TmpResolucion.getAncho());
				System.out.println(TmpResolucion.getAlto());
			}
		}
		
		private class btnCancelar implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Resolucion.this.setVisible(false);
			}
		}
		
		JSpinner jS_Ancho;
		JSpinner jS_Alto;
	}
	
}
