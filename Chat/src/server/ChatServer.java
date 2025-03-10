package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
	
	private  static final int PUERTO = 12345; //puerto escucha server
	private static Set<PrintWriter> clientes = new HashSet<>(); //conjunto clientes difundir mensajes
	

	public static void main(String[] args) {
		
		System.out.println("Servidor de chat iniciado...");
		
		try {
			ServerSocket serverSocket = new ServerSocket(PUERTO);
			
			while (true) {
				new ManejadorCliente(serverSocket.accept()).start();//acepta nuevas conexiones y maneja en un hilo separado
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	private static class ManejadorCliente extends Thread{
		private Socket socket;//comunica con cliente
		private PrintWriter salida;//flujo salida hacia cliente
		
		public ManejadorCliente(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			try {
				BufferedReader entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));//lee entrada del cliente
				salida = new PrintWriter(socket.getOutputStream(),true);// prepara envio mensajes
				
				synchronized (clientes) {
					clientes.add(salida);//agrega cliente a lista conectados
				}
				String mensaje;
				while ((mensaje = entrada.readLine()) != null) {
					System.out.println("Mensaje recibido: "+ mensaje);
					synchronized (clientes) {
						for(PrintWriter escritor: clientes) {
							escritor.println(mensaje);// reenvia mensaje a todos clientes
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		
		
	}

}
