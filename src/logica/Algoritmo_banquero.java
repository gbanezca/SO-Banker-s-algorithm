/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import vista.Entrada;

/**
 * @author Pedro Barrios
 * @author Ismenia Luces
 */
public class Algoritmo_banquero {
    /*Los procesos son las sucursales, hasta donde entiendo
        solo se pueden agregar mas al comienzo del programa y no
        puede haber menos de las 6 que salen en el enunciado,
        y los recursos son los empleados por categoria(cajeros, seguridad,
        empaquetamiento, limpieza, gerencia y abastecimiento)*/
    
    private int necesarios[][],
            asignados[][],
            maximos[][],
            disponibles[][],
            numeroProcesos, //no. de sucursales - filas
            numeroRecursos; //no. de categorias empleados -columnas
    
    int orden[];    // vector que contiene el orden en que se asignan los empleados a las sucursales
    String listaSucursales; //String que contiene los nombres de las sucursales en orden
    //Variables auxiliares para metodo esSeguro
    boolean done[]; 
    int j, contOrden; 

    /*Constructor de la clase se le pasan las filas y columnas para agilizar
    el proceso de inicializar las matrices para realizar los calculos*/
    public Algoritmo_banquero(int filas, int columnas){
        this.numeroProcesos = filas;
        this.numeroRecursos = columnas;
        entrada();
    }
    
    /*Metodo para inicializar las matrices y el vector orden*/
    public void entrada() {
        necesarios = new int[numeroProcesos][numeroRecursos];  //inicializacion de arrays
        maximos = new int[numeroProcesos][numeroRecursos];
        asignados = new int[numeroProcesos][numeroRecursos];
        disponibles = new int[1][numeroRecursos];
        orden = new int[numeroProcesos];
    }
    
    
    
