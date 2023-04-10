//Engenharia da Computação - Java
//
//Felipe Ferreira Neto Filgueiras - 202101297911
//Caio de Souza de Medeiros - 202203369008

package com.mycompany.exercicio1ap1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Questao2 {
    
    String opcao[] = {"Somar", "Multiplicar"};
        
    JFrame janela = new JFrame();
    
    List<Double> numeros = new ArrayList<>();
    List<Double> numeros2 = new ArrayList<>();

    //criando os paineis
    JPanel p1 = new JPanel(new GridLayout(3,3));
    JPanel p2 = new JPanel(new GridLayout(4,3));
    JPanel p3 = new JPanel(new GridLayout(2, 3));

    //criando os itens do painel 1
    JLabel digite_numero = new JLabel("   Digite o numero: ");
    JTextField tnumero = new JTextField(10);
    JButton botaoOk = new JButton("OK");

    //criando os itens do painel 2
    JLabel maior = new JLabel("      maior >>>  ");
    JLabel menor = new JLabel("      menor >>>  ");
    JLabel media = new JLabel("      media >>>  ");
    JTextField tmaior = new JTextField(10);
    JTextField tmenor = new JTextField(10);
    JTextField tmedia = new JTextField(10);
    JButton exibir = new JButton("Exibir");

    //criando os itens do painel 3
    JLabel valores = new JLabel("   Valores: ");
    JTextField tvalores = new JTextField(10);
    JButton botaoCalcular = new JButton("Calcular");
    JComboBox cb = new JComboBox(opcao);
    
    //Definindo as funções que fazem as operações.
    public void addNumero(){
        
        try{
            double valorReal = Double.parseDouble(tnumero.getText());
            numeros.add(valorReal);
            tnumero.setText("");
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Apenas números são aceitos nesse campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            tnumero.setText("");
        }
    }
    
    public String maior(){
        String nMaior;
        int tamanho;
        double numeroMaior, numeroI;
        tamanho = numeros.size();
        numeroMaior = numeros.get(0);
        for(int i = 0; i < tamanho; i++){
            numeroI = numeros.get(i);
            if (numeroI >= numeroMaior){
                numeroMaior = numeroI;
            }
        }
        nMaior = Double.toString(numeroMaior);
        return nMaior;
    }
    
    public String menor(){
        String nMenor;
        int tamanho;
        double numeroMenor, numeroI;
        tamanho = numeros.size();
        numeroMenor = numeros.get(0);
        for(int i = 0; i < tamanho; i++){
            numeroI = numeros.get(i);
            if (numeroI <= numeroMenor){
                numeroMenor = numeroI;
            }
        }
        nMenor = Double.toString(numeroMenor);
        return nMenor;
    }
    
    public String media(){
        String nMedia;
        int tamanho;
        double somaNumeros = 0, mediaNumeros, numeroI;
        tamanho = numeros.size();
        for(int i = 0; i < tamanho; i++){
            numeroI = numeros.get(i);
            somaNumeros = numeroI + somaNumeros;
        }
        mediaNumeros = somaNumeros/tamanho;
        nMedia = String.format("%.3g%n", mediaNumeros);
        return nMedia;
    }

    public String calcular(){
            try{
            String nSomar, nMultiplicar, entrada;
            double soma = 0, numeroI, convert, multiplica = 1;
            int tamanhoS, tamanhoL;
            String entradaValores = tvalores.getText();
            tamanhoS = entradaValores.length();
            if (tamanhoS % 2 != 0){
                JOptionPane.showMessageDialog(null, "Insira uma entrada de comprimento par.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            for(int i = 0; i < tamanhoS; i += 2){
                entrada = entradaValores.substring(i,i + 2);
                convert = Double.parseDouble(entrada);
                numeros2.add(convert);
            }
            tamanhoL = numeros2.size();
            if (((String)cb.getSelectedItem()).equals("Somar")){
                for(int i = 0; i < tamanhoL; i++){
                    numeroI = numeros2.get(i);
                    soma = numeroI + soma;
                }    
                nSomar = Double.toString(soma);
                return nSomar;
                }
            if (((String)cb.getSelectedItem()).equals("Multiplicar")){
                for(int i = 0; i < tamanhoL; i++){
                    numeroI = numeros2.get(i);
                    multiplica = numeroI * multiplica;
                }
                nMultiplicar = Double.toString(multiplica);
                return nMultiplicar;
            }
            nSomar = Double.toString(soma);
            return nSomar;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Apenas números são aceitos nesse campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    return "";
}
    
    //Montando a janela.
    public Questao2(){
        
        //add itens ao painel 1
        p1.add(digite_numero);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(tnumero);
        p1.add(botaoOk);
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        p1.add(new JPanel());
        botaoOk.addActionListener((ActionEvent evt) -> {
            addNumero();
        });
        
        //add itens ao painel 2
        p2.add(maior);
        p2.add(tmaior);
        p2.add(new JPanel());
        p2.add(menor);
        p2.add(tmenor);
        p2.add(exibir);
        p2.add(media);
        p2.add(tmedia);
        p2.add(new JPanel());
        p2.add(new JPanel());
        p2.add(new JPanel());
        p2.add(new JPanel());
        exibir.addActionListener((java.awt.event.ActionEvent evt) -> {
            tmaior.setText(maior());
            tmenor.setText(menor());
            tmedia.setText(media());
            numeros.clear();
        });
        
        //add itens ao painel 3
        p3.add(valores);
        p3.add(tvalores);
        p3.add(new JPanel());
        p3.add(new JPanel());
        p3.add(cb);
        p3.add(botaoCalcular);
        botaoCalcular.addActionListener((java.awt.event.ActionEvent evt) -> {
            tvalores.setText(calcular());
            numeros2.clear();
        });
        
        //organizando o layout da pagina
        janela.getContentPane().setLayout(new BorderLayout());
        
        janela.getContentPane().add(p1, BorderLayout.NORTH);
        janela.getContentPane().add(p2, BorderLayout.CENTER);
        janela.getContentPane().add(p3, BorderLayout.SOUTH);
        
        janela.pack();
        janela.setLocation(300,300);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Questao2 questao = new Questao2();
    }
    
}
