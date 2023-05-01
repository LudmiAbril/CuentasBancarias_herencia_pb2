package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {

	private int contador;

	@Override
	public void extraer(double monto) throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		if (this.contador < 5) {
			super.extraer(monto);
			this.contador++;
		} else if (this.contador >= 5) {
			super.extraer(monto + 6);
			this.contador++;
		}
	}

}
