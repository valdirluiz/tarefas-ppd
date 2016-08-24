package tarefa1;

public class Buffer {

	private int valor = 0;
	boolean ocupado = false;

	public synchronized void escrever(int valor) {
		while (ocupado) {

			try {

				wait();

			} catch (InterruptedException ex) {

				ex.printStackTrace();

			}

		}

		ocupado = true;
		
		this.valor = valor;

		System.out.println("Escreveu " + valor);
		
		notifyAll();
	}

	public synchronized void ler() {
		while (!ocupado) {

			try {

				wait();

			} catch (InterruptedException ex) {

				ex.printStackTrace();

			}

		}

		ocupado = false;

		System.out.println("Leu: " + this.valor);

		notifyAll();

	}
}
