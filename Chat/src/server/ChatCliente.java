package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatCliente {
	private static final String SERVIDOR="localhost";
	private static final int PUERTO =12345;

	public static void main(String[] args) {

		try {
			Socket socket = new Socket(SERVIDOR,PUERTO);
			System.out.println("conectado al chat. escribe un mensaje");
			
			//crear flujos entrada y salida
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));//recibe datos servidor
			PrintWriter salida=new PrintWriter(socket.getOutputStream(),true);//envia datos al servidor
			BufferedReader tc =new BufferedReader(new InputStreamReader(System.in));//permite entrada del usuario
			
			//inicio hilo para recepcion mensajes
			Thread recibirMensaje = new Thread(new MensajeRecibido(entrada));
			recibirMensaje.start();
			
			//leer mensajes del usuario y enviar al servidor
			String mensajeUsuario;
			while ((mensajeUsuario=tc.readLine())!=null) {
				salida.println(mensajeUsuario);
			}
			
			//cerrar conexiones
			socket.close();
			entrada.close();
			salida.close();
			tc.close();
			
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
