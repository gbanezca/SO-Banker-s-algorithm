package vista;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.Algoritmo_banquero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gbanezca
 */
public class Ventana extends javax.swing.JFrame {

    //Variables de la interfaz
    ArrayList<String> guardacol; 
    ArrayList<String> guardafil;
    String[] columna;
    String[] fila;
    Algoritmo_banquero algoritmo;
    boolean firstUpdate, simulado = false;
    String leyenda = "";
    boolean automatico;

    //constructor 
    public Ventana(ArrayList guardafil, ArrayList guardacol, boolean automatico) {
        initComponents();
        setLocationRelativeTo(null);
        this.guardafil = guardafil;//se le pasa los arrays creados en entrada
        this.guardacol = guardacol;//se le pasa los arrays creados en entrada
        this.columna = new String[guardacol.size()]; //guarda los datos del array guardacol
        this.fila = new String[guardafil.size()]; //guarda los datos del array guardafil
        algoritmo = new Algoritmo_banquero(guardafil.size(), guardacol.size()); //se crea el objeto de la clase algoritmo 
        firstUpdate = true; //variable para control y verificacion del proceso
        this.automatico = automatico; //variable que nos indicara el modo de carga de data 

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        sucursales = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        asignados = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        maximos = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        arrayDisponibles = new javax.swing.JTable();
        generarTablas = new javax.swing.JButton();
        iniciar = new javax.swing.JButton();
        labelMaximos = new javax.swing.JLabel();
        labelAsignados = new javax.swing.JLabel();
        labelDisponibles = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        llenadoFila = new javax.swing.JCheckBox();
        llenadoCelda = new javax.swing.JCheckBox();
        botonLeyenda = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        sucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sucursales.setAutoscrolls(false);
        sucursales.setColumnSelectionAllowed(true);
        sucursales.setIntercellSpacing(new java.awt.Dimension(2, 2));
        sucursales.setOpaque(false);
        sucursales.setRowHeight(30);
        sucursales.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(sucursales);
        sucursales.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (sucursales.getColumnModel().getColumnCount() > 0) {
            sucursales.getColumnModel().getColumn(0).setPreferredWidth(90);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 390));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        asignados.setBackground(new java.awt.Color(102, 204, 255));
        asignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        asignados.setAutoscrolls(false);
        asignados.setCellSelectionEnabled(true);
        asignados.setIntercellSpacing(new java.awt.Dimension(2, 2));
        asignados.setOpaque(false);
        asignados.setRowHeight(30);
        asignados.setSurrendersFocusOnKeystroke(true);
        asignados.getTableHeader().setReorderingAllowed(false);
        asignados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asignadosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(asignados);
        asignados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 350, 390));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        maximos.setBackground(new java.awt.Color(102, 204, 255));
        maximos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        maximos.setAutoscrolls(false);
        maximos.setIntercellSpacing(new java.awt.Dimension(2, 2));
        maximos.setOpaque(false);
        maximos.setRowHeight(30);
        maximos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        maximos.setSurrendersFocusOnKeystroke(true);
        maximos.getTableHeader().setResizingAllowed(false);
        maximos.getTableHeader().setReorderingAllowed(false);
        maximos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximosMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(maximos);
        maximos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        maximos.getAccessibleContext().setAccessibleName("");
        maximos.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 350, 390));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        arrayDisponibles.setAutoCreateRowSorter(true);
        arrayDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        arrayDisponibles.setCellSelectionEnabled(true);
        arrayDisponibles.setIntercellSpacing(new java.awt.Dimension(2, 2));
        arrayDisponibles.setOpaque(false);
        arrayDisponibles.setRowHeight(24);
        arrayDisponibles.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(arrayDisponibles);
        arrayDisponibles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 350, 50));

        generarTablas.setText("Generar Tablas");
        generarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarTablasActionPerformed(evt);
            }
        });
        getContentPane().add(generarTablas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 130, -1));

        iniciar.setText("Iniciar Simulacion");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        getContentPane().add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 530, 150, -1));

        labelMaximos.setForeground(new java.awt.Color(0, 0, 0));
        labelMaximos.setText("Maximo empleados por sede");
        getContentPane().add(labelMaximos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        labelAsignados.setForeground(new java.awt.Color(0, 0, 0));
        labelAsignados.setText("Empleados asignados por sede");
        getContentPane().add(labelAsignados, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 180, -1));

        labelDisponibles.setForeground(new java.awt.Color(0, 0, 0));
        labelDisponibles.setText("Empleados Disponibles");
        getContentPane().add(labelDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 220, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        llenadoFila.setText("Editor por fila");
        llenadoFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llenadoFilaActionPerformed(evt);
            }
        });
        getContentPane().add(llenadoFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        llenadoCelda.setText("Editor por celda");
        llenadoCelda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llenadoCeldaActionPerformed(evt);
            }
        });
        getContentPane().add(llenadoCelda, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        botonLeyenda.setText("Leyenda de columnas");
        botonLeyenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLeyendaActionPerformed(evt);
            }
        });
        getContentPane().add(botonLeyenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        ayuda.setText("?");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });
        getContentPane().add(ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Modificaciones de usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        mostrar.setText("Mostrar Consola");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo_ventana.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarTablasActionPerformed
        //firstUpdate nos ayuda a controlar y checkear que el generador de tablas ya fue accionado, solo funciona una vez 
        if (firstUpdate) {
            
            //Aqui se pasan los datos de las columnas (cargos) y filas (sucursales). Los encabezados como tal, y la dimension de la tabla 
            pasar_sucursales(sucursales, cambio(guardafil, fila));
            pasar_datos(maximos, letraColumna(cambio(guardacol, columna)), cambio(guardafil, fila));
            pasar_datos(asignados, letraColumna(cambio(guardacol, columna)), cambio(guardafil, fila));
            pasar_array(arrayDisponibles, letraColumna(cambio(guardacol, columna)));

            //Si la carga de data es automatica, se recurre a Math.random() para generar valores 
            if (automatico) {

                for (int i = 0; i < guardafil.size(); i++) {
                    for (int j = 0; j < guardacol.size(); j++) {
                        asignados.setValueAt(1, i, j);
                        maximos.setValueAt((int) (Math.random() * 10) + 1, i, j);
                        arrayDisponibles.setValueAt(10, 0, j);
                    }
                }
            
            //Si la carga de data es manual, se recurre a inicializar los valores de tablas en 0
            } else {

                for (int i = 0; i < guardafil.size(); i++) {
                    for (int j = 0; j < guardacol.size(); j++) {
                        asignados.setValueAt(0, i, j);
                        maximos.setValueAt(0, i, j);
                        arrayDisponibles.setValueAt(0, 0, j);
                    }
                }

            }
            //se convierte en falso, ya que el proceso se realiza una unica vez
            firstUpdate = false;
        } else {
            //verificacion
            JOptionPane.showMessageDialog(null, "Ya el formato de dimesion ha sido establecido",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_generarTablasActionPerformed

    //Aqui comienza el algoritmo a funcionar 
    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        //Tambien funciona una unica vez, por eso el boolean simulado como comprobacion
        if (!simulado) {
            //el usuario primero tiene que generar las tablas, obviamente
            if (!firstUpdate) {
                try {
                    //si las llenó, manual o automatico no importa, los datos se utilizan para generar la matrizque usa el algoritmo
                    algoritmo.rellenarMatrices(asignados, maximos, arrayDisponibles);
                    //Se aplica el algoritmo
                    algoritmo.esSeguro(asignados, maximos, arrayDisponibles, sucursales);
                    //boolean para que el proceso se realice una unica vez
                    simulado = true;
                } catch (Exception e) {
                    //si el usuario se equivoca en los valores de la tabla 
                    JOptionPane.showMessageDialog(null, "Valor invalido en las tablas\nRevise que todo tenga valores asignados\nEspecificamente valores numéricos",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                //el usuario primero tiene que generar las tablas, obviamente
                JOptionPane.showMessageDialog(null, "Primero debe presionar el boton *Generar Tablas*",
                        "AVISO", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            //Funciona una unica vez
            JOptionPane.showMessageDialog(null, "Ya realizaste la simulación,\npuedes chequear en *Mostrar Consola*",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_iniciarActionPerformed

    //ayuda visual para el usuario, ya que por motivos de espacio el encabezado de las columnas 
    //solo contempla la primera letra de cada cargo
    private void botonLeyendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLeyendaActionPerformed
        if (columna.length > 0) {
            for (int i = 0; i < columna.length; i++) {
                leyenda += columna[i].toUpperCase().charAt(0) + " ---> " + columna[i].toLowerCase() + "\n";
            }
            JOptionPane.showMessageDialog(null, leyenda);
            leyenda = "";
        } else {
            JOptionPane.showMessageDialog(null, "Por favor genere las tablas");
        }


    }//GEN-LAST:event_botonLeyendaActionPerformed

    
    //El usuario puede escoger la forma de llenado o modificacion de los valores de las tablas como mas les convenga 
    //Este es el caso de llenado por filas, modifica la seleccion de las filas en vez de por celda 
    
    private void llenadoFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llenadoFilaActionPerformed

        if (llenadoFila.isSelected()) {
            llenadoCelda.setSelected(false);
            maximos.setRowSelectionAllowed(true);
            maximos.setCellSelectionEnabled(false);
            asignados.setRowSelectionAllowed(true);
            asignados.setCellSelectionEnabled(false);
            arrayDisponibles.setRowSelectionAllowed(true);
            arrayDisponibles.setCellSelectionEnabled(false);
        }


    }//GEN-LAST:event_llenadoFilaActionPerformed

    //el usuario seleciona una fila y por joptions se le pedira que ingrese los datos de izquierda a derecha
    private void maximosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximosMouseClicked

        if (llenadoFila.isSelected() == false && llenadoCelda.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de llenado",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (llenadoFila.isSelected()) {
            int seleccionar = maximos.rowAtPoint(evt.getPoint());
            for (int i = 0; i < columna.length; i++) {
                String response = JOptionPane.showInputDialog(null, "Ingrese el maximo de empleados\nSUCURSAL: " + fila[i] + "\nCARGO: " + columna[i]);
                maximos.setValueAt(response, seleccionar, i);
            }
        }

    }//GEN-LAST:event_maximosMouseClicked

    //El usuario puede escoger la forma de llenado o modificacion de los valores de las tablas como mas les convenga 
    //Este es el caso de llenado por celdas, modico las propiedades de las tablas relacionados a esto    
    private void llenadoCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llenadoCeldaActionPerformed

        if (llenadoCelda.isSelected()) {
            llenadoFila.setSelected(false);
            //JOptionPane.showMessageDialog(null, "Opción: Original\nInicializa matriz 6x6");
            maximos.setRowSelectionAllowed(false);
            maximos.setCellSelectionEnabled(true);
            asignados.setRowSelectionAllowed(false);
            asignados.setCellSelectionEnabled(true);
            arrayDisponibles.setRowSelectionAllowed(false);
            arrayDisponibles.setCellSelectionEnabled(true);
        }


    }//GEN-LAST:event_llenadoCeldaActionPerformed

    //el usuario seleciona una fila y por joptions se le pedira que ingrese los datos de izquierda a derecha
    private void asignadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asignadosMouseClicked
        if (llenadoFila.isSelected() == false && llenadoCelda.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de llenado",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (llenadoFila.isSelected()) {
            int seleccionar = maximos.rowAtPoint(evt.getPoint());
            for (int i = 0; i < columna.length; i++) {
                String response = JOptionPane.showInputDialog(null, "Ingrese el numero de empleados asignados\n SUCURSAL: " + fila[i] + "\nCARGO: " + columna[i]);
                maximos.setValueAt(response, seleccionar, i);
            }
        }
    }//GEN-LAST:event_asignadosMouseClicked

    //salida de la ejecucion del programa
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    //muestra el registro de la simulacion en la interfaz consola
    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        Entrada.consola.setVisible(true);
    }//GEN-LAST:event_mostrarActionPerformed

    //boton de ayuda al usuario, para que conozca el fucionamiento del promgrama 
    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        JOptionPane.showMessageDialog(null, "Esta es la vetana del simulador del algoritmo del banquero"
                + "\n- Para mostrar las tablas, presione el  boton *Generar Tablas*"
                + "\n- Ya sea que las configuraciones de llenado sean *automatico* o *manual* podras modificar los datos"
                + "\n- La modificacion de datos puede hacerse segun filas o celdas, tiene que selecionar una de estas opciones"
                + "\n- Para ver el registro del programa y como trabaja vaya a *Mostrar Consola*"
                + "\n- Si tiene dudas acerca del encabezado de las columnas vaya a *Leyenda*");
    }//GEN-LAST:event_ayudaActionPerformed

    //las jtable solo admiten vectore String asi que con este metodo se pasa de arraylist a vectores 
    //para pasar los datos ingresados en la interfaz entrada, y pasalor a un "formato" de vector 
    public String[] cambio(ArrayList array, String[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = array.get(i).toString();
        }
        return vector;
    }

    //metodo que me permite generar las filas y columnas de las tablas con sus encabezados
    //segun la informacion reloectada en la interfaz entrada
    public void pasar_datos(JTable tabla, String[] columna, String[] fila) {
        DefaultTableModel dtm = new DefaultTableModel(null, columna);
        String[] filaVacia = new String[columna.length];
        for (int i = 0; i < fila.length; i++) {
            dtm.addRow(filaVacia);
        }
        tabla.setModel(dtm);
    }

    //Por motivos de estetica queria que los encabezados  de las columnas solo mostraran la inicial de cada cargo 
    //asi cabian mas cargos en la tabla de la interfaz 
    public String[] letraColumna(String[] columna) {
        String[] letraColumna = new String[columna.length];
        for (int i = 0; i < columna.length; i++) {
            letraColumna[i] = columna[i].toUpperCase().charAt(0) + "";
        }
        return letraColumna;
    }

    //misma funcion de pasar dartos pero con la jtable de disponibles, y como solo tiene 1 fila siempre, preferí
    //hacer otro metodo
    public void pasar_array(JTable tabla, String[] columna) {
        DefaultTableModel array = new DefaultTableModel(null, columna);
        String[] filaVacia = new String[columna.length];
        array.addRow(filaVacia);
        tabla.setModel(array);
    }

    //Para llenar la tabla de las sucursales segun el arraylist de guardafil
    public void pasar_sucursales(JTable tabla, String[] fila) {
        DefaultTableModel sucur = new DefaultTableModel(new Object[][]{}, new String[]{"Sucursal"});

        for (int i = 0; i < fila.length; i++) {
            String[] filaAux = new String[1];
            filaAux[0] = fila[i];
            sucur.addRow(filaAux);
        }
        tabla.setModel(sucur);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable arrayDisponibles;
    public javax.swing.JTable asignados;
    private javax.swing.JButton ayuda;
    private javax.swing.JButton botonLeyenda;
    private javax.swing.JButton generarTablas;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelAsignados;
    private javax.swing.JLabel labelDisponibles;
    private javax.swing.JLabel labelMaximos;
    private javax.swing.JCheckBox llenadoCelda;
    private javax.swing.JCheckBox llenadoFila;
    public javax.swing.JTable maximos;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton salir;
    public javax.swing.JTable sucursales;
    // End of variables declaration//GEN-END:variables
}