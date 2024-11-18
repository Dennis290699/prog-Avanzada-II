package com.programacion;

import com.programacion.servicios.interfaces.ManejadorPersistencia;
import com.programacion.servicios.interfaces.TransferenciaBancaria;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTransfereciasSpring {
    public static void main(String[] args) {
    var context = new ClassPathXmlApplicationContext("app.xml");

        TransferenciaBancaria servicio = context.getBean(TransferenciaBancaria.class);

        var manejadorPersistencia = context.getBean(ManejadorPersistencia.class);

        var cuenta1 = manejadorPersistencia.buscarCuenta("001");
        var cuenta2 = manejadorPersistencia.buscarCuenta("002");

        System.out.println(cuenta1);
        System.out.println(cuenta2);

        servicio.transferir("001", "002", 50);

        cuenta1 = manejadorPersistencia.buscarCuenta("001");
        cuenta2 = manejadorPersistencia.buscarCuenta("002");

        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
}
