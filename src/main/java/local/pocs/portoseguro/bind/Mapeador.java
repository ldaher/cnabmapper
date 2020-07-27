package local.pocs.portoseguro.bind;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import local.pocs.portoseguro.annotations.CnabHeader;
import local.pocs.portoseguro.annotations.enums.FormatoEnum;
import local.pocs.portoseguro.bind.estrutura.Layout;
import local.pocs.portoseguro.exceptions.FormatNotMatchException;
import local.pocs.portoseguro.exceptions.PatternNotFoundException;

public class Mapeador {

	public <T> T lerValor(String conteudo, Class<T> clazz)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, PatternNotFoundException, FormatNotMatchException {
		List<Layout> layouts = this.layout(clazz);

		T instance = clazz.newInstance();
		
		for (Layout layout : layouts) {
			Field field = clazz.getDeclaredField(layout.getNomeCampo());
			field.setAccessible(true);

			String deAte = conteudo.substring(layout.getDe() - 1, layout.getAte());

			if(!layout.getExpReg().isEmpty()) {
				Matcher m = Pattern.compile(layout.getExpReg()).matcher(deAte);
				
				if(!m.find()) {
					throw new PatternNotFoundException("O padrão de caracteres esperado não foi encontrado.");
				}
			} else {
				int digitos = layout.getDigitos();
				switch (layout.getFormato()) {
				case NUMERICO:
					String pttrNum = "\\d{" + digitos + "}";
					Matcher mNum = Pattern.compile(pttrNum).matcher(deAte);
					
					if(!mNum.find()) {
						throw new FormatNotMatchException("O formato " + FormatoEnum.NUMERICO.getDescLonga() + " não foi encontrado");
					}
					break;
				case ALFANUMERICO:
					String pttrAlfa = "[A-Z\\d\\s]{" + digitos + "}";
					Matcher mAlfa = Pattern.compile(pttrAlfa).matcher(deAte);
					
					if(!mAlfa.find()) {
						throw new FormatNotMatchException("O formato " + FormatoEnum.ALFANUMERICO.getDescLonga() + " não foi encontrado");
					}
				default:
					break;
				}
			}

			field.set(instance, conteudo.substring(layout.getDe() - 1, layout.getAte()));
		}

		return instance;
	}

	private <T> List<Layout> layout(Class<T> clazz) {
		List<Layout> layouts = new ArrayList<Layout>();
	
		for (Field f : clazz.getDeclaredFields()) {
			f.setAccessible(true);
			if (f.isAnnotationPresent(CnabHeader.class)) {
				CnabHeader cnabHeader = f.getAnnotation(CnabHeader.class);
	
				Layout layout = new Layout();
	
				layout.setNomeCampo(f.getName());
				layout.setOrdem(cnabHeader.ordem() != 0 ? cnabHeader.ordem() : 0);
				layout.setDigitos(cnabHeader.digitos() != 0 ? cnabHeader.digitos() : 0);
				layout.setDe(cnabHeader.posicao() != null ? cnabHeader.posicao().de() : 0);
				layout.setAte(cnabHeader.posicao() != null ? cnabHeader.posicao().ate() : 0);
				layout.setExpReg(cnabHeader.expReg().isEmpty() ? "" : cnabHeader.expReg());
				layout.setFormato(cnabHeader.formato() != null ? cnabHeader.formato() : FormatoEnum.NUMERICO);
	
				layouts.add(layout);
			}
		}
	
		return layouts;
	}
}
