package form;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		BDUser bduser= new BDUser();
		bduser.add(new Usuario("admin", "admin"));
		
		String usuario, contrase�a, opc;
		int Id;
		
		while(true) {
			sc=new Scanner(System.in);
			System.out.print("Usuario: ");
			usuario=sc.nextLine();
			System.out.print("Contrase�a: ");
			contrase�a=sc.nextLine();
			
			if(bduser.admin(usuario, contrase�a)) {
				do {
					sc=new Scanner(System.in);
					System.out.println("( + ) Crear usuarios\n( - ) Eliminar usuario\n( v ) Ver usuarios\n( c ) Cerrar sesion");
					opc=sc.nextLine();
					if(opc.equals("+")) {
						sc=new Scanner(System.in);
						
						System.out.println("\n###Crear usuario###");
						System.out.print("Usuario: ");
						usuario=sc.nextLine();
						System.out.print("Contrase�a: ");
						contrase�a=sc.nextLine();
						
						bduser.add(new Usuario(usuario, contrase�a));
					} else if (opc.equals("-")) {
						sc=new Scanner(System.in);
						
						System.out.println("\n###Eliminar usuario###");
						System.out.println("ID del usuario: ");
						try {
							Id=sc.nextInt();
							bduser.rem(Id);
						} catch(InputMismatchException e) {
							sc=new Scanner(System.in);
							System.err.println("[ ID mal introducida ]");
						}
						
					} else if (opc.equals("v")) {
						sc=new Scanner(System.in);
						
						bduser.ver();
						
					} else if (!opc.equals("+") && !opc.equals("v") && !opc.equals("-") && !opc.equals("c")) {
						System.err.println("Elige una de las opciones");
					}
				} while(!opc.equals("c"));
				
			} else if(bduser.iniciarSesion(usuario, contrase�a)) {
				System.out.println("�Bienvenido "+usuario+"!");
				System.out.println("Pulsa cualquier tecla para cerrar sesi�n.");
				sc.nextLine();
			} else if(!bduser.iniciarSesion(usuario, contrase�a)) {
				System.err.println("[ Usuario o contrase�a incorrectos ]");
			}
		}
		

	}

}
