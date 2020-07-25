package local.pocs.portoseguro.entities;

import local.pocs.portoseguro.annotations.CnabHeader;
import local.pocs.portoseguro.annotations.Posicao;
import local.pocs.portoseguro.annotations.enums.FormatoEnum;

public class Header {

	@CnabHeader(posicao = @Posicao(de = 1, ate = 3), ordem = 1, digitos = 3, formato = FormatoEnum.NUMERICO)
	private String banco;

	@CnabHeader(posicao = @Posicao(de = 4, ate = 7), ordem = 2, digitos = 4, formato = FormatoEnum.NUMERICO)
	private String lote;

	@CnabHeader(posicao = @Posicao(de = 8, ate = 8), ordem = 3, digitos = 1, formato = FormatoEnum.NUMERICO)
	private String registro;

	@CnabHeader(posicao = @Posicao(de = 9, ate = 17), ordem = 4, digitos = 9, formato = FormatoEnum.ALFANUMERICO)
	private String cnab;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getCnab() {
		return cnab;
	}

	public void setCnab(String cnab) {
		this.cnab = cnab;
	}

	@Override
	public String toString() {
		return banco + " | " + lote + " | " + registro + " | " + cnab;
	}
}
