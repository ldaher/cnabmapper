package local.pocs.portoseguro.annotations.enums;

public enum ConteudoEnum {
	
	BRANCO("\\s{1,}"), ZERO("[0]{1,}"), DATA("\\d{8}"), HORA("\\d{6}"), OPCIONAL(null);
	
	private String regex;
	
	private ConteudoEnum(String regex) {
		this.regex = regex;
	}
	
	public String getRegex(){
		return this.regex;
	}

}
