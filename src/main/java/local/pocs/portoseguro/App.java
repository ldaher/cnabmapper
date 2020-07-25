package local.pocs.portoseguro;

import local.pocs.portoseguro.bind.Mapeador;
import local.pocs.portoseguro.entities.Header;
import local.pocs.portoseguro.exceptions.FormatNotMatchException;
import local.pocs.portoseguro.exceptions.PatternNotFoundException;

public class App {

	public static void main(String[] args) {
		
		try {
			Mapeador m = new Mapeador();
			Header header = m.lerValor("0330001300001A000", Header.class);
			
			System.out.println(header);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException | PatternNotFoundException | FormatNotMatchException e) {
			e.printStackTrace();
		}
		
	}

}
