package paquete;
import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Padre_Abstracta {
	double transacciones;
	protected int retiro, deposito, depositoTc;
	private static double saldo;
    
	Scanner entrada = new Scanner (System.in);
	
	public void Operaciones (){	
		
		int consola = 0;
		int seleccion = 0;
		int intentos = 0;
		do { 
			do {
				System.out.println("Bienvenido a tu cajero favorito");
				System.out.println("Por favor seleccione una opción");
				System.out.println("	1. Retirar dinero ");
				System.out.println("	2. Hacer depósitos ");
				System.out.println("	3. Consultar saldo ");
				System.out.println("	4. Quejas ");
				System.out.println("	5. Ver último movimiento ");
				System.out.println("	9. Salir del cajero ");
				
				try {
			        seleccion = entrada.nextInt();

					if( seleccion >= 1 && seleccion <= 5 || seleccion == 9 ) {
						consola = 1;
						intentos = 0;
					} else {
						System.out.println("Opción no disponible, vuelve a intentar por favor.\n");
						intentos++;
						}
					} catch (InputMismatchException e) {
				        System.out.println("Error: Ingrese un número entero válido.\n");
				        entrada.nextLine(); // Clear the input buffer
				        intentos++;
				    }
				} while ( consola == 0 && intentos < 3);
			
			 	if (intentos >= 3) {
	                System.out.println("Demasiados intentos fallidos. ¡Nos vemos pronto!\n");
	                System.exit(0);
	            } 			
			
				if( seleccion == 1 ){
					Padre_Abstracta mensajero = new Retiro();
					mensajero.Transacciones();
					
				} else if ( seleccion == 2 ){
					Padre_Abstracta mensajero = new Deposito();
					mensajero.Transacciones();
					
				} else if ( seleccion == 3 ){
					Padre_Abstracta mensajero = new Consulta();
					mensajero.Transacciones();
					
				} else if ( seleccion == 4 ){
					System.out.println("Lo sentimos, no esta disponible por el momento\n");
					
				} else if ( seleccion == 5 ){
					int lastRetiro = Retiro.getLastRetiro();
			        String lastRetiroDate = Retiro.getLastRetiroDate();
			        
			        double lastDepositoTc = Deposito.getLastDepositoTc();
			        String lastDepositoTcDate = Deposito.getLastDepositoTcDate();
			        System.out.println("---------------------------------------------------------------");
			        if (lastRetiroDate != null) {
			            System.out.println(lastRetiroDate + " Retiro de $" + lastRetiro);
			        } else {
			            System.out.println("No hay registro de retiro reciente.");
			        }
			        
			        if (lastDepositoTcDate != null) {
			            System.out.println(lastDepositoTcDate + " Depósito a tarjeta de crédito de $" + lastDepositoTc);
			        } else {
			            System.out.println("No hay registro de depósito a tarjeta de crédito reciente.");
			        }
			        System.out.println("---------------------------------------------------------------\n");
				} else if ( seleccion == 9 ){
					System.out.println("Un placer atenderlo, ¡vuelva pronto!\n");
					consola = 2;
				}
			} while ( consola != 2);
	}
	
	// Método para Retirar dinero
	public void Retiro() {
		retiro = entrada.nextInt();
	}
	
	// Método para Hacer depósitos
	public void Deposito() {
		deposito = entrada.nextInt();
	}
	
	// Método para Hacer depósitos
	public void DepositoTc() {
		depositoTc = entrada.nextInt();
	}
	
	// Método para Hacer depósitos
		public void Movimiento() {
			depositoTc = entrada.nextInt();
		}
	
	//Método abstracto
	public abstract void Transacciones();
	
	// Método setter y getter
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		Padre_Abstracta.saldo = saldo;
	}
	
	// --------------------------------------------
   
}
