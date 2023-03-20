import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VolumeBalok extends JFrame implements ActionListener {
    
    // deklarasi komponen yang diperlukan
    private JLabel label1, label2, label3;
    private JTextField input1, input2, input3;
    private JRadioButton radioButton1, radioButton2, radioButton3;
    private ButtonGroup radioButtonGroup;
    private JButton button;
    
    // constructor
    public VolumeBalok() {
        // mengatur judul jendela
        setTitle("Kalkulator Volume Balok");
        
        // mengatur ukuran jendela
        setSize(300, 250);
        
        // mengatur layout jendela
        setLayout(new GridLayout(5, 2));
        
        // menginisialisasi komponen
        label1 = new JLabel("Panjang");
        label2 = new JLabel("Lebar");
        label3 = new JLabel("Tinggi");
        input1 = new JTextField();
        input2 = new JTextField();
        input3 = new JTextField();
        radioButton1 = new JRadioButton("cm");
        radioButton2 = new JRadioButton("m");
        radioButton3 = new JRadioButton("inchi");
        radioButtonGroup = new ButtonGroup();
        button = new JButton("Hitung");
        
        // menambahkan komponen ke jendela
        add(label1);
        add(input1);
        add(label2);
        add(input2);
        add(label3);
        add(input3);
        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        add(button);
        
        // menambahkan action listener ke button
        button.addActionListener(this);
        
        // menampilkan jendela
        setVisible(true);
    }
    
    // method untuk menghitung volume balok
    public double hitungVolumeBalok(double panjang, double lebar, double tinggi) {
        double volume = panjang * lebar * tinggi;
        return volume;
    }
    
    // method untuk mengonversi satuan
    public double konversiSatuan(double nilai, String satuan) {
        double konversi = 1;
        switch(satuan) {
            case "cm":
                konversi = 0.01;
                break;
            case "inchi":
                konversi = 0.0254;
                break;
        }
        return nilai * konversi;
    }
    
    // method untuk menampilkan hasil perhitungan
    public void tampilkanHasil(double hasil) {
        JOptionPane.showMessageDialog(this, "Volume balok = " + hasil + " m^3");
    }
    
    // method yang dipanggil ketika button di klik
    public void actionPerformed(ActionEvent e) {
        double panjang = konversiSatuan(Double.parseDouble(input1.getText()), radioButton1.isSelected() ? "cm" : "m");
        double lebar = konversiSatuan(Double.parseDouble(input2.getText()), radioButton1.isSelected() ? "cm" : "m");
        double tinggi = konversiSatuan(Double.parseDouble(input3.getText()), radioButton1.isSelected() ? "cm" : "m");
        double volume = hitungVolumeBalok(panjang, lebar, tinggi);
        tampilkanHasil(volume);