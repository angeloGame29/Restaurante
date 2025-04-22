package br.ufpb.dcx.restaurante.UI.GUI;

import javax.swing.*;
import java.awt.*;

public class TelaUser extends JFrame {
    public TelaUser(){
        setTitle("Perfil do usuario");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(Color.decode("#ee7e4c"));
        setLayout(new BorderLayout());

    }

    public static void main(String [] args){
        TelaUser loginUser = new TelaUser();
        loginUser.setVisible(true);
        loginUser.setDefaultCloseOperation(TelaUser.DISPOSE_ON_CLOSE);
    }
}
