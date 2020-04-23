import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Traceur extends JFrame {

    private Courbe courbe;

    public Traceur(){
        super("Courbe");
        this.setSize(500, 500);

        this.courbe=new Courbe();

        this.courbe.ajouterPoint(new Point(   5, 6681.8929));
        this.courbe.ajouterPoint(new Point(10, 11834.3456));
        this.courbe.ajouterPoint(new Point(20, 37059.7267));
        this.courbe.ajouterPoint(new Point(30, 32249.5167));
        this.courbe.ajouterPoint(new Point(40, 11503.6712));
        this.courbe.ajouterPoint(new Point(50, 7485.3936));
        this.courbe.ajouterPoint(new Point(60, 5720.6952));
        this.courbe.ajouterPoint(new Point(70, 4762.9483));
        this.courbe.ajouterPoint(new Point(80, 4207.3249));
        this.courbe.ajouterPoint(new Point(90, 3880.5546));

        this.getContentPane().add(this.courbe);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public Traceur(String titre, Courbe courbe) {
        super(titre);
        this.setSize(800, 800);

        this.courbe=courbe;

        this.getContentPane().add(this.courbe);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

}