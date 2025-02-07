package com.programacion;

import com.programacion.db.Employee;
import com.programacion.repository.DepartmentRepository;
import com.programacion.repository.EmployeeRepository;
import com.programacion.repository.RoleRepository;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainPractica03 {
    public static void main(String[] args) {
        // Inicializar el contenedor CDI
        SeContainer container = SeContainerInitializer.newInstance().initialize();

        // Obtener los repositorios
        var repoEmployee = container.select(EmployeeRepository.class).get();
        var repoDepartment = container.select(DepartmentRepository.class).get();
        var repoRole = container.select(RoleRepository.class).get();

        // 5. Consultar Empleados y sus Relaciones
        System.out.println("\n=== Lista de Empleados ===");
        for (Employee emp : repoEmployee.findAll()) {
            System.out.println("Nombre: " + emp.getName());
            System.out.println("Departamento: " + emp.getDepartment().getName());
            System.out.print("Roles: ");
            emp.getRoles().forEach(role -> System.out.print(role.getName() + " "));
            System.out.println("\n----------------------");
        }

    }
}
