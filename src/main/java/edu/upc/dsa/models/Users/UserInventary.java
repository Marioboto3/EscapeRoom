package edu.upc.dsa.models.Users;

import edu.upc.dsa.models.ObjTO;

import java.util.List;

public class UserInventary {
    private List<ObjTO> lista;

    public UserInventary(List<ObjTO> lista) {
        this.lista = lista;
    }

    public UserInventary() {
    }

    public List<ObjTO> getLista() {
        return lista;
    }

    public void setLista(List<ObjTO> lista) {
        this.lista = lista;
    }
}
