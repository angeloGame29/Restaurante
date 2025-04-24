package br.ufpb.dcx.restaurante.UI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ModImagem {
    /**
     * Deixa a imagem do tamanho de um icone
     * @param img recebe a imagem
     * @return retorna a imagem com o tamanho alterado
     */
    public static ImageIcon deixaTamanhoIcon(ImageIcon img){
        Image imagemRedimensionada = img.getImage().getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada);
        return novaImagem;
    }

    /**
     * Muda a cor de uma imagem
     * @param icon recebe uma imagem a qual terá a cor alterada
     * @param cor a nova cor da imagem
     * @return a imagem com a cor alterada
     */
    public static ImageIcon colorirIcon(Icon icon, Color cor) {
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        BufferedImage original = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = original.getGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        BufferedImage colorida = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = colorida.createGraphics();

        g2d.drawImage(original, 0, 0, null);
        g2d.setComposite(AlphaComposite.SrcAtop);
        g2d.setColor(cor);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        return new ImageIcon(colorida);
    }
}
