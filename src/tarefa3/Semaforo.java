package tarefa3;

final class Semaforo {

	private int valor;
	private int esperando = 0;

	public Semaforo(int i) {
		valor = i;
	}

	public synchronized void acquire() { // ou DOWN()
		if (valor > 0) {
			valor--;
		} else {
			esperando++;
			try {
				wait();
			} catch (InterruptedException e) {

			}
			esperando--;
		}

	}

	public synchronized void release() { // ou UP()
		if (esperando > 0) {
			notify();
		} else {
			valor++;
		}
	}
}
