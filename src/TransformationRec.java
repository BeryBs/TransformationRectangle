
import java.awt.*;
import java.awt.event.*;

public class TransformationRec extends Frame implements ActionListener {

    // Initialize coordinates of the triangle
    int[] x = {500,700,600};
    int[] y = {300,300,100};

    public TransformationRec() {
        int windowWidth = 800;
        int windowHeight = 800;

        addWindowListener(new MyFinishWindow());  // Add WindowListener to exit the program when window is closed
        setTitle("Transformations");  // Set title

        MenuBar menu_bar = new MenuBar();  // Create menu
        Menu def = new Menu("Set");
        def.add(new MenuItem("Set Default"));
        def.addActionListener(this);
        menu_bar.add(def);
        setMenuBar(menu_bar);

        Panel panel=new Panel();  // Add control panel
        panel.setBounds(0,40,windowWidth ,40);
        setLayout(new GridBagLayout());


        // Add buttons
        Button button_s = new Button();
        button_s.setLabel("Translate up"); //first button
        button_s.addActionListener(this);
        Button button_b = new Button();
        button_b.addActionListener(this);
        button_b.setLabel("Translate down"); //second button
        Button button_ = new Button();
        button_.addActionListener(this);
        button_.setLabel("Translate right"); //second button
        Button button2 = new Button();
        button2.addActionListener(this);
        button2.setLabel("Translate left"); //second button
        Button button3 = new Button();
        button3.addActionListener(this);
        button3.setLabel("Reflect X"); //second button
        Button button4 = new Button();
        button4.addActionListener(this);
        button4.setLabel("Reflect Y"); //second button

        panel.add(button_s);
        panel.add(button_b);
        panel.add(button_);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);


        //color of the panel
        panel.setBackground(Color.black);
        add(panel);
        setLayout(null); //setting layout
        setBackground(Color.getHSBColor(0.8f, 0.2f, 0.9f)); //setting background color

    }
    public class MyFinishWindow extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }
    // Draw 2 lines and paint 1 filled triangle
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; //g2d object
        g2d.setColor(Color.white); //white color for lines
        g2d.drawLine(400, 0, 400, 800); //drawing lines
        g2d.drawLine(0, 400, 800, 400);
        g2d.setColor(Color.black); //paint triangle black
        g2d.fillPolygon(x, y, 3); //fill triangle

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String but = e.getActionCommand();
        if(but.equals("Set Default")) { //default values of triangle
            x[0]=500;
            x[1]=700;
            x[2]=600;
            y[0]=300;
            y[1]=300;
            y[2]=100;
            repaint();

        }
        else if(but.equals("Translate up")) {  //translating triangle up

            y[0]=y[0]-30;
            y[1]=y[1]-30;
            y[2]=y[2]-30;
            repaint();
        }
        else if(but.equals("Translate down")) { //translating triangle down
            y[0]=y[0]+30;
            y[1]=y[1]+30;
            y[2]=y[2]+30;
            repaint();
        }
        else if(but.equals("Translate right")) { //translating triangle right
            x[0]=x[0]+30;
            x[1]=x[1]+30;
            x[2]=x[2]+30;

            repaint();
        }
        else if(but.equals("Translate left")) { //translating triangle left
            x[0]=x[0]-30;
            x[1]=x[1]-30;
            x[2]=x[2]-30;
            repaint();
        }
        else if(but.equals("Reflect X")) {  //Reflection to X

            y[0]=800-y[0];
            y[1]=800-y[1];
            y[2]=800-y[2];
            repaint();
        }
        else if(but.equals("Reflect Y")) { //Reflection to Y
            x[0]=800-x[0];
            x[1]=800-x[1];
            x[2]=800-x[2];
            repaint();
        }
    }
    public static void main(String[] args) {
        TransformationRec lab6=new TransformationRec();
        lab6.setSize(800, 800); // Set Frame s ize to 800x800)
        lab6.setVisible(true);// Make the vindow visible.
    }

}