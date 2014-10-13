/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jecabeda
 */
public class SimController {

    private float comprimento, largura, altura, volume, potenciaMedia;
    int numPessoas, temperaturaEx, temperaturaInt, numAparelhos;
    private List<Limite> listaLim;
    private List<Abertu> listaAber;
    private int cint, cint2;

    public SimController(float comprimento, float largura, float altura, float volume, float potenciaMedia, int numPessoas, int temperaturaEx, int temperaturaInt, int numAparelhos, List<Limite> listaLim, List<Abertu> listaAber) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.volume = volume;
        this.potenciaMedia = potenciaMedia;
        this.numPessoas = numPessoas;
        this.temperaturaEx = temperaturaEx;
        this.temperaturaInt = temperaturaInt;
        this.numAparelhos = numAparelhos;
        this.listaAber = listaAber;
        this.listaLim = listaLim;
        this.cint = 0;
        this.cint2 = 0;
    }

    public SimController() {
        this.comprimento = 0;
        this.largura = 0;
        this.altura = 0;
        this.volume = 0;
        this.numPessoas = 0;
        this.temperaturaEx = 0;
        this.temperaturaInt = 0;
        this.listaAber = new ArrayList();
        this.listaLim = new ArrayList();
        this.cint = 0;
        this.cint2 = 0;
    }

    public SimController(SimController dc) {
        this.comprimento = dc.comprimento;
        this.largura = dc.largura;
        this.altura = dc.largura;
        this.volume = dc.volume;
        this.numPessoas = dc.numPessoas;
        this.temperaturaEx = dc.temperaturaEx;
        this.numAparelhos = dc.numAparelhos;
        this.potenciaMedia = dc.potenciaMedia;
        this.listaAber = dc.listaAber;
        this.listaLim = dc.listaLim;

    }

    public float getComprimento() {
        return comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public float getAltura() {
        return altura;
    }

    public int getTemperaturaEx() {
        return temperaturaEx;
    }

    public int getTemperaturaInt() {
        return temperaturaInt;
    }

    public float getVolume() {

        return volume;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public float getPotenciaMedia() {
        return potenciaMedia;
    }

    public int getNumAparelhos() {
        return numAparelhos;
    }

    public List<Limite> getListaLim() {
        return listaLim;
    }

    public List<Abertu> getListaAber() {
        return listaAber;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setVolume() {
        volume = comprimento * largura * altura;

    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public void setPotenciaMedia(float potenciaMedia) {
        this.potenciaMedia = potenciaMedia;
    }

    public void setTemperaturaEx(int temperatura) {
        this.temperaturaEx = temperatura;
    }

    public void setTemperaturaInt(int temperaturaInt) {
        this.temperaturaInt = temperaturaInt;
    }

    public void setNumAparelhos(int numAparelhos) {
        this.numAparelhos = numAparelhos;
    }

    public void addLim(Limite listaLim) {

        (this.listaLim).add(listaLim);
        cint++;
    }

    public void addAber(Abertu listaAber) {
        (this.listaAber).add(listaAber);

    }

    public void altLim(Limite listaLim2) {
        for (Limite listaLim1 : listaLim) {
            if (listaLim1.equals(listaLim2)) {
                listaLim1.setAltura(listaLim2.getAltura());
                listaLim1.setLargura(listaLim2.getLargura());
                listaLim1.setMaterial(listaLim2.getMaterial());
                listaLim1.setTipo(listaLim2.getTipo());
            }
        }

    }

    public void altAber(Abertu listaAber2) {
        for (Abertu listaLim1 : listaAber) {
            if (listaLim1.equals(listaAber2)) {
                listaLim1.setAltura(listaAber2.getAltura());
                listaLim1.setLargura(listaAber2.getLargura());
                listaLim1.setMaterial(listaAber2.getMaterial());
                listaLim1.setTipo(listaAber2.getTipo());
            }
        }

    }

    @Override
    public String toString() {
//        String lim = "";
//        String aber = "";
//        for (Limite limTemp : listaLim) {
//            lim += limTemp.toString();
//        }
//        for (Abertu aberTemp : listaAber) {
//            aber += aberTemp.toString();
//        }

        return "Comprimento:" + comprimento + ", Largura:" + largura + ", Altura:"
                + "" + altura + ", Volume:" + volume + ", Potencia Media: "
                + potenciaMedia + ", Numero de Pessoas:" + numPessoas + ", Temperatura:"
                + "" + temperaturaEx + ", Numero de Aparelhos:" + numAparelhos + "Número de aberturas: "
                + listaAber.size() + "Número de limites: " + listaLim.size();
    }

    public String calcular() {
        String x = "";
        double resultado = 0;

        for (Limite limTemp : listaLim) {

            resultado += (limTemp.getAltura() * limTemp.getLargura());
        }
        for (Abertu aberTemp : listaAber) {
            resultado += (aberTemp.getAltura() * aberTemp.getLargura());
        }

        return x;
    }

    public String ultimoLim() {
        if (listaLim.size() != 0) {
            Limite lim = listaLim.get(listaLim.size() - 1);
            return lim.toString();
        } else {
            return "Sem limite";
        }
    }

    public String ultimoAber() {
        if (listaLim.size() != 0) {
            Abertu aber = listaAber.get(listaAber.size());
            return aber.toString();
        } else {
            return "Sem abertura";
        }

    }

    public void criarFicheiroHTML() throws IOException {

        try {
            File fich = new File("Resultados.html");
            BufferedWriter out = new BufferedWriter(new FileWriter(fich));
            out.write("<!DOCTYPE html PUBLIC " + "-//W3C//DTD HTML 4.01 Transitional//EN" + "http://www.w3.org/TR/html4/loose.dtd>\n"
                    + "<html lang=" + "pt" + "><head><meta http-equiv=" + "Content-Type" + " content=" + "text/html; charset=ISO-8859-1" + ">\n");
            out.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out.write("<title>Resultados:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<div align=\"left\">\n" + "<h1>Parametros :</h1>\n" + "</div>\n" + "<hr>\n" + "</body></html>");
            out.close();
            
            Desktop.getDesktop().browse(fich.toURI());
            
        } catch (IOException e) {
            System.out.println("Erro - " + e.getLocalizedMessage());
        }

      
        

    }

}
