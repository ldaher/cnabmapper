package local.pocs.portoseguro.enums;

public enum FormatoEnum {
	NUMERICO("9"), ALFANUMERICO("X");

	private String formato;

	private FormatoEnum(String formato) {
		this.formato = formato;
	}

	public static FormatoEnum getFormato(String formato) {
		for (FormatoEnum f : FormatoEnum.values()) {
			if (f.formato.equals(formato)) {
				return f;
			}
		}

		return null;
	}
}
