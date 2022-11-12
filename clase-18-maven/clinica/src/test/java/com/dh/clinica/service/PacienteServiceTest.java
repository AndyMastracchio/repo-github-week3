/*
package com.dh.clinica.service;


import dao.impl.DomicilioDaoH2;
import dao.impl.PacienteDaoH2;
import model.Domicilio;
import model.Paciente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import service.DomicilioService;
import service.PacienteService;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class PacienteServiceTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new DomicilioDaoH2()));
    private DomicilioService domicilioService = new DomicilioService(new DomicilioDaoH2());

    @BeforeClass
    public static void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }


}
*/
