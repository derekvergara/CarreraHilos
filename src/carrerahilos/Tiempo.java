package carrerahilos;

import static java.lang.Thread.sleep;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class Tiempo extends Thread {

    static boolean tiempo;

    PistaCarreras carrera1;

    public Tiempo(String name, PistaCarreras carrera) {
        super(name);
        this.carrera1 = carrera;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        int miliseg = 0;
        int seg = 0;
        int min = 0;
        int hora = 0;
        
        if (getName().equals("tiempo")) {
            while (true) {
                for (;;) {
                    if (tiempo=true) {
                        try {
                            sleep(1);
                            if (miliseg >= 1000) {
                                miliseg = 0;
                                seg++;
                            }

                            if (seg >= 60) {
                                miliseg = 0;
                                seg = 0;
                                min++;
                            }

                            if (min >= 60) {
                                miliseg = 0;
                                seg = 0;
                                min = 0;
                                hora++;
                            }

                            //carrera1.getTxtTiempo().setText(seg + "");
//                            carrera1.getLblCrono().setText(hora + " : " + min + " : " + seg + " : ");
//                            carrera1.getLblMilisec().setText(" " + miliseg);
                            carrera1.getTxtTiempo().setText(seg + " : "+" " + miliseg);
                            
                                miliseg++;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else {
                        break;
                    }
                }
            }

        }
        
    }

    public PistaCarreras getCarrera1() {
        return carrera1;
    }

    public void setCarrera1(PistaCarreras carrera1) {
        this.carrera1 = carrera1;
    }  
}
