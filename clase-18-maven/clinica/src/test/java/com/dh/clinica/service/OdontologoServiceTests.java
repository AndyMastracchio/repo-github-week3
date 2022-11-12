/*
package com.dh.clinica.service;

import dao.configuracion.ConfiguracionJDBC;
import dao.impl.OdontologoDaoH2;

import model.Odontologo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import service.OdontologoService;


import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class OdontologoServiceTests {

    private static OdontologoService odontologoService =
            new OdontologoService(new OdontologoDaoH2(new ConfiguracionJDBC()));

    @BeforeClass
    public static void cargarDataSet() {
        odontologoService.registrarOdontologo(
                new Odontologo("Santiago", "Paz", 3455647));
    }

    @Test
    public void guardarOdontologo() {
        Odontologo odontologo = odontologoService.registrarOdontologo(new Odontologo("Juan", "Ramirez", 348971960));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarPacienteTest() {
        odontologoService.eliminar(1);
        Assert.assertTrue(odontologoService.buscar(1).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

}
*/
