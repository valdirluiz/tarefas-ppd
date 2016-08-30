package tarefa2;

public abstract class Transacao {
	int valor;
	String data;

	Transacao(int valor, String data) {
		super();
		this.valor = valor * getVariacao();
		this.data = data;
	}

	int getValor() {
		return valor;
	}

	String getData() {
		return data;
	}

	abstract int getVariacao();

	abstract void emiteLinhaExtrato();
}
