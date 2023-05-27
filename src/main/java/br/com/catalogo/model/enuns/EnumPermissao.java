package br.com.catalogo.model.enuns;

public enum EnumPermissao {
	ROLE_ZE("ROLE_ZE"), ROLE_ADMINISTRADOR("ROLE_ADMINISTRADOR");

	private String valor;

	EnumPermissao(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
}
