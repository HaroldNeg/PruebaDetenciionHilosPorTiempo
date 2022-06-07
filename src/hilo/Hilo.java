package hilo;

public class Hilo extends Thread{
	
	
	@Override
	public void run() {
		while(!Hilo.interrupted()) {
		}
		System.out.println("TERMINO " + this.getName());
	}
}
