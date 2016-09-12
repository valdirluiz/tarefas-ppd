package tarefa3;

public enum Estado {

	ESTACIONADA(1), TAXIANDO_CHEGADA(3), TAXIANDO_SAIDA(5), AGUARDANDO_DECOLAGEM(7), VOANDO(10);
	
	int prioridade;
	
	Estado(int prioridade){
		this.prioridade = prioridade;
	}

}
