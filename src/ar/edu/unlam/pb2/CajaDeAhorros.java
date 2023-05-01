package ar.edu.unlam.pb2;

public class CajaDeAhorros extends CuentaSueldo {

	private int contador;

	@Override
	public void extraer(double monto) throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		if (this.montoActual >= monto && this.contador < 5) {
			this.contador++;
			super.extraer(monto);
		} else if (this.contador >= 5 && this.montoActual >= monto + 6) {
			this.contador++;
			super.extraer(monto+6);
		} else {
			throw new montoInsuficienteException();
		}
	}

}
