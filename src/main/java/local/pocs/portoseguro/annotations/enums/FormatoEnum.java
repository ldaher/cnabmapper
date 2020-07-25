package local.pocs.portoseguro.annotations.enums;

public enum FormatoEnum {
	NUMERICO("9", "Numérico"), ALFANUMERICO("X", "Alfanumérico");

	private String descCurta;
	private String descLonga;

	private FormatoEnum(String descCurta, String descLonga) {
		this.descCurta = descCurta;
		this.descLonga = descLonga;
	}

	public static FormatoEnum getFormato(String descricao) {
		for (FormatoEnum f : FormatoEnum.values()) {
			if (f.descCurta.equals(descricao)) {
				return f;
			} else if (f.descLonga.equals(descricao)) {
				return f;
			}
		}

		return null;
	}
	
	public String getDescCurta() {
		return this.descCurta;
	}
	
	public String getDescLonga() {
		return this.descLonga;
	}
}
