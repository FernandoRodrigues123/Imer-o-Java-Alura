import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream iS, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(iS);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, Transparency.TRANSLUCENT);

        Graphics2D grafics = (Graphics2D) novaImagem.getGraphics();
        grafics.drawImage(imagemOriginal, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        grafics.setColor(Color.yellow);
        grafics.setFont(font);

        grafics.drawString("ZEDON", largura / 4, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

   

}
