package com.hotel.alura.controller;

import com.hotel.alura.dao.HuespedDao;
import com.hotel.alura.modelo.Reserva;

import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class HuespedController {

    private HuespedDao huespedDao;

    private EntityManager em;

    public HuespedController(){
        this.em = com.hotel.alura.utils.JPAUtils.getEntityManager();
        this.huespedDao = new HuespedDao(em);
    }

    public void guardar(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad,
                           String telefono, Reserva reserva){
        huespedDao.guardar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, reserva);}

    public DefaultTableModel listar(){
        return huespedDao.listar();
    }

    public void modificar(javax.swing.JTable tablaHuespedes){
        huespedDao.actualizar(tablaHuespedes);
    }

    public void eliminar(Long id){
        huespedDao.remover(id);
    }

    public DefaultTableModel buscarPorNumeroDeReservaOApellido(Long numeroDeReserva, String apellido) {
        return huespedDao.buscarPorNumeroDeReservaOApellido(numeroDeReserva, apellido);
    }
}