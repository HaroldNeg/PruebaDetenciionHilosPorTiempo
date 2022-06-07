package hilo;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;

public class Principal {

	static int segundos = 10;
	public static void main(String[] args) {
		ArrayList<Hilo> hilos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Hilo hilo = new Hilo();
			hilo.setName("Hilo " + (i+1));
			hilos.add(hilo);
		}
				
		for (Hilo hilo : hilos) {
			hilo.start();
		}
		
		LocalDateTime tiempo = LocalDateTime.now();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		int hilosVivos = 1;
		while(hilosVivos > 0) {
			System.out.println("VERIFICAR SI ESTAN TERMINADOS");
			hilosVivos = 0;
			for (Hilo hilo : hilos) {
				if(hilo.isAlive()) {
					System.out.println(hilo.getName() + " Vivo");
					hilosVivos++;
				}
			}
			if(hilosVivos > 0) {
				Duration duration = Duration.between(tiempo, LocalDateTime.now());
				if(duration.getSeconds() > segundos) {
					for (Hilo hilo : hilos) {
						if(hilo.isAlive()) hilo.interrupt();
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}