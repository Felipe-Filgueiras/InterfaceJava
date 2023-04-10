//Engenharia da Computação - Java
//
//Felipe Ferreira Neto Filgueiras matricula - 202101297911
//Caio de Souza de Medeiros - 202203369008

package com.mycompany.exercicio1ap1;

//Importando AWT, Swing e elementos do Swing que serao utilizados
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
public class Questao1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

//Método para executar a ação "e" que chama o método "conversao e verifica se o usuário não digitou nada ou digitou um valor não numérico. Caso ocorra, exibe uma caixa de aviso".

	public void actionPerformed(ActionEvent e) {
		boolean isNumeric = (valorConverter.getText() != null && valorConverter.getText().matches("[0-9]+"));
		if(valorConverter.getText().isEmpty()==true) {
			JOptionPane.showMessageDialog(null, "Nenhum valor em R$ inserido. Insira o valor e selecione a moeda desejada para fazer a conversão.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else if(isNumeric==false && valorConverter.getText()!=""){
			JOptionPane.showMessageDialog(null, "Insira um valor válido! Somente valores numéricos.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else if(usd.isSelected()==false && eur.isSelected()==false && jpy.isSelected()==false && £.isSelected()==false) {
			JOptionPane.showMessageDialog(null, "Para fazer a conversão, selecione a moeda desejada.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else {
			valorConvertido.setText(conversao());
		}
	}
	//Inicializando os atributos da classe (componentes da interface e variáveis.
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new GridLayout(2, 2));
	JButton converter = new JButton();
	JLabel real = new JLabel("R$");
	JTextField valorConverter = new JTextField(6);
	JRadioButton usd = new JRadioButton("USD");
	JRadioButton eur = new JRadioButton("EUR");
	JRadioButton jpy = new JRadioButton("JPY");
	JRadioButton £ = new JRadioButton("£");
	JTextField valorConvertido = new JTextField(12);
	ButtonGroup moedas = new ButtonGroup();
	String resultado;
//Método para converter para a moeda selecionada. Retorna uma string com o valor convertido na moeda selecionada no grupo de botões "moedas".
	
	public String conversao() {
		
		double valorReal = Double.valueOf(valorConverter.getText()).doubleValue();
		
		if(usd.isSelected()==true) {
			
			double dolar = valorReal/5.30;
			resultado = Double.toString(dolar);
			
		}
		if(eur.isSelected()==true) {
			
			double euro = valorReal/5.74;
			resultado = Double.toString(euro);
			
		}
		
		if(jpy.isSelected()==true) {
			
			double iene = valorReal/0.041;
			resultado = Double.toString(iene);
			
		}
		
if(£.isSelected()==true) {
			
			double libra = valorReal/6.51;
			resultado = Double.toString(libra);
			
		}
		
		return resultado;
	}
	public Questao1() {
		
//Inicializando adicionando os componentes ao seu respectivo painel, grupo de botões e frames.
		moedas.add(usd);
		moedas.add(eur);
		moedas.add(jpy);
		moedas.add(£);
		p2.add(usd);
		p2.add(eur);
		p2.add(jpy);
		p2.add(£);
		add(p1);
		p1.add(real);
		p1.add(valorConverter);
		p1.add(p2);
		p1.add(converter);
		p1.add(valorConvertido);
		setBackground(Color.CYAN);
		
		
//Editando o texto do botão de conversão e fazendo-o esperar ser clicado para realizar
//a ação escrita no método actionPerformed(linha 19)
		
		converter.setText("Converter>>>");
		converter.addActionListener(this);
		
//Tornando o botão de resultado não editável
		valorConvertido.setEditable(false);

//Definindo o tamanho do frame, opeeação de fechamento, titulo e tornando-o visível
		setLayout(new FlowLayout());
		setTitle("Questao 1");
		setSize(550, 100);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
//Executando o programa
public static void main(String args[]) {
	new Questao1();

}


}