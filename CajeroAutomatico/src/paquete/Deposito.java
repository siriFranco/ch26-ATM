package paquete;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Deposito extends Padre_Abstracta {
	
	private static double lastDepositoTc;
	private static String lastDepositoTcDate;
	
	@Override
	public void Transacciones() {
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateDepositoTc = dateFormat.format(currentDate);
        
        
        int bandera = 0;
		int seleccion = 0;
		
		do {
			System.out.println("1. Cuenta de cheques ");
			System.out.println("2. Depósito a tarjeta de crédito ");
			
			seleccion = entrada.nextInt();
			
			if( seleccion >= 1 && seleccion <= 2 ) {
				bandera = 1;
			} else {
				System.out.println("Opción no disponible, vuelve a intentar por favor. \n");
				}
			} while ( bandera == 0); 
		
		
			if( seleccion == 1 ){
				int deposito = 0;
		        boolean validInput = false;
		        
		        while (!validInput) {
	                System.out.println("Ingrese el monto que desea depositar. \n ");
	                if (entrada.hasNextInt()) {
	                    deposito = entrada.nextInt();

	                    if (deposito < 0) {
	                        System.out.println("Error: No se permite ingresar números negativos. \n");
	                    } else if (deposito % 50 != 0) {
		                    System.out.println("Por favor, ingresa una cantidad múltiple de $50. \n");
		                } else {
		                    validInput = true;
		                }
		            } else {
		                System.out.println("Error: Ingrese un número entero válido. \n");
		                entrada.next(); // Discard invalid input
		            }
		        }					
				
				transacciones = getSaldo();
				setSaldo( transacciones + deposito);
				System.out.println("---------------------------------------------------------------");
				System.out.println("Realizaste un depósito de $" + deposito);
				System.out.println("Tu saldo actual es de $" + getSaldo() );
				System.out.println(formattedDateDepositoTc + " Se realizó depósito de $" + deposito );
				System.out.println("---------------------------------------------------------------\n");
								
				
			} else if ( seleccion == 2 ){
				double depositoTc = 0;
				boolean validInput = false;
				while (!validInput) {
					System.out.println("Ingrese el monto que desea depositar a la tarjeta de crédito. \n");
					if (entrada.hasNextDouble()) {
			            depositoTc = entrada.nextDouble();

			            if (depositoTc < 0) {
			                System.out.println("Error: No se permite ingresar números negativos.\n");
			            } else {
			                validInput = true;
			            }
			        } else {
			            System.out.println("Error: Ingrese un número válido.");
			            entrada.next(); // Discard invalid input
			        }
			    }

				if (depositoTc <= getSaldo()) {
					transacciones = getSaldo();
					setSaldo(transacciones - depositoTc);
					System.out.println("---------------------------------------------------------------");
					System.out.println("Has transferido $" + depositoTc + " a la tarjeta de crédito");
					System.out.println("Tu saldo actual es $" + getSaldo());
					System.out.println(formattedDateDepositoTc + " Transferencia a tarjeta de crédito de $" + depositoTc);
					System.out.println("---------------------------------------------------------------\n");
					
					lastDepositoTc = depositoTc;
					lastDepositoTcDate = formattedDateDepositoTc;
				} else {
					System.out.println("-----------------------------------------------------");
					
				}
		
		
			}
		
	}
	
	public static double getLastDepositoTc() {
        return lastDepositoTc;
 }
 
	 public static String getLastDepositoTcDate() {
	        return lastDepositoTcDate;
	    }
}
