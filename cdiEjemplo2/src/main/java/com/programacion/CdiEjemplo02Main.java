package com.programacion;

// Importación de las clases necesarias para CDI y los servicios
import com.programacion.servicios.MiBean;
import com.programacion.servicios.Operaciones;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class CdiEjemplo02Main {
    public static void main(String[] args) {
        ContainerLifecycle lifecycle = WebBeansContext.getInstance()
                .getService(ContainerLifecycle.class);

        lifecycle.startApplication(null);

        BeanManager beanManager = lifecycle.getBeanManager();

        Bean<?> bean = beanManager.getBeans(Operaciones.class, MiBean.Literal.INSTANCE)
                .iterator().next();

        var context = beanManager.createCreationalContext(bean);
        Operaciones servicio = (Operaciones) beanManager.getReference(bean, Operaciones.class, context);

        int resultado = servicio.sumar(5, 9);

        System.out.print("*************************Respuesta: " + resultado);
    }
}//FINAL CLASS
