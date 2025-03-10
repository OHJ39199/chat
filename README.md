# Chat - Proyecto PSP
---------------------------

## Descripción del Proyecto
---------------------------

Este proyecto es un ejemplo de un chat en el cual se vera involucrado un servidor y varios clientes

## Características Principales
---------------------------

### Descripción del sistema 
---------------------------
El sistema se dividirá en dos partes: 
1. **Servidor**: Se encargará de gestionar las conexiones de los clientes y retransmitir los mensajes a todos los participantes. 
2. **Cliente**: Se conectará al servidor, enviará mensajes y recibirá mensajes de otros usuarios en tiempo real.

###Tareas a realizar 
---------------------------

1. **Implementar el Servidor**
  • Crear una clase ChatServer que escuche conexiones en un puerto determinado. 
  • Manejar múltiples clientes usando hilos. 
  • Al recibir un mensaje de un cliente, retransmitirlo a todos los demás clientes conectados. 
  • Cerrar la conexión de un cliente cuando este se desconecte.

2. **Implementar el Cliente** 
  • Crear una clase ChatClient que se conecte al servidor usando sockets. 
  • Permitir que el usuario ingrese un nombre antes de empezar a chatear. 
  • Crear un hilo para recibir mensajes del servidor en tiempo real. 
  • Leer mensajes del usuario y enviarlos al servidor.
