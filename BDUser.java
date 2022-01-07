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

	// M�todo que guarda un usuario en la base de datos identificado con un ID.
	public void add(Usuario user) {
		boolean enc = false;

		if (!user.getContrase�a().equals("")) {
			for (int i = 0; i < MAX && !enc; i++) {
				if (!reg[i]) {
					enc = true;
					usuarios[i] = user;
					reg[i] = true;
				}
			}
		}
	}

	// M�todo que borra un usuario de la base de datos.
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

	// M�todo que muestra la base de datos de los usuarios.
	public void ver() {
		for (int i = 1; i < MAX; i++) {
			if (reg[i]) {
				System.out.print("ID: " + i + "\n");
				usuarios[i].mostrar();
			}
		}
	}

	// M�todo de inicio de sesion del admin.
	public boolean admin(String usuario, String contrase�a) {
		if (usuario.equals("admin")) {
			if (contrase�a.equals("admin")) {
				return true;
			}
		}
		return false;
	}

	// Metodo de inicio de sesion de cualquier usuario.
	public boolean iniciarSesion(String usuario, String contrase�a) {
		for (int i = 0; i < MAX; i++) {
			try {
				if (usuario.equals(usuarios[i].getNombre())) {
					if (contrase�a.equals(usuarios[i].getContrase�a())) {
						return true;
					}
				}
			} catch (NullPointerException e) {
			}
		}

		return false;
	}
}
