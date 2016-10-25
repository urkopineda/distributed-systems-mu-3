package edu.mondragon.urkopineda.data;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * This class is used as a mailbox.
 * 
 * @author urko
 *
 * @param <T> Object to storage in the mailbox
 */
public class Buzon<T> {
		
	private ArrayList<T> buzon;
	private Semaphore lleno, vacio;
	private Semaphore candado;
	
	public Buzon(int capacidad) {
		buzon = new ArrayList<>();
		lleno = new Semaphore(capacidad);
		candado = new Semaphore(1);
		vacio = new Semaphore(0);
	}
			
	public void send(T msg) throws InterruptedException {
		lleno.acquire();
		candado.acquire();
		buzon.add(msg);
		candado.release();
		vacio.release();
	}
	
	public void send() throws InterruptedException {
		lleno.acquire();
		candado.acquire();
		buzon.add(null);
		candado.release();
		vacio.release();
	}
	
	public T receive() throws InterruptedException {
		T valor;
		vacio.acquire();
		candado.acquire();
		valor = buzon.remove(0);
		candado.release();
		lleno.release();
		return valor;
	}
	
	public int getSize() {
		return buzon.size();
	}
	
}
