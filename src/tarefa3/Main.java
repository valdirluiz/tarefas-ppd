package tarefa3;


public class Main {
	public static void main(String[] args){
		final int CONCURRENT_PLANES = 10;
		final Torre torre = new Torre();
		
		for(int i = 0; i < CONCURRENT_PLANES; i++){
			Estado estado = (i % 2 == 0) ? Estado.VOANDO : Estado.ESTACIONADA;
			new Aeronave(i, estado, torre).start();
		}
		
	}
}
