package paquete;

public class Consulta extends Padre_Abstracta {
	
	@Override
	public void Transacciones() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("Tu saldo actual es $" + getSaldo() );
		System.out.println("---------------------------------------------------------------\n");
	}
}
