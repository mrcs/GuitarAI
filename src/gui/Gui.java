package gui;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import org.jfugue.Player;

import aluno.Aluno;

import dominio.Acorde;
import dominio.Dominio;
import dominio.Questao;

import tutor.Tutor;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Tutor tutor;
	private Acorde acordeAtual;
	private JLabel jLabel = null;
	private JLabel diagrama = null;
	private JLabel tela = null;
	private JLabel jLabel1 = null;
	private JTextField tf_resposta = null;
	private JButton bt_ok = null;
	private JButton bt_play = null;
	private JButton bt_next = null;
	private JLabel jLabel2 = null;

	/**
	 * This method initializes tf_resposta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTf_resposta() {
		if (tf_resposta == null) {
			tf_resposta = new JTextField();
			tf_resposta.setBounds(new Rectangle(338, 147, 162, 24));
		}
		return tf_resposta;
	}

	/**
	 * This method initializes bt_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setBounds(new Rectangle(378, 267, 84, 23));
			bt_ok.setText("OK");
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ok();
				}
			});
		}
		return bt_ok;
	}

	private void ok(){
		if(tutor.temQuestao()){
			String resposta = tf_resposta.getText();
			if (resposta.equals("")){
				JOptionPane.showMessageDialog(null, "Digite a resposta!");
			}else{
				Questao questao = tutor.proximaQuestao();
				acordeAtual = questao.getAcorde();
				mudarDiagrama(acordeAtual.getNome());
				play();
			}
		}else{
			this.bt_ok.setVisible(false);
			this.bt_next.setVisible(true);
			this.tela.setText(tutor.getErros());
		}
	}
	
	/**
	 * This method initializes bt_play	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_play() {
		if (bt_play == null) {
			bt_play = new JButton();
			bt_play.setBounds(new Rectangle(48, 267, 84, 23));
			bt_play.setText("Play");
			bt_play.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					play();
				}
			});
		}
		return bt_play;
	}

	/**
	 * This method initializes bt_next	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setBounds(new Rectangle(173, 267, 84, 23));
			bt_next.setText("Next");
			bt_next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					next();
				}
			});
		}
		return bt_next;
	}

	private void next(){
		if (tutor.temLicao()){
			Questao licao = tutor.proximaLicao();
			acordeAtual = licao.getAcorde();
			String nome = acordeAtual.getNome();
			mudarDiagrama(nome);
			play();
		}else{
			this.bt_next.setVisible(false);
			this.bt_ok.setVisible(true);
			this.tela.setText(tutor.getMsg());
		}
	}
	
	private void play() {
		Player player = new Player();
		player.play(this.acordeAtual.getNome());
		player.play("A");	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui thisClass = new Gui();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Gui() {
		super();
		tutor = new Tutor(new Aluno(),new Dominio());
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(598, 347);
		this.setContentPane(getJContentPane());
		this.setTitle("GuitarAI");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(338, 21, 80, 17));
			jLabel2.setText("Tutor");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(338, 114, 60, 17));
			jLabel1.setText("Resposta");
			tela = new JLabel();
			tela.setBounds(new Rectangle(338, 52, 212, 45));
			tela.setText("Para começar aperte a tecla Next!");
			diagrama = new JLabel();
			diagrama.setBounds(new Rectangle(22, 53, 276, 190));
			diagrama.setText("");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(22, 21, 80, 17));
			jLabel.setText("Diagrama");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(diagrama, null);
			jContentPane.add(tela, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTf_resposta(), null);
			jContentPane.add(getBt_ok(), null);
			jContentPane.add(getBt_play(), null);
			jContentPane.add(getBt_next(), null);
			jContentPane.add(jLabel2, null);
		}
		return jContentPane;
	}
	
	private void mudarDiagrama(String nome){
		diagrama.setIcon(new ImageIcon(getClass().getResource("/imagens/"+nome+".gif")));
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
