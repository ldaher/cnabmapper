package local.pocs.portoseguro;

import local.pocs.portoseguro.bind.Mapeador;
import local.pocs.portoseguro.entities.Header;

public class App {

	public static void main(String[] args) {
		
		try {
			Mapeador m = new Mapeador();
			Header header = m.lerValor("2370001", Header.class);
			
			System.out.println(header);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
