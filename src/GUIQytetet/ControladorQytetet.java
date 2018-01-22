/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import qytetetjava.*;

/**
 *
 * @author pepe
 */
public class ControladorQytetet extends javax.swing.JFrame {
    Qytetet juego;
    
    public void actualizar(Qytetet j){
        vistaQytetet.actualizar(j);
        this.juego = j;
        enableComenzarTurno();
        
    }
    
    public void finJuego() {
        disableBotones();
        JOptionPane.showMessageDialog(this, juego.obtenerRanking().toString());        
    }
    
    public void enableComenzarTurno(){
        this.comprar.setEnabled(false);
        this.pasarTurno.setEnabled(false);
        this.aplicarSorpresa.setEnabled(false);
        this.salirCarcelPagando.setEnabled(false);
        this.salirCarcelTirandoDado.setEnabled(false);
        //this.gestionInmobiliaria.setEnabled(false);
        if(juego.getJugadorActual().getEncarcelado()){
            this.salirCarcelPagando.setEnabled(true);
            this.salirCarcelTirandoDado.setEnabled(true);
        } else {
            this.jugar.setEnabled(true);            
        }
    }
    
    public void disableBotones() {
        this.comprar.setEnabled(false);
        this.pasarTurno.setEnabled(false);
        this.aplicarSorpresa.setEnabled(false);
        this.salirCarcelPagando.setEnabled(false);
        this.salirCarcelTirandoDado.setEnabled(false);
        this.jugar.setEnabled(false);   
        //this.gestionInmobiliaria.setEnabled(false);
    }
    
    private void comprobarCambios(int saldo, boolean encarcelado) {
        if (saldo != juego.getJugadorActual().getSaldo()) {
            JOptionPane.showMessageDialog(this, "Tu saldo es: " + (juego.getJugadorActual().getSaldo() - saldo));
        }
        if (encarcelado != juego.getJugadorActual().getEncarcelado()) {
            JOptionPane.showMessageDialog(this, "Ahora estás encarcelado");
        }
    }
    
    private Casilla elegirPropiedad() {
        ArrayList<TituloPropiedad> propiedades = juego.getJugadorActual().getPropiedades();
        ArrayList<String> nombresPropiedades = new ArrayList();
        String[] propiedadesMenu = new String[propiedades.size()];
        
        for (TituloPropiedad propiedad: propiedades) {
            nombresPropiedades.add(propiedad.getNombre());
        }
        
        propiedadesMenu = nombresPropiedades.toArray(propiedadesMenu);
        
        int eleccion = JOptionPane.showOptionDialog(null, "Selecciona la propiedad que deseas:", "Elección Propiedad", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, null, propiedadesMenu, propiedadesMenu[0]);
        
        return propiedades.get(eleccion).getCasilla();
    }
    
    
    