    /*Metodo que extrae la informacion de las tablas en la interfaz
    para insertarlas en las matrices de esta clase*/
    public void rellenarMatrices(JTable inAsignados,
        JTable inMaximos,JTable inDisponibles){
        
        System.out.println("-------------------\n"
                + "Matriz asignados\n"
                + "-------------------");
        Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n"
                + "-------------------\n"
                + "Matriz asignados\n"
                + "-------------------\n");
        //matriz de asignados
        for (int i = 0; i < numeroProcesos; i++) {
            for (int j = 0; j < numeroRecursos; j++) {
                asignados[i][j] = Integer.parseInt(inAsignados.getValueAt(i,j).toString());
                System.out.print(asignados[i][j]+" ");
                Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+
                        + asignados[i][j]+" ");
            }
            System.out.println("");
            Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n");
        }
        
        System.out.println("-------------------\n"
                + "Matriz maxima\n"
                + "-------------------");
        Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n"
                + "-------------------\n"
                + "Matriz maxima\n"
                + "-------------------\n");
        
        //matriz maxima
        for (int i = 0; i < numeroProcesos; i++) {
            for (int j = 0; j < numeroRecursos; j++) {
                maximos[i][j] = Integer.parseInt(inMaximos.getValueAt(i,j).toString());  
                System.out.print(maximos[i][j]+" ");
                Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+ maximos[i][j]+" ");
            }
            System.out.println("");
            Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n");
        }

        System.out.println("-------------------\n"
                + "Matriz disponibles\n"
                + "-------------------");
        Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n"
                + "-------------------\n"
                + "Matriz disponibles\n"
                + "-------------------\n");
        //matriz de disponibles
        for (int j = 0; j < numeroRecursos; j++) {
            disponibles[0][j] = Integer.parseInt(inDisponibles.getValueAt(0,j).toString());  
            System.out.print(disponibles[0][j]+" ");
            
            Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+ disponibles[0][j]+" ");
        }
        Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n");
        
        
    }

    
    /*Metodo de verificacion*/
    public boolean revisarInputs(){
        for (int i = 0; i < numeroProcesos; i++) {
            for (int k = 0; k < numeroRecursos; k++) {
                if(maximos[i][k] < necesarios[i][k]){
                    JOptionPane.showMessageDialog(null, "Se ha excedido el limite de empleados maximos\n"
                            + "en la tabla de Empleados Necesarios en:"
                            + "Fila: "+i+" \nColumna: "+k, 
                            "ERROR DETECTADO", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                else if (maximos[i][k] < asignados[i][k]){
                    JOptionPane.showMessageDialog(null, "Se ha excedido el limite de empleados maximos\n"
                            + "en la tabla de Empleados Asignados en:"
                            + "Fila: "+i+" \nColumna: "+k, 
                            "ERROR DETECTADO", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                else if (maximos[i][k]<=0 || asignados[i][k]<0 || necesarios[i][k]<0 ||disponibles[0][k]<0){
                    if(maximos[i][k]==0){
                        JOptionPane.showMessageDialog(null, "Se requiere un maximo\n",
                            "ERROR DETECTADO", JOptionPane.ERROR_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "Valor menor a 0 detectado\n",
                            "ERROR DETECTADO", JOptionPane.ERROR_MESSAGE);
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    
    
    /*Metodo que calcula la matriz de necesarios*/
    private void calculoNecesarios() {
        for (int i = 0; i < numeroProcesos; i++) {
            for (int j = 0; j < numeroRecursos; j++){
                necesarios[i][j] = maximos[i][j] - asignados[i][j];
            }
        }

    }
    
    /*Metodo auxiliar para que el String listaSucursales tenga la lista
    de sucursales*/
    public void extraerSucursales(JTable sucursales){
        for (int i = 0; i < numeroProcesos; i++) {
            listaSucursales += "# "+sucursales.getValueAt(i,0).toString()+"\n";
            
        }
    }
    
    
    /*Metodo auxiliar para esSeguro, revisa si hay suficientes recursos
    disponibles para asignar a un proceso, o en este caso suficientes
    empleados para asignar a sucursales*/
    public boolean chequear(int i) {
        //chequeando si todos los recursos para el proceso pueden ser asignados
        for (int j = 0; j < numeroRecursos; j++) {
            if (disponibles[0][j] < necesarios[i][j]) {
                return false;
            }
        }

        return true;
    }
    
    
    /*Metodo principal de la clase, realiza el algorimo del banquero*/
    public void esSeguro(JTable inAsignados,
        JTable inMaximos,JTable inDisponibles, JTable sucursales) {
        
        //Reseteo del String por si se inicia de nuevo el algoritmo con data diferente
        listaSucursales="";
        
        //Rellena las matrices con informacion de las tablas en la interfaz
        rellenarMatrices(inAsignados, inMaximos, inDisponibles);
        
        calculoNecesarios();
        
        //Revisa si los contenidos de las matrices no causaran errores
        if (revisarInputs()){
            //Array de booleanos para revisar si a un proceso se le han asignado recursos
            done = new boolean[numeroProcesos];
            //variables auxiliares
            j = 0;
            contOrden=0;
            
            //For para ir recorriendo los procesos
            for (int i = 0; i < numeroProcesos; i++) {
                /*Se revisa si al proceso i se le han asignado recursos y ha terminado y si
                se le pueden asignar recursos, si el proceso i no ha terminado y se le pueden
                asignar recursos se entra en el if*/
                if (!done[i] && chequear(i)) {  
                    /*Como sabemos que al proceso i se le pueden asignar recursos se asume que 
                    el proceso termina de inmediato y se procede a actualizar el array de disponibles*/
                    for (int k = 0; k < numeroRecursos; k++) {
                        //disponibles[0][k] = disponibles[0][k] - necesarios[i][k] + maximos[i][k];
                        disponibles[0][k] = disponibles[0][k] + asignados[i][k];
                        asignados[i][k] = 0;
                    }
                    //sout verificacion
                    System.out.println("Proceso asignado : " + i);
                    Entrada.consola.areaConsola.setText(Entrada.consola.areaConsola.getText()+"\n"
                        + "Proceso asignado : " + i);
                    //Me di cuenta que contOrden no es necesario para asignar valores
                    //en el array orden, pude haber usado j
                    orden[contOrden]=i;
                    contOrden++;
                    /*Como ya se actualizo la matriz de disponibles y el proceso i
                    ha terminado se marca el proceso como listo*/
                    done[i] = true;
                    j++;
                    /*Como no se sabe si al momento de terminar el proceso i
                    ahora se le pueden asignar recursos a un proceso anterior se
                    vuelven a recorrer los procesos para verificar si hay procesos
                    sin terminar*/
                    i=-1;
                }
            }
            
            /*j es un valor auxiliar que sirve de contador, si j es igual
            al numero de procesos significa que a todos los procesos se le han
            asignado recursos y han podido terminar su ejecucion, de j no ser
            igual al numero de procesos significa que hay al menos un proceso
            que no ha podido terminar su ejecucion y por lo tanto ha ocurrido un
            interbloqueo*/
            if (j == numeroProcesos) {
                JOptionPane.showMessageDialog(null, "Procesos asignados con exito", 
                             "ASIGNACION CON EXITO", JOptionPane.INFORMATION_MESSAGE);
                
                for (int i = 0; i < numeroProcesos; i++) {
                    for (int k = 0; k < numeroRecursos; k++) {
                        inAsignados.setValueAt(asignados[i][k], i, k);
                        inMaximos.setValueAt(maximos[i][k], i, k);
                        inDisponibles.setValueAt(disponibles[0][k], 0, k);
                    }
                }
                
                extraerSucursales(sucursales);
                JOptionPane.showMessageDialog(null, "Orden de asignacion de empleados:\n"+listaSucursales, 
                             "ASIGNACION CON EXITO", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Se ha detectado un interbloqueo con los datos actuales", 
                            "INTERBLOQUEO DETECTADO", JOptionPane.WARNING_MESSAGE);
                for (int i = 0; i < numeroProcesos; i++) {
                    if(!done[i]){
                        listaSucursales += "# "+sucursales.getValueAt(i,0).toString()+"\n";
                    }
                }
                JOptionPane.showMessageDialog(null, "Interbloqueo detectado en sucursales:\n"+listaSucursales, 
                             "INTERBLOQUEO DETECTADO", JOptionPane.WARNING_MESSAGE);
            }
        } 
       
    }
}
