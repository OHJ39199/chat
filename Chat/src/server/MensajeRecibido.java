package server;

import java.io.BufferedReader;

public class MensajeRecibido implements Runnable {

	private BufferedReader entrada;
	
	
	public MensajeRecibido(BufferedReader entrada) {
		this.entrada = entrada;
	}


	@Override
	public void run() {
		try {
			String mensaje;
			while ((mensaje = entrada.readLine())!=null) {
				System.out.println("mensaje recibido: "+mensaje);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
