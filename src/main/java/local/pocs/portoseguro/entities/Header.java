package local.pocs.portoseguro.entities;

import local.pocs.portoseguro.annotations.CnabHeader;
import local.pocs.portoseguro.annotations.Posicao;
import local.pocs.portoseguro.enums.FormatoEnum;

public class Header {

	@CnabHeader(posicao = @Posicao(de = 1, ate = 3), ordem = 1, digitos = 3, formato = FormatoEnum.NUMERICO, expReg = "/[A-Z]{3}\\-\\d{4}/")
	private int banco;

	@CnabHeader(posicao = @Posicao(de = 4, ate = 7), ordem = 2, digitos = 4, formato = FormatoEnum.ALFANUMERICO)
	private String lote;

	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return banco + " | " + lote;
	}
}
