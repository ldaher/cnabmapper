package local.pocs.portoseguro.bind;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import local.pocs.portoseguro.annotations.CnabHeader;
import local.pocs.portoseguro.bind.estrutura.Layout;
import local.pocs.portoseguro.enums.FormatoEnum;

public class Mapeador {

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

	public <T> T lerValor(String conteudo, Class<T> clazz)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		List<Layout> layouts = layout(clazz);

		T instance = clazz.newInstance();
		
		for (Layout layout : layouts) {
			Field field = clazz.getDeclaredField(layout.getNomeCampo());
			field.setAccessible(true);

			switch (layout.getFormato()) {
			case NUMERICO:
				field.set(instance, Integer.parseInt(conteudo.substring(layout.getDe() - 1, layout.getAte())));
				break;
			case ALFANUMERICO:
				field.set(instance, conteudo.substring(layout.getDe() - 1, layout.getAte()));
			default:
				break;
			}
		}

		return instance;
	}
}
