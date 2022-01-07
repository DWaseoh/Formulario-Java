package form;

public class BDUser {
	private final int MAX;
	private Usuario[] usuarios;
	private boolean[] reg;

	public BDUser() {
		MAX = 10;
		usuarios = new Usuario[MAX];
		reg = new boolean[MAX];
	}

	// Método que guarda un usuario en la base de datos identificado con un ID.
	public void add(Usuario user) {
		boolean enc = false;

		if (!user.getContraseña().equals("")) {
			for (int i = 0; i < MAX && !enc; i++) {
				if (!reg[i]) {
					enc = true;
					usuarios[i] = user;
					reg[i] = true;
				}
			}
		}
	}

	// Método que borra un usuario de la base de datos.
	public void rem(int ID) {
		boolean enc = false;

		if (ID > 0 && ID < MAX) {
			if (reg[ID]) {
				usuarios[ID] = null;
				reg[ID] = false;
				System.out.println("Usuario eliminado con exito");
				enc = true;
			} else if (!enc) {
				System.err.println("[ No se ha encontrado el usuario ]");
			}
		} else
			System.err.println("[ No se ha encontrado el usuario ]");
	}

	// Método que muestra la base de datos de los usuarios.
	public void ver() {
		for (int i = 1; i < MAX; i++) {
			if (reg[i]) {
				System.out.print("ID: " + i + "\n");
				usuarios[i].mostrar();
			}
		}
	}

	// Método de inicio de sesion del admin.
	public boolean admin(String usuario, String contraseña) {
		if (usuario.equals("admin")) {
			if (contraseña.equals("admin")) {
				return true;
			}
		}
		return false;
	}

	// Metodo de inicio de sesion de cualquier usuario.
	public boolean iniciarSesion(String usuario, String contraseña) {
		for (int i = 0; i < MAX; i++) {
			try {
				if (usuario.equals(usuarios[i].getNombre())) {
					if (contraseña.equals(usuarios[i].getContraseña())) {
						return true;
					}
				}
			} catch (NullPointerException e) {
			}
		}

		return false;
	}
}
