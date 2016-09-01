package tarefa3;

public class Aeronave extends Thread{


	private String codigo;
	private Estado estado;
	
	public Aeronave(String codigo, Estado estado) {
		this.codigo = codigo;
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
