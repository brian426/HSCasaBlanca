package ComponenteClases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelConFondo extends JPanel {

    private ImageIcon imagen;

    public JPanelConFondo() {
    }

   public JPanelConFondo(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen));
        }
    }

    public JPanelConFondo(ImageIcon imagenInicial) {
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
    }

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen));
        } else {
            imagen = null;
        }

        repaint();
    }

   public void setImagen(ImageIcon nuevaImagen) {
        imagen = nuevaImagen;

        repaint();
    }

   // @Override
 public void paint(Graphics g) {
        if (imagen != null) {
            Image a=imagen.getImage();
            g.drawImage(a, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }
}
