package local.pocs.portoseguro.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import local.pocs.portoseguro.annotations.enums.ConteudoEnum;
import local.pocs.portoseguro.annotations.enums.FormatoEnum;

/**
 * Indica que um campo representa um determinado valor no
 * arquivo CNAB, numa determinada posição, com uma quantidade X
 * de caracteres etc.
 * 
 * @author ldaher
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface CnabHeader {
	
	/**
	 * A ordem em que um campo se encontra dentro do CNAB
	 */
	public int ordem();

	/**
	 * A posição <b>de</b> e <b>até</b> no arquivo CNAB. 
	 */
	public Posicao posicao();

	/**
	 * O formato aceito para o campo (Numérico ou Alfanumérico). 
	 */
	public FormatoEnum formato() default FormatoEnum.NUMERICO;
	
	/**
	 * Pattern de expressão regular para validar o campo. 
	 */
	public String expReg() default "";
	
	public int digitos();
	
	public ConteudoEnum conteudo() default ConteudoEnum.OPCIONAL;
		
}
