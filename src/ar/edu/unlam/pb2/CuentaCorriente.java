package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaSueldo {

	private final double limiteDescubierto = 5000.0;
	private Double deuda;

	public CuentaCorriente() {
		super();
		this.deuda = 0.0;
	}

	@Override
	public void extraer(double monto) throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		if (this.montoActual < monto) {

			if (monto <= this.limiteDescubierto) {
				Double diferencia = limiteDescubierto - this.montoActual;
				Double porcentaje = (5 * diferencia) / 100.0;
				this.montoActual = this.montoActual + diferencia;
				super.extraer(monto);
				setDeuda(diferencia + porcentaje);
			} else {
				throw new elPrestamoExcedeElLimiteDescubiertoException();
			}

		} else {
			throw new montoInsuficienteException();
		}
	}

	private void setDeuda(double deuda) {
		this.deuda = this.deuda + deuda;

	}

	public Double getDeuda() {
		return this.deuda;
	}

}
