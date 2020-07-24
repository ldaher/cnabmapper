package local.pocs.portoseguro.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface Posicao {
	
	/**
	 * Valor inteiro informando a coluna inicial no CNAB.
	 */
	public int de();

	/**
	 * Valor inteiro informando a coluna final no CNAB.
	 */
	public int ate();
	

}
