package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import conection.Cliente;


public class Ventana extends JFrame {

	public Ventana(String titulo) throws HeadlessException {
		super(titulo);
		// TODO Auto-generated constructor stub
		super.setSize(400, 400);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		super.setContentPane(new Panel());
		super.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Ventana ventana = new Ventana("Cliente");
	}

	private class Panel extends JPanel {

		private JButton enviar;
		private JTextField texto;
		private JLabel titulo;
		
		private ActionListener send = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente socket;
				String mensaje = texto.getText();
				socket = new Cliente(mensaje);	
				texto.setText("");
			}
		};

		public Panel() {
			super();
			titulo = new JLabel("escribe el texto que quieres enviar");
			texto = new JTextField(20);
			enviar = new JButton("enviar");

			enviar.addActionListener(send);

			super.setBackground(Color.LIGHT_GRAY);
			super.setLayout(new FlowLayout());
			super.add(titulo);
			super.add(texto);
			super.add(enviar);
			// TODO Auto-generated constructor stub
		}

	}
}
