package br.ufpb.dcx.restaurante.janela.pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioDialog extends JDialog implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog userDialog = new JDialog(this, "",true);
        userDialog.setTitle("Perfil do usuario");
        userDialog.setSize(600, 550);
        userDialog.setLocationRelativeTo(null);
        userDialog.setResizable(true);
        userDialog.getContentPane().setBackground(Color.decode("#4b4452"));
        userDialog.setVisible(true);
        //TODO IMPLEMENTAR
    }
}
