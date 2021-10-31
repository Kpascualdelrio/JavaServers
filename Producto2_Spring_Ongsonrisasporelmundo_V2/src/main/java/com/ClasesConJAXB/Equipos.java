package com.ClasesConJAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Equipos")
public class Equipos {
    List<Equipo> equipos;
    public List<Equipo> getEquipos() {
        return equipos;
    }

    @XmlElement(name = "Equipo")
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void add(Equipo equipo) {
        if (this.equipos == null) {
            this.equipos = new ArrayList<Equipo>();
        }
        this.equipos.add(equipo);

    }
}