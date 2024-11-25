package com.programacion.servicios.impl;

import com.programacion.servicios.interfaces.ManejadorPersistencia;
import com.programacion.servicios.interfaces.TransferenciaBancaria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaBancariaImpl implements TransferenciaBancaria {

    @Inject
    ManejadorPersistencia manejadorPersistencia;

    @Override
    public void transferir(String num1, String num2, double monto) {
        var cuenta1 = manejadorPersistencia.buscarCuenta(num1);
        //Credito a la cuenta1
        manejadorPersistencia.actualizarSaldo(cuenta1, monto);

        var cuenta2 = manejadorPersistencia.buscarCuenta(num2);
        //Debito a la cuenta2
        manejadorPersistencia.actualizarSaldo(cuenta2, -monto);
    }
}
