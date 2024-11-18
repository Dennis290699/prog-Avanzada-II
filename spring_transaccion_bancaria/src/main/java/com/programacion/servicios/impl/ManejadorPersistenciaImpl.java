package com.programacion.servicios.impl;

import com.programacion.db.Cuenta;
import com.programacion.servicios.interfaces.ManejadorPersistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class ManejadorPersistenciaImpl implements ManejadorPersistencia {

    @Autowired
    DataSource dataSource;

    @Override
    public Cuenta buscarCuenta(String numero) {
        //Obtener una conexion a la base de datos
        try (var con = dataSource.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("select * from cuentas where numero=?");
            pstmt.setString(1, numero);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Cuenta cuenta = new Cuenta();

                cuenta.setId(rs.getInt("id"));
                cuenta.setNumero(rs.getString("numero"));
                cuenta.setSaldo(rs.getDouble("saldo"));

                return cuenta;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        throw new RuntimeException("Cuenta no encontrada: " + numero);
    }

    @Override
    public void actualizarSaldo(Cuenta cuenta, double monto) {
        try (var con = dataSource.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("update cuentas set saldo = saldo + ? where numero=?");

            pstmt.setDouble(1, monto);
            pstmt.setString(2, cuenta.getNumero());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
