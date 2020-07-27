package local.pocs.portoseguro.enums;

public enum TipoInscricaoEnum {
	ISENTO(0), CPF(1), CNPJ(2), PIS(3), OUTROS(4);

	private int tipo;

	private TipoInscricaoEnum(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}
	
	public static TipoInscricaoEnum getTipoInscricaoEnum(int tipo){
		for (TipoInscricaoEnum t : TipoInscricaoEnum.values()) {
			if(t.getTipo() == tipo) {
				return t;
			}
		}
		
		return null;
	}
}
