package org.example.soccer.servicios;

import org.example.soccer.enums.Pos;
import org.example.soccer.modelo.Posicion;
import org.example.soccer.repositorio.PosicionRepoImp;

import java.util.List;

public class PosicionServicioImp implements PosicionServicio {
    PosicionRepoImp posImp;

    public PosicionServicioImp(){
        posImp = new PosicionRepoImp();
    }

    @Override
    public Posicion agregarPosicion(Posicion posicion) {
        return posImp.agregarPosicion(posicion);
    }

    @Override
    public List<Posicion> listarPosiciones() {
        return posImp.listarPosiciones();
    }

    @Override
    public void actualizarPosicion(Posicion posicion) {
        posImp.actualizarPosicion(posicion);

    }


}
