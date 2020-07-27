package local.pocs.portoseguro.entities;

import local.pocs.portoseguro.annotations.CnabHeader;
import local.pocs.portoseguro.annotations.Posicao;
import local.pocs.portoseguro.annotations.enums.ConteudoEnum;
import local.pocs.portoseguro.annotations.enums.FormatoEnum;

public class HeaderSantander {
	
	@CnabHeader(posicao = @Posicao(de = 1, ate = 3), ordem = 1, digitos = 3, formato = FormatoEnum.NUMERICO)
	private String banco;
	
	@CnabHeader(posicao = @Posicao(de = 4, ate = 7), ordem = 2, digitos = 4, conteudo = ConteudoEnum.ZERO)
	private String lote;
	
	@CnabHeader(posicao = @Posicao(de = 8, ate = 8), ordem = 3, digitos = 1, conteudo = ConteudoEnum.ZERO)
	private String registro;

	@CnabHeader(posicao = @Posicao(de = 9, ate = 17), ordem = 4, digitos = 9, conteudo = ConteudoEnum.BRANCO)
	private String  filler;
	
	@CnabHeader(posicao = @Posicao(de = 18, ate = 18), ordem = 5, digitos = 1, formato = FormatoEnum.NUMERICO)
	private String tipoInscricao;
	
	@CnabHeader(posicao = @Posicao(de = 1, ate = 4), ordem = 1, digitos = 3, formato = FormatoEnum.NUMERICO)
	private String numeroInscricao;
	
	@CnabHeader(posicao = @Posicao(de = 1, ate = 4), ordem = 1, digitos = 3, formato = FormatoEnum.NUMERICO)
	private String codigoConvenio;

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

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(String tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
	
}