    /**
     * Creates new form ControladorQytetet
     */
    public ControladorQytetet() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistaQytetet = new GUIQytetet.VistaQytetet();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        salirCarcelTirandoDado = new javax.swing.JButton();
        salirCarcelPagando = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comprar = new javax.swing.JButton();
        aplicarSorpresa = new javax.swing.JButton();
        pasarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones del Juego", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salir de la Cárcel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        salirCarcelTirandoDado.setText("Tirando Dado");
        salirCarcelTirandoDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirCarcelTirandoDadoActionPerformed(evt);
            }
        });

        salirCarcelPagando.setText("Pagando");
        salirCarcelPagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirCarcelPagandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(salirCarcelTirandoDado)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirCarcelPagando)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirCarcelTirandoDado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salirCarcelPagando)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestiones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        comprar.setText("Comprar");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        aplicarSorpresa.setText("Aplicar Sorpresa");
        aplicarSorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarSorpresaActionPerformed(evt);
            }
        });

        pasarTurno.setText("Pasar Turno");
        pasarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pasarTurno)
                        .addGap(28, 28, 28))
                    .addComponent(aplicarSorpresa)
                    .addComponent(comprar))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(comprar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aplicarSorpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pasarTurno)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugar)
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugar))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirCarcelTirandoDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirCarcelTirandoDadoActionPerformed
        boolean resultado = juego.intentarSalirCarcel(0);
        this.salirCarcelPagando.setEnabled(false);
        this.salirCarcelTirandoDado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Has salido de la cárcel");
            this.jugar.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(this, "No puedes salir de la cárcel");
            this.pasarTurno.setEnabled(true);
        }
        this.vistaQytetet.actualizar(juego); 
    }//GEN-LAST:event_salirCarcelTirandoDadoActionPerformed

    private void salirCarcelPagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirCarcelPagandoActionPerformed
        boolean resultado = juego.intentarSalirCarcel(1);
        this.salirCarcelPagando.setEnabled(false);
        this.salirCarcelTirandoDado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Has salido de la cárcel");
            this.jugar.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(this, "No puedes salir de la cárcel");
            this.pasarTurno.setEnabled(true);
        }
        this.vistaQytetet.actualizar(juego);
    }//GEN-LAST:event_salirCarcelPagandoActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        boolean activarSorpresa = false, activarSiguienteJugador = false, activarComprar = false, activarGestion = false;
        int saldoActual = juego.getJugadorActual().getSaldo();
        boolean encarceladoActual = juego.getJugadorActual().getEncarcelado();
        
        System.out.println("Esta encacelador: " + encarceladoActual);
        
        boolean tienePropietario = juego.jugar();
        
        this.vistaQytetet.actualizar(juego);        
        
        if (juego.getJugadorActual().getSaldo() > 0) {
            if (!juego.getJugadorActual().getEncarcelado()) {
                if (qytetetjava.TipoCasilla.CALLE == juego.getJugadorActual().getCasillaActual().getTipo()) {
                    if (!tienePropietario) {
                        activarComprar = true;                        
                    } else {
                        String propietario = ((qytetetjava.Calle)juego.getJugadorActual().getCasillaActual()).getTitulo().getPropietario().getNombre();
                        
                        if (propietario != juego.getJugadorActual().getNombre()) {
                            JOptionPane.showMessageDialog(this, "Has caido en la casilla de " + propietario);
                        }
                        
                        activarSiguienteJugador = true;
                        activarGestion = true;
                    }
                } else if (qytetetjava.TipoCasilla.SORPRESA == juego.getJugadorActual().getCasillaActual().getTipo() ) {
                    JOptionPane.showMessageDialog(this, "Has caido en una casilla de tipo Sorpresa");
                    activarSorpresa = true;
                } else if (qytetetjava.TipoCasilla.IMPUESTO == juego.getJugadorActual().getCasillaActual().getTipo() ){
                    JOptionPane.showMessageDialog(this, "Has caido en una casilla de tipo Impuesto");
                    activarSiguienteJugador = true;   
                    activarGestion = true;
                } else {
                    activarSiguienteJugador = true;
                    activarSorpresa = false;
                    activarGestion = true;
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "El Juez te ha mandado a la cárcel");
                activarSiguienteJugador = true;
            }
            
        } else {
            finJuego();
        }
        
        comprobarCambios(saldoActual, encarceladoActual);
                
        this.jugar.setEnabled(false);
        this.pasarTurno.setEnabled(activarSiguienteJugador);
        this.aplicarSorpresa.setEnabled(activarSorpresa);
        this.comprar.setEnabled(activarComprar);
                
        //if (activarGestion) {
        //    habilitarGestionInmobiliaria();
        //}
    }//GEN-LAST:event_jugarActionPerformed

    private void pasarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarTurnoActionPerformed
        juego.siguienteJugador();
        actualizar(juego);
        
        if (juego.getJugadorActual().getSaldo() <= 0) {
            finJuego();
        }
    }//GEN-LAST:event_pasarTurnoActionPerformed

    private void aplicarSorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarSorpresaActionPerformed
        JOptionPane.showMessageDialog(this, juego.getTextoCarta());
        int saldoActual = juego.getJugadorActual().getSaldo();        
        boolean encarceladoActual = juego.getJugadorActual().getEncarcelado();
        boolean activarGestion = true, activarSiguienteJugador = true;
        
        boolean res = juego.aplicarSorpresa();        
        
        this.vistaQytetet.actualizar(juego);
        
        comprobarCambios(saldoActual, encarceladoActual);
        
        if (juego.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.CALLE) {
            this.comprar.setEnabled(!res);
            activarGestion = activarSiguienteJugador = false;
        }
        
        this.aplicarSorpresa.setEnabled(false);
        this.pasarTurno.setEnabled(activarSiguienteJugador);
        
        //if (activarGestion) {
        //   habilitarGestionInmobiliaria();
        //}        
    }//GEN-LAST:event_aplicarSorpresaActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        int saldo = juego.getJugadorActual().getSaldo();
        qytetetjava.Calle calle = (qytetetjava.Calle) juego.getJugadorActual().getCasillaActual();
        int opcion = JOptionPane.showConfirmDialog(null,  "¿Quieres adquirir esta propiedad?\nSaldo Disponible: " + saldo, "Menú Comprar", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            boolean comprado = juego.comprarTituloPropiedad(calle);
            
            if (comprado) {
                this.vistaQytetet.actualizar(juego);
                JOptionPane.showMessageDialog(this, "Acabamos de añadir la propiedad a tu lista de propiedades");                
            }
        }
        
        this.comprar.setEnabled(false);
        this.pasarTurno.setEnabled(true);
        
        //habilitarGestionInmobiliaria();
    }//GEN-LAST:event_comprarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ControladorQytetet controlador = new ControladorQytetet();
        CapturaNombreJugadores c = new CapturaNombreJugadores(controlador, true);
        ArrayList<String> nombres = c.obtenerNombres();
        
        Qytetet j = Qytetet.getInstance();
        Dado.createInstance(controlador);
        j.inicializarJuego(nombres);
        
        controlador.actualizar(j);
        
        controlador.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarSorpresa;
    private javax.swing.JButton comprar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jugar;
    private javax.swing.JButton pasarTurno;
    private javax.swing.JButton salirCarcelPagando;
    private javax.swing.JButton salirCarcelTirandoDado;
    private GUIQytetet.VistaQytetet vistaQytetet;
    // End of variables declaration//GEN-END:variables
}