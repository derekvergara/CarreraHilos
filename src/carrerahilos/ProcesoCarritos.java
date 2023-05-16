package carrerahilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProcesoCarritos extends Thread {

    private JLabel etiqueta;
    private PistaCarreras auto;
    private PistaCarreras puesto;
    

    int miliseg = 0;
    int seg = 0;
    int min = 0;
    int hora = 0;

    public ProcesoCarritos(JLabel etiqueta, PistaCarreras auto) {
        this.etiqueta = etiqueta;
        this.auto = auto;

    }

    public ProcesoCarritos(PistaCarreras puesto) {
        this.puesto = puesto;
    }

    public ProcesoCarritos() {
    }

    //boolean inicio = true;
    @Override
    public void run() {
        //  super.run(); //To change body of generated methods, choose Tools | Templates.}
        int auto1 = 0;
        int auto2 = 0;
        int auto3 = 0;
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 250));
//                sleep((int) Math.random() * 1000);
                auto1 = auto.getLblCarro1().getLocation().x;
                auto2 = auto.getLblCarro2().getLocation().x;
                auto3 = auto.getLblCarro3().getLocation().x;

                if (auto1 < auto.getLblMeta().getLocation().x - 30 && auto2 < auto.getLblMeta().getLocation().x - 30 && auto3 < auto.getLblMeta().getLocation().x - 30) {
                    etiqueta.setLocation(etiqueta.getLocation().x + 10, etiqueta.getLocation().y);
                    auto.repaint();
                } else {

                    break;

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                if (etiqueta.getLocation().x >= auto.getMeta().getLocation().x - 30) {
                    if (auto1 > auto2 && auto1 > auto3) {
                        JOptionPane.showMessageDialog(null, "HA GANADO EL PRIMER CARRITO");
                        //Tiempo.tiempo=false;
                        //puesto.getPuesto1().setText("HA GANADO EL PRIMER CARRITO");

                    } else if (auto2 > auto1 && auto2 > auto3) {
                        JOptionPane.showMessageDialog(null, "HA GANADO EL SEGUNDO CARRITO");
                        //Tiempo.tiempo=false;
                        //puesto.getPuesto1().setText("HA GANADO EL SEGUNDO CARRITO");

                    } else if (auto3 > auto1 && auto3 > auto2) {
                        JOptionPane.showMessageDialog(null, "HA GANADO EL TERCER CARRITO");
                        //Tiempo.tiempo=false;
                        //puesto.getPuesto1().setText("HA GANADO EL TERCER CARRITO");

                    } else {
                        JOptionPane.showMessageDialog(null, "EMPATE");
                        //Tiempo.tiempo=false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }
}
