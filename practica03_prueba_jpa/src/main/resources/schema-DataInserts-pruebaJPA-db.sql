-- DATOS PARA POSTGRESQL
-- Insertar departamentos
INSERT INTO departamento (nombre, ubicacion) VALUES ('Recursos Humanos', 'Edificio A');
INSERT INTO departamento (nombre, ubicacion) VALUES ('Tecnologia', 'Edificio B');
INSERT INTO departamento (nombre, ubicacion) VALUES ('Marketing', 'Edificio C');

-- Insertar empleados
INSERT INTO empleado (nombre, email, salario, fecha_ingreso, department_id)
VALUES ('Juan Perez', 'juan.perez@empresa.com', 50000, '2021-06-15', 2);
INSERT INTO empleado (nombre, email, salario, fecha_ingreso, department_id)
VALUES ('Ana Martinez', 'ana.martinez@empresa.com', 45000, '2022-01-10', 1);
INSERT INTO empleado (nombre, email, salario, fecha_ingreso, department_id)
VALUES ('Carlos Gomez', 'carlos.gomez@empresa.com', 40000, '2023-03-21', 3);

-- Relacionar empleados con roles
INSERT INTO empleado_rol (employee_id, role_id) VALUES (1, 1); -- Juan Perez es Gerente
INSERT INTO empleado_rol (employee_id, role_id) VALUES (1, 2); -- Juan Perez es tambien Desarrollador
INSERT INTO empleado_rol (employee_id, role_id) VALUES (2, 3); -- Ana Martinez es Disenadora
INSERT INTO empleado_rol (employee_id, role_id) VALUES (3, 2); -- Carlos Gomez es Desarrollador
