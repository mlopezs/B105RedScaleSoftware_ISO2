package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Cancion;
import persistencia.ListaReproduccion;
import persistencia.Usuario;

/**
 * @version 1.1
 */
public class GestorListasReproduccion {

    // Simulacion BBDD
    private final LinkedList<ListaReproduccion> bbdd_ListasReprod;
    private final LinkedList<Usuario> bbdd_Usuarios;
    private final LinkedList<Cancion> bbdd_Canciones;

    /**
     * Constructor.
     *
     * @param bbddListasReprod
     * @param bbddUsuarios
     * @param bbddCanciones
     */
    public GestorListasReproduccion(
            LinkedList<ListaReproduccion> bbddListasReprod,
            LinkedList<Usuario> bbddUsuarios,
            LinkedList<Cancion> bbddCanciones) {
        this.bbdd_ListasReprod = bbddListasReprod;
        this.bbdd_Usuarios = bbddUsuarios;
        this.bbdd_Canciones = bbddCanciones;
    }

    /**
     *
     * @param idLista
     * @param idUsuario
     * @param nombreLista
     * @param canciones
     * @return
     */
    public boolean crearLR(int idLista, int idUsuario,
            String nombreLista, int[] canciones) {
        if (idUsuario < 0) {
            System.out.println("El id del usuario no es válido.");
            return false;
        }
        if (idLista < 0 || nombreLista == null || nombreLista.equals("")) {
            System.out.println("El id o nombre de la lista no son correctos");
            return false;
        }
        Iterator<Usuario> itUsuarios = bbdd_Usuarios.iterator();
        boolean flag = false;
        while (itUsuarios.hasNext()) {
            if (idUsuario == itUsuarios.next().getIdUsuario()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Usuario no encontrado");
            return false;
        }
        for (int auxIdCancion : canciones) {
            if (auxIdCancion < 0) {
                System.out.println("La cancion no es válida.");
                return false;
            }
        }
        ListaReproduccion listaReprNueva = new ListaReproduccion(idLista,
                nombreLista, idUsuario, canciones);
        bbdd_ListasReprod.add(listaReprNueva);
        System.out.println("Lista \"" + nombreLista + "\" añadida con éxito.");
        return true;
    }

    /**
     *
     * @param idListaReprod
     * @return
     */
    public boolean borrarLR(int idListaReprod) {
        if (idListaReprod < 0) {
            System.out.println("El id de la lista no es válido.");
            return false;
        }
        Iterator<ListaReproduccion> itListasReprod;
        itListasReprod = bbdd_ListasReprod.iterator();
        while (itListasReprod.hasNext()) {
            ListaReproduccion auxListaReprod = itListasReprod.next();
            if (idListaReprod == auxListaReprod.getId()) {
                bbdd_ListasReprod.remove(auxListaReprod);
                System.out.println("Lista \"" + auxListaReprod.getNombre()
                        + "\" eliminada con éxito.");
                return true;
            }
        }
        System.out.println("La lista de reproducción no existe");
        return false;
    }

    /**
     *
     * @param idListaReprod
     * @param lecturaTeclado
     * @return
     */
    public boolean modificarLR(int idListaReprod, String lecturaTeclado) {

        if (lecturaTeclado == null || lecturaTeclado.equals("")
                || idListaReprod < 0) {
            System.out.println("El id o nombre de la lista no son correctos");
            return false;
        }

        Iterator<ListaReproduccion> itListasReprod;
        itListasReprod = bbdd_ListasReprod.iterator();
        while (itListasReprod.hasNext()) {
            ListaReproduccion auxListaReprod = itListasReprod.next();
            if (idListaReprod == auxListaReprod.getId()) {
                String old = auxListaReprod.getNombre();
                System.out.println("Cambiar \"" + old + "\" a:");
                //Scanner sc = new Scanner(System.in);
                //String nuevo = sc.next();
                String nuevo = lecturaTeclado;
                auxListaReprod.setNombre(nuevo);
                System.out.println("El nombre de la lista \"" + old + "\" "
                        + "se ha cambiado a \"" + nuevo + "\".");
                return true;
            }
        }
        System.out.println("El nombre de la lista se ha cambiado con éxito.");
        return false;
    }

    /**
     *
     * @param idCancion
     * @param idLR
     * @return
     */
    public boolean añadirCancion(int idCancion, int idLR) {
        boolean adicion = false;
        adicion = gestionarCancion(idCancion, idLR, 0);
        return adicion;
    }

    /**
     *
     * @param idCancion
     * @param idLR
     * @return
     */
    public boolean eliminarCancion(int idCancion, int idLR) {
        boolean eliminacion = false;
        eliminacion = gestionarCancion(idCancion, idLR, 1);
        return eliminacion;
    }

    public boolean gestionarCancion(int idCancion, int idLR, int accion) {
        boolean flag = false;
        Iterator<ListaReproduccion> itListasReprod;
        itListasReprod = bbdd_ListasReprod.iterator();
        while (itListasReprod.hasNext()) {
            if (itListasReprod.next().getId() == idCancion) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("La cancion no existe.");
            return false;
        }
        Iterator<ListaReproduccion> itListasReprod2;
        itListasReprod2 = bbdd_ListasReprod.iterator();
        while (itListasReprod2.hasNext()) {
            ListaReproduccion auxListaReprod = itListasReprod2.next();
            if (idLR == auxListaReprod.getId()) {

                switch (accion) {
                    default:
                        System.out.println("ERROR, accion desconocida");
                        return false;
                    case 0: // Caso de añadir canción
                        auxListaReprod.setCanciones(juntar(
                                auxListaReprod.getCanciones(), idCancion));
                        System.out.println("La cancion se ha añadido "
                                + "con éxito a la lista de reproducción.");
                        return true;
                    case 1: // Caso de eliminar canción
                        auxListaReprod.setCanciones(separar(
                                auxListaReprod.getCanciones(), idCancion));
                        System.out.println("La canción ha sido "
                                + "retirada de la lista.");
                        return true;
                }
            }
        }
        System.out.println("La canción no pudo gestionarse");
        return false;
    }

    /**
     * Introduce en el vector 'canciones' el elemento 'idCancion'.
     *
     * @param canciones
     * @param c
     * @return
     */
    private int[] juntar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length + 1];
        System.arraycopy(canciones, 0, nuevo, 0, canciones.length);
        nuevo[nuevo.length - 1] = idCancion;
        return nuevo;
    }

    /**
     * Elimina del vector 'canciones' el elemento 'idCancion'.
     *
     * @param canciones
     * @param idCancion
     * @return
     */
    private int[] separar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length - 1];
        int nuevoLugar = 0;
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] != idCancion) {
                nuevo[nuevoLugar] = canciones[i];
            }
        }
        return nuevo;
    }

}
