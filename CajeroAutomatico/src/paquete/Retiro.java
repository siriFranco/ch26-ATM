package paquete;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Retiro extends Padre_Abstracta {

	private static int lastRetiro;
	private static String lastRetiroDate;
	
	@Override
	public void Transacciones() {
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = dateFormat.format(currentDate);
		

		Scanner scanner = new Scanner(System.in);

		int retiro = 0;
		boolean validInput = false;

		while (!validInput) {
			System.out.println("¿Cuánto deseas retirar? \nSaldo actual es de $" + getSaldo());
			
			if (scanner.hasNextInt()) {
		        retiro = scanner.nextInt();
			
				if (retiro < 0) {
			        System.out.println("Error: No se permite ingresar números negativos.");
			    } else if (retiro >= getSaldo() ) {
					System.out.println("Saldo insuficiente");
				} else if (retiro >= 6000) {
					System.out.println(
							"Por seguridad, no se permiten retiros en cajero \nautomático igual ó mayores de $6,000.00, ingrese una\ncantidad menor, recuerde ingresar múltiplos de $50");
				} else if (retiro % 50 != 0) {
					System.out.println("Por favor, ingresa una cantidad múltiple de $50 \npara brindarte el monto en billetes exactos");
				} else {
					validInput = true;
					} 
			 	}else {
			 		System.out.println("Error: Por favor ingrese un número entero.\n");
			 		scanner.next(); // Discard invalid input
			 		}
		}

		System.out.println("¿Desea donar $200 para la fundación de los gatetes? si / no");

		String answer = scanner.next();

		if (answer.equalsIgnoreCase("si")) {
			retiro += 200;
		}

		transacciones = getSaldo();
		setSaldo(transacciones - retiro);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Retiro de la cuenta por $" + retiro);
		System.out.println("Tu saldo actual es $" + getSaldo());
		System.out.println(formattedDate + " Retiro de $" + retiro);
		System.out.println("---------------------------------------------------------------\n");
		
		lastRetiro = retiro;
		lastRetiroDate = formattedDate;

	}
	
	 public static int getLastRetiro() {
	        return lastRetiro;
	 }
	 
	 public static String getLastRetiroDate() {
	        return lastRetiroDate;
	    }
}


