package tarefa1;

import java.util.concurrent.ScheduledFuture;

public class Buffer {

	private int mensagem = 0;
	private int threadLeitor = 0;
	private boolean occupied = false;

	private int countEscrever = 0;

	public synchronized void escrever(Escalonador escalonador) {
		while (occupied) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("A thread: "
						+ Thread.currentThread().getName()
						+ " não escreveu a mensagem.");
			}
		}
			occupied = true;
			countEscrever++;
			if (countEscrever >= 120) {
				escalonador.getScheduledFuture().cancel(true);
			}
			System.out.println(Thread.currentThread().getId() + " valor: "
					+ countEscrever);
			Thread.currentThread().interrupt();
			occupied = false;
			notifyAll();
	}

	public synchronized int ler() {
		/*
		 * String nomethread = Thread.currentThread().getName(); while
		 * (!occupied) { try { wait(); } catch (InterruptedException e) {
		 * System.out.println("A thread: " + Thread.currentThread().getName() +
		 * " não leu a mensagem."); } } if (threadLeitor < 4) { int msgRecebida
		 * = mensagem; threadLeitor++; System.out.println(nomethread + "-" +
		 * "Mensagem recebida: " + msgRecebida); } if (threadLeitor == 4) {
		 * occupied = false; threadLeitor = 0; notify(); }
		 * 
		 * return mensagem;
		 */
		return 0;
	}

}
