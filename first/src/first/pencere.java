package first;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pencere {

	String kayitlistesi="";
	ImageIcon ýcon = new ImageIcon("images/maze3.jpg");
	JLabel resim=new JLabel();
	File file = new File("dosya.txt");
	static int dosya_sil=0;
	String nameofstudent;
	public pencere(){
		
		
		
		JFrame window=new JFrame("Öðrenci Kayýt Sistemi");
		JPanel panel=new JPanel();
		JLabel name_lb=new JLabel("ÝSÝM : ");
		JLabel no_lb=new JLabel  ("NO    : ");
		JButton kaydet_bt=new JButton("KAYDET");
		JButton listele_bt=new JButton("LÝSTELE");
		JButton dosyayýsil_bt=new JButton("SÝL");
		JTextField textname_textF=new JTextField();
		JTextField textno_textF=new JTextField();
		JTextArea kaydoldu_textF=new JTextArea();
		
		window.setSize(500, 500);
		window.setVisible(true);
		window.setLayout(null);
		
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		
		
		resim.setBounds(-20,-20,500,500);
		resim.setIcon(ýcon);
		
		
		kaydet_bt.setLocation(100,170);
		kaydet_bt.setSize(100,50);
		kaydet_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				nameofstudent="Name :"+textname_textF.getText();
				nameofstudent+= "   No       :";
				nameofstudent+=textno_textF.getText();
				textname_textF.setText(null);
				textno_textF.setText(null);
				kaydoldu_textF.setText(nameofstudent);
				kayitlistesi+=nameofstudent+"\n";
				
				try {
					dosyayazma(nameofstudent);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}
		});
		
		dosyayýsil_bt.setLocation(210, 175);
		dosyayýsil_bt.setSize(60,40);
		//dosyayýsil.setContentAreaFilled(true);
		dosyayýsil_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dosya_sil=1;
				try {
					dosyayazma(kayitlistesi);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		listele_bt.setLocation(280, 170);
		listele_bt.setSize(100,50);
		
		listele_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				kaydoldu_textF.setText(kayitlistesi);
				try {
					dosyaokuma();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		name_lb.setLocation(110,50);
		name_lb.setFont(new Font("Serif",Font.BOLD,14));
		name_lb.setForeground(Color.ORANGE);
		name_lb.setSize(100,100);
		
		no_lb.setLocation(110,83);
		no_lb.setSize(100,100);
		no_lb.setFont(new Font("Serif",Font.BOLD,16));
		no_lb.setForeground(Color.ORANGE);
		
		textname_textF.setLocation(155,90);
		textname_textF.setSize(200,25);
		textno_textF.setLocation(155,120);
		textno_textF.setSize(200,25);
		
		kaydoldu_textF.setLocation(100,230);
		kaydoldu_textF.setSize(270,150);
		kaydoldu_textF.setForeground(Color.BLACK);
		//kayitlistesi.setBackground(Color.black);
		kaydoldu_textF.setDragEnabled(false);
				
		window.add(kaydoldu_textF);
		window.add(panel);
		window.add(name_lb);
		window.add(no_lb);
		window.add(textname_textF);
		window.add(textno_textF);
		window.add(kaydet_bt);
		window.add(listele_bt);
		window.add(dosyayýsil_bt);
		window.add(resim);
		
	}
	


	void dosyayazma(String str) throws IOException{
		

        
        if (!file.exists()) {
            file.createNewFile();
        }
       /* if(dosya_sil==1){
        FileWriter fileWriter = new FileWriter(file, false);
        dosya_sil=0;
        }**/
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        bWriter.write("\n");
        bWriter.close();
        

	}
	
	void dosyaokuma() throws IOException{
        FileReader fileReader = new FileReader(file);
        String line;

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {

            System.out.println(line);

        }

        br.close();
		
	}
}
