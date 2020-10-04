/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesrn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrador
 */
public class RedBlackTreeViewer extends javax.swing.JFrame {

    static int i = 90;

    /**
     * Creates new form RedBlackTreeViewer
     */
    public RedBlackTreeViewer() {
        initComponents();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawString("hola", 0, 0);
    }

    public static int dis() {
        i += 18;
        return i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedBlackTreeViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedBlackTreeViewer().setVisible(true);
            }
        });*/
        Rojinegros arbol = new Rojinegros();

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(entrada);

        arbol.inicializar();
        String aux;
        //int v;

        final JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(0, 1));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        //int i = 90;
        JButton insertar = new JButton("Insertar");
        JButton eliminar = new JButton("Eliminar");
        JButton dibujar = new JButton("Dibujar");
        JTextField numInserta = new JTextField();

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v;
                v = Integer.parseInt(numInserta.getText());
                arbol.insertar(v);
                arbol.num = 0;
                /*
                System.out.println("si");
                JLabel a = new JLabel("si");
                int j;
                j = dis();
                a.setBounds(j,10,20,20);
                panel.add(a);
                panel.updateUI();
                panel.repaint();*/
            }

        });
        
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v;
                v = Integer.parseInt(numInserta.getText());
                arbol.eliminar(arbol.Raiz(), v);
                arbol.num = 0;
                
                System.out.println("si");
                /*
                JLabel a = new JLabel("si");
                int j;
                j = dis();
                a.setBounds(j,10,20,20);
                panel.add(a);
                panel.updateUI();
                panel.repaint();*/
            }

        });

        dibujar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arbol.inorden(arbol.Raiz(), 0, "a");
                System.out.println("array");
                //JPanel panelDibujo = new JPanel();
                //panelDibujo.setBounds(0,90,200,200);
                //JLabel ps = new JLabel("dddd");
                //ps.setBounds(30,30,50,50);
                //panelDibujo.add(ps);
                //panel.add(panelDibujo);
                panel.removeAll();
                 panel.add(insertar);
                panel.add(numInserta);
                panel.add(eliminar);
                panel.add(dibujar);

                                
                pintar(arbol.num, arbol.data(), panel);
                /*for (int i = 2; i < arbol.inordenData.size(); i++) {
                    String[] parts = arbol.inordenData.get(i).split(".");
                    System.out.print(" " + arbol.inordenData.get(i));
                }*/
                panel.updateUI();
                panel.repaint();
               // panelDibujo.updateUI();
               // panelDibujo.repaint();
                
                arbol.cleanData();
            }

        });
        insertar.setBounds(100, 0, 80, 25);
        dibujar.setBounds(0, 30, 80, 25);
        numInserta.setBounds(0, 0, 90, 25);
        eliminar.setBounds(200, 0, 80, 25);


        panel.add(insertar);
        panel.add(numInserta);
        panel.add(dibujar);
        panel.add(eliminar);
  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

    }

    static void pintar(int size, ArrayList<String> nodo, JPanel panel) {
        int aa = 0;
        int bb = 15;
        int cc = 45;
        int dd = 105;
        int ee = 55;
        for (int i = 2; i < nodo.size(); i++) {
            String nodoPuntos = nodo.get(i);
            String[] parts = nodoPuntos.split("-");
            JLabel a = new JLabel(parts[0]);
            if ("R".equals(parts[1])) {
                a.setForeground(Color.red);
            }else{
                a.setForeground(Color.black);
            }
            int position = size - Integer.parseInt(parts[2]);
            switch(position){
                case 0:
                    a.setBounds(aa,size*45,30,30);
                    aa = aa+30;
                    break;
                case 1:
                    a.setBounds(bb,(size-1)*45,30,30);
                    bb = bb+45;
                    break;
                case 2: 
                    a.setBounds(cc,(size-2)*45,30,30);
                    cc = cc + 105;
                    break;
                case 3: 
                    a.setBounds(dd,(size-3)*45,30,30);
                    dd = dd + 45;
                    break;
                case 4:
                    a.setBounds(ee,(size-4)*45,30,30);
                    ee = ee + 55;
                    break;
            }
            panel.add(a);
            
            System.out.print(" " + nodo.get(i));
        }
        //panel.updateUI();
        //panel.repaint();
     
        System.out.println("a");
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
