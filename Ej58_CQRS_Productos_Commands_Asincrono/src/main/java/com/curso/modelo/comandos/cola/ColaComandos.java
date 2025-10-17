package com.curso.modelo.comandos.cola;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import com.curso.modelo.comandos.Comando;

@Component
public class ColaComandos {

	private BlockingQueue<Comando> colaComandos = new LinkedBlockingQueue<>();
	
	public ColaComandos() {
		super();
		
		//Aqui tenemos un único hilo para procesar todos los comandos.
		//Podriamos definir un ExecutorService con un pool de hilos...
		new Thread() {
			public void run() {
				while(true) {
					try {
						colaComandos.take().ejecutar();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();		
	}

	public void offer(Comando comando) {
		//LinkedBlockingQueue es thread safe
		colaComandos.offer(comando);
	}
	
}
