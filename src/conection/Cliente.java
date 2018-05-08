package conection;

import java.net.*;

import java.io.*;

/**
 * @author Francisco Rubial
 * @version 0.1.0
 *          <h1>Conex</h1>
 *          <p>
 * 			Clase que crea la conexion como cliente y envia mensajes al servidor
 *          por defecto se conecta en localhost y el puerto 5000
 *          </p>
 */
public class Cliente {

	final String HOST = "localhost";
	final int PUERTO = 5000;
	Socket sc;
	DataOutputStream salida;

	public Cliente(int x, int y) {
		try {
			sc = new Socket(HOST, PUERTO);
			salida = new DataOutputStream(sc.getOutputStream());
			salida.writeInt(x);
			salida.writeInt(y);
			sc.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
