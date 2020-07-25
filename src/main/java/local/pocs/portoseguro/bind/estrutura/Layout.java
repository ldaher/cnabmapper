package local.pocs.portoseguro.bind.estrutura;

import local.pocs.portoseguro.annotations.enums.FormatoEnum;

public class Layout {

	private String nomeCampo;
	private int ordem;
	private int digitos;
	private int de;
	private int ate;
	private String expReg;
	private FormatoEnum formato;

	public String getNomeCampo() {
		return nomeCampo;
	}

	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getDigitos() {
		return digitos;
	}

	public void setDigitos(int digitos) {
		this.digitos = digitos;
	}

	public int getDe() {
		return de;
	}

	public void setDe(int de) {
		this.de = de;
	}

	public int getAte() {
		return ate;
	}

	public void setAte(int ate) {
		this.ate = ate;
	}

	public String getExpReg() {
		return expReg;
	}

	public void setExpReg(String expReg) {
		this.expReg = expReg;
	}

	public FormatoEnum getFormato() {
		return formato;
	}

	public void setFormato(FormatoEnum formato) {
		this.formato = formato;
	}

}
