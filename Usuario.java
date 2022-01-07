package form;

public class Usuario {
	private String usuario, contrase�a;

	public Usuario(String nombre, String contrase�a) {
		boolean enc = false;
		int contrCorrect = 0;

		this.usuario = nombre;
		this.contrase�a = "";

		// Comprueba si hay simbolos en la contrase�a.
		for (int i = 0; i < contrase�a.length() && !enc; i++) {
			for (char j = 33; j <= 47 && !enc; j++) {
				if (contrase�a.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 58; j <= 64 && !enc; j++) {
				if (contrase�a.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 91; j <= 96 && !enc; j++) {
				if (contrase�a.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 123; j <= 126 && !enc; j++) {
				if (contrase�a.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
		}
		enc = false;
		// Comprueba si hay n�meros en la contrase�a.
		for (int i = 0; i < contrase�a.length() && !enc; i++) {
			for (char j = 48; j <= 57 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
		}
		enc = false;
		// Comprueba si hay letras en la contrase�a.
		for (int i = 0; i < contrase�a.length() && !enc; i++) {
			for (char j = 65; j <= 90 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
			for (char j = 97; j <= 122 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
		}

		// Introduce la contrase�a del usuario encriptada.
		if (contrCorrect == 3 || contrase�a.equals("admin")) {
			for (int i = 0; i < contrase�a.length(); i++) {
				try {
					this.contrase�a += (char) (contrase�a.charAt(i) + 7);
				} catch (NullPointerException e) {

				}
			}
		} else {
			System.err.println("La contrase�a debe estar compuesta por: \n� Un simbolo.\n� Una letra.\n� Un numero.");
		}
	}

	public void mostrar() {
		System.out.printf("Nombre: %s\nContrase�a: %s\n#########\n", usuario, contrase�a);
	}

	public String getNombre() {
		return usuario;
	}

	// El m�todo devuelve la contrase�a desencriptada.
	public String getContrase�a() {
		String devolver = "";

		try {
			for (int i = 0; i < contrase�a.length(); i++) {
				devolver += (char) (contrase�a.charAt(i) - 7);
			}
		} catch (NullPointerException e) {

		}

		return devolver;
	}

}
