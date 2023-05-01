package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class test_cuentas {

	@Test
	public void queSePuedaCrearLaCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();

		assertNotNull(cuenta);
	}

	@Test
	public void queSePuedaDepositarEnLaCuentaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(2000.0);
		Double obtenido = cuenta.getSaldo();
		Double deseado = 2000.0;
		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaExtraerEnLaCuentaSueldo() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(2000.0);
		cuenta.extraer(1000.0);
		Double obtenido = cuenta.getSaldo();
		Double deseado = 1000.0;
		assertEquals(obtenido, deseado);
	}

	@Test(expected = montoInsuficienteException.class)
	public void queNoSePuedaExtraerEnLaCuentaSueldo() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(2000.0);
		cuenta.extraer(3000.0);
		Double obtenido = cuenta.getSaldo();
		Double deseado = 2000.0;
		
		assertEquals(obtenido, deseado);
	}

	@Test
	public void queSePuedaCrearLaCajaDeAhorros() {
		CajaDeAhorros caja = new CajaDeAhorros();

		assertNotNull(caja);
	}

	@Test
	public void queSePuedaExtraerEnLaCajaDeAhorrosLuegoDe5Intentos() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CajaDeAhorros caja = new CajaDeAhorros();
		caja.depositar(100.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		Double obtenido = caja.getSaldo();
		Double deseado = 34.0;
		assertEquals(obtenido, deseado);
	}
	
	@Test (expected = montoInsuficienteException.class)
	public void queNoSePuedaExtraerEnLaCajaDeAhorrosLuegoDe5IntentosPorValorDeComision() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CajaDeAhorros caja = new CajaDeAhorros();
		caja.depositar(60.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		caja.extraer(10.0);
		Double obtenido = caja.getSaldo();
		Double deseado = 50.0;
		assertEquals(obtenido, deseado);
	}
	
	@Test
	public void queSePuedaCrearLaCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente();

		assertNotNull(cuenta);
	}
	
	@Test
	public void queSePuedaExtraerEnLaCuentaCorrientePorPrestamo() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(1000.0);
		cuenta.extraer(3000.0);
		Double obtenido = cuenta.getDeuda();
		Double deseado = 4200.0;
		assertEquals(obtenido, deseado);
	}
	
	@Test (expected = elPrestamoExcedeElLimiteDescubiertoException.class)
	public void queNoSePuedaExtraerEnLaCuentaCorrientePorQUeElPrestamoExcedeElLimiteDescubierto() throws montoInsuficienteException, elPrestamoExcedeElLimiteDescubiertoException {
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.depositar(1000.0);
		cuenta.extraer(7000.0);
		Double obtenido = cuenta.getDeuda();
		Double deseado = 0.0;
		assertEquals(obtenido, deseado);
	}

}
