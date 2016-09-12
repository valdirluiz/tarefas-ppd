package tarefa3;

public class Aeronave implements Runnable {

	private long codigo;
	private Estado estado;
	private boolean working = true;
	private Torre torre;

	public Aeronave(long codigo, Estado estado, Torre torre) {
		this.codigo = codigo;
		this.estado = estado;
		this.torre = torre;
	}
	
	private void updatePriority(){
		Thread.currentThread().setPriority(estado.prioridade);
	}
	
	public void run(){
		while(working){
			updatePriority();
			torre.getSemafaro().acquire();
			work();
			torre.getSemafaro().release();
		}
	}
	
	private void work(){
		switch (estado) {
		case ESTACIONADA:
			System.out.println(codigo + ": Aeronave saindo do estacionamento");
			this.estado = Estado.TAXIANDO_SAIDA;
			break;
		case TAXIANDO_CHEGADA:
			System.out.println(codigo + ": Aeronave indo para estacionamento");
			this.estado = Estado.ESTACIONADA;
			this.working = false;
			break;
		case TAXIANDO_SAIDA:
			System.out.println(codigo + ": Aeronave taxiando para decolar");
			this.estado = Estado.AGUARDANDO_DECOLAGEM;
			break;
		case AGUARDANDO_DECOLAGEM:
			System.out.println(codigo + ": Aeronave decolando");
			this.estado = Estado.VOANDO;
			this.working = false;
			break;
		case VOANDO:
			System.out.println(codigo + ": Aeronave aterrissando");
			this.estado = Estado.TAXIANDO_CHEGADA;
			break;
		}
	}
}
