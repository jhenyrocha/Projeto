
public class Customer {

	
	private String id;
	private String nome;
	private String CNPJ;
	private double saldo;
	
	
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Customer: id=" + id + ", nome=" + nome + ", CNPJ=" + CNPJ;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
