
package controlador;

import modelo.Modelo;
import vista.Vista;

/**
 * @author Cortinez Juan José
 */
public class Main {

    
    public static void main(String[] args) {
        Vista v1 = new Vista();
        Modelo m1 = new Modelo();
        Controlador c1 = new Controlador(m1, v1);
    }

}
