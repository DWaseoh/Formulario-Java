package form;

public class Usuario {
	private String usuario, contraseña;

	public Usuario(String nombre, String contraseña) {
		boolean enc = false;
		int contrCorrect = 0;

		this.usuario = nombre;
		this.contraseña = "";

		// Comprueba si hay simbolos en la contraseña.
		for (int i = 0; i < contraseña.length() && !enc; i++) {
			for (char j = 33; j <= 47 && !enc; j++) {
				if (contraseña.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 58; j <= 64 && !enc; j++) {
				if (contraseña.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 91; j <= 96 && !enc; j++) {
				if (contraseña.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
			for (char j = 123; j <= 126 && !enc; j++) {
				if (contraseña.charAt(i) == j) {
					enc = true;
					contrCorrect++;
				}
			}
		}
		enc = false;
		// Comprueba si hay números en la contraseña.
		for (int i = 0; i < contraseña.length() && !enc; i++) {
			for (char j = 48; j <= 57 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
		}
		enc = false;
		// Comprueba si hay letras en la contraseña.
		for (int i = 0; i < contraseña.length() && !enc; i++) {
			for (char j = 65; j <= 90 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
			for (char j = 97; j <= 122 && !enc; j++) {
				enc = true;
				contrCorrect++;
			}
		}

		// Introduce la contraseña del usuario encriptada.
		if (contrCorrect == 3 || contraseña.equals("admin")) {
			for (int i = 0; i < contraseña.length(); i++) {
				try {
					this.contraseña += (char) (contraseña.charAt(i) + 7);
				} catch (NullPointerException e) {

				}
			}
		} else {
			System.err.println("La contraseña debe estar compuesta por: \n· Un simbolo.\n· Una letra.\n· Un numero.");
		}
	}

	public void mostrar() {
		System.out.printf("Nombre: %s\nContraseña: %s\n#########\n", usuario, contraseña);
	}

	public String getNombre() {
		return usuario;
	}

	// El método devuelve la contraseña desencriptada.
	public String getContraseña() {
		String devolver = "";

		try {
			for (int i = 0; i < contraseña.length(); i++) {
				devolver += (char) (contraseña.charAt(i) - 7);
			}
		} catch (NullPointerException e) {

		}

		return devolver;
	}

}
