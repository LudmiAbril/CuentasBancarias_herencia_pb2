package ar.edu.unlam.pb2;

public class CuentaSueldo {
	protected Double montoActual;

	public CuentaSueldo() {
		this.montoActual = 0.0;
	}

	public void depositar(double monto) {
		this.montoActual = this.montoActual + monto;
	}

	public Double getSaldo() {
		return this.montoActual;
	}

	public void extraer(double monto) throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		if (this.montoActual >= monto) {
			this.montoActual = this.montoActual - monto;
		} else {
			throw new montoInsuficienteException();
		}

	}

}
