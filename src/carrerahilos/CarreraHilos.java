package carrerahilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarreraHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        PistaCarreras pista = new PistaCarreras();
        pista.setVisible(true);
        
        pista.getBtnIniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tiempo hilo = new Tiempo("tiempo",pista);
                hilo.start();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

}
