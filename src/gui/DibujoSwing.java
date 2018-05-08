package Principal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DibujoSwing implements Serializable {
 
  JButton limpiarBtn, negroBtn, azulBtn, verdeBtn, rojoBtn, magentaBtn;
  AreaDibujo areaDibujo;
  ActionListener actionListener = new ActionListener() {
 
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == limpiarBtn) {
        areaDibujo.clear();
      } else if (e.getSource() == negroBtn) {
        areaDibujo.black();
      } else if (e.getSource() == azulBtn) {
        areaDibujo.blue();
      } else if (e.getSource() == verdeBtn) {
        areaDibujo.green();
      } else if (e.getSource() == rojoBtn) {
        areaDibujo.red();
      } else if (e.getSource() == magentaBtn) {
        areaDibujo.magenta();
      }
    }
  };
 
  public static void main(String[] args) {
    new DibujoSwing().show();
  }
 
  public void show() {
    // creando el frame principal
    JFrame frame = new JFrame("Practica 1 - Paint");
    Container contenido = frame.getContentPane();
    // establecer layout en el contenido del panel
    contenido.setLayout(new BorderLayout());
    // creando area de dibujo
    areaDibujo = new AreaDibujo();
 
    // anadiendo al contenido del panel
    contenido.add(areaDibujo, BorderLayout.CENTER);
 
    // creando ocntroles para cambio de color y borrar pantalla
    JPanel controles = new JPanel();
 
    limpiarBtn = new JButton("Limpiar");
    limpiarBtn.addActionListener(actionListener);
    negroBtn = new JButton("Negro");
    negroBtn.addActionListener(actionListener);
    azulBtn = new JButton("Azul");
    azulBtn.addActionListener(actionListener);
    verdeBtn = new JButton("Verde");
    verdeBtn.addActionListener(actionListener);
    rojoBtn = new JButton("Rojo");
    rojoBtn.addActionListener(actionListener);
    magentaBtn = new JButton("Magenta");
    magentaBtn.addActionListener(actionListener);
 
    // añadiendo al panel
    //controles.add(verdeBtn);
    //controles.add(azulBtn);
    controles.add(negroBtn);
    controles.add(rojoBtn);
    controles.add(magentaBtn);
    controles.add(limpiarBtn);
 
    // añadiendo al ocntenido del panel
    contenido.add(controles, BorderLayout.NORTH);
 
    frame.setSize(600, 600);
    // habilitando cierre de ventana
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // mostrando el dibujo 
    frame.setVisible(true);
 
  }
 
}