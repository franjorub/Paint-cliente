
package Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;

import javax.swing.JComponent;
 
/**
* 
*
* 
*
*/
public class AreaDibujo extends JComponent implements Serializable {
 
  // Imagen sobre la que se dibuja
  private Image imagen;
  // Graphics2D object ==> sobre lo que se dibuja
  private Graphics2D g2;
  // coordenadas del mouse
  private int xActual, yActual, viejaX, viejaY;
 
  public AreaDibujo() {
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // guarda las coordenadas del mouse cuando esta presionado
        viejaX = e.getX();
        viejaY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        // coordenadas x,y cuando se mueve el mouse
        xActual = e.getX();
        yActual = e.getY();
 
        if (g2 != null) {
          // dibuja si el contenido de g2 no es nulo
          g2.drawLine(viejaX, viejaY, xActual, yActual);
          // refresca el area de dibujo 
          repaint();
          // actualiza las coordenadas viejas con el valor de las nuevas
          viejaX = xActual;
          viejaY = yActual;
        }
      }
    });
  }
 
  protected void paintComponent(Graphics g) {
    if (imagen == null) {
      // se crea una imagen nueva si es nula
      imagen = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) imagen.getGraphics();
      // activando antialiasing
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      // limpiando el area de dibujo
      clear();
    }
 
    g.drawImage(imagen, 0, 0, null);
  }
 
  // creando los metodos de los controles
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
 
  public void red() {
    // apply red color on g2 context
    g2.setPaint(Color.red);
  }
 
  public void black() {
    g2.setPaint(Color.black);
  }
 
  public void magenta() {
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    g2.setPaint(Color.blue);
  }
 
}