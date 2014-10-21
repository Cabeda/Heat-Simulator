/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jecabeda
 */
public class SimController implements Serializable {

    private float comprimento, largura, altura, areaTotal, potenciaMedia;
    int numPessoas, temperaturaEx, temperaturaInt, temperaturaPre, numAparelhos;
    private List<Limite> listaLim;
    private List<Abertu> listaAber;
    private int cint, cint2, lingua;

    public SimController(float comprimento, float largura, float altura, float volume, float potenciaMedia, int numPessoas, int temperaturaEx, int temperaturaInt, int temperaturaPre, int numAparelhos, List<Limite> listaLim, List<Abertu> listaAber) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.areaTotal = volume;
        this.potenciaMedia = potenciaMedia;
        this.numPessoas = numPessoas;
        this.temperaturaEx = temperaturaEx;
        this.temperaturaInt = temperaturaInt;
        this.temperaturaPre = temperaturaPre;
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
        this.areaTotal = 0;
        this.numPessoas = 0;
        this.temperaturaEx = 0;
        this.temperaturaInt = 0;
        this.temperaturaPre = 0;
        this.listaAber = new ArrayList();
        this.listaLim = new ArrayList();
        this.cint = 0;
        this.cint2 = 0;
    }

    public SimController(SimController dc) {
        this.comprimento = dc.comprimento;
        this.largura = dc.largura;
        this.altura = dc.largura;
        this.areaTotal = dc.areaTotal;
        this.numPessoas = dc.numPessoas;
        this.temperaturaEx = dc.temperaturaEx;
        this.temperaturaInt = dc.temperaturaInt;
        this.temperaturaPre = dc.temperaturaPre;
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

    public int getTemperaturaPre() {
        return temperaturaPre;
    }

    public float getAreaTotal() {

        return areaTotal;
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

    public void setAreaTotal() {
        areaTotal = 2 * ((comprimento * largura) + (comprimento * altura) + (altura * largura));

    }

    public void setAreaTotal(float volume) {
        this.areaTotal = volume;
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

    public void setTemperaturaPre(int temperaturaPre) {
        this.temperaturaPre = temperaturaPre;
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

        return "Comprimento:" + comprimento + ", Largura:" + largura + ", Altura:"
                + "" + altura + ", Volume:" + areaTotal + ", Potencia Media: "
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

    public void criarFicheiroHTMLPt() throws IOException {

        try {
            File fich = new File("Resultados.html");
            BufferedWriter out = new BufferedWriter(new FileWriter(fich));
            out.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out.write("<title>Resultados:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h1>Par&acirc;metros :</h1>\n");
            out.write("<ul>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"limites.html\">Limites</a></li>\n" + "  <li><a href=\"aberturas.html\">Aberturas</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");

            out.write("<hr>\n</body></html>");
            out.close();

            File dim = new File("dimensoes.html");
            BufferedWriter out2 = new BufferedWriter(new FileWriter(dim));

            out2.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out2.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out2.write("<title>Dimens&otilde;es:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out2.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"limites.html\">Limites</a></li>\n" + "  <li><a href=\"aberturas.html\">Aberturas</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");
            out2.write("<h2>Dimens&otilde;es :</h2>" + "<h4>Comprimento : " + getComprimento() + " m<br>Altura : " + getAltura() + " m<br>Largura : " + getLargura() + " m<br>&Aacute;rea Total : " + getAreaTotal() + " m&sup3;</h4>\n");
            out2.write("<hr>\n</body></html>");
            out2.close();

            File lim = new File("limites.html");
            BufferedWriter out3 = new BufferedWriter(new FileWriter(lim));

            out3.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out3.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out3.write("<title>Limites:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" );
            out3.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"aberturas.html\">Aberturas</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");

            int i = 1;
            out3.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Numero</td>\n<td>Tipo</td>\n<td>Material</td>\n<td>Altura (m)</td>\n<td>Largura (m)</td>\n<td>Espessura (m)</td>\n</tr>");

            for (Limite ls : listaLim) {
                out3.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" + ls.getEspessura() + "</td></tr>");
                i++;
            }
            out3.write("</table>");

            out3.write("<hr>\n</body></html>");
            out3.close();

            File abe = new File("aberturas.html");
            BufferedWriter out4 = new BufferedWriter(new FileWriter(abe));

            out4.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out4.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out4.write("<title>Aberturas:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" );
            out4.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"limites.html\">Limites</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");

            i = 1;
            out4.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Numero</td>\n<td>Tipo</td>\n<td>Material</td>\n<td>Altura (m)</td>\n<td>Largura (m)</td>\n<td>Espessura (m)</td>\n</tr>");

            for (Abertu ls : listaAber) {
                out4.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
                i++;
            }
            out4.write("</table>");

            out4.write("<hr>\n</body></html>");
            out4.close();

            File outro = new File("outros.html");
            BufferedWriter out5 = new BufferedWriter(new FileWriter(outro));
            out5.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out5.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out5.write("<title>Resultados:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h1>Par&acirc;metros :</h1>\n");
            out5.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"limites.html\">Limites</a></li>\n" + "  <li><a href=\"aberturas.html\">Aberturas</a></li>\n" + "</ul>");
            out5.write("<h4>N&uacute;mero de Pessoas : " + getNumPessoas() + "</h4>\n");
            out5.write("<h4>N&uacute;mero de Aparelhos : " + getNumAparelhos() + "</h4>\n");
            out5.write("<h4>Pot&ecirc;ncia m&eacute;dia dos Aparelhos : " + getPotenciaMedia() + " Wh</h4>\n");
            out5.write("<h4>Temperatura exterior : " + getTemperaturaEx() + " &deg;C</h4>\n");
            out5.write("<h4>Temperatura interior : " + getTemperaturaInt() + " &deg;C</h4>\n");
            out5.write("<h4>Temperatura pretendida : " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Erro - " + e.getLocalizedMessage());
        }

    }

    public void criarFicheiroHTMLEn() throws IOException {

        try {
            File fich = new File("Results.html");
            BufferedWriter out = new BufferedWriter(new FileWriter(fich));
            out.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out.write("<title>Results:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h1>Parameters :</h1>\n");
            out.write("<ul>\n" + "  <li><a href=\"dimensions.html\">Dimensions</a></li>\n" + "  <li><a href=\"limits.html\">Limits</a></li>\n" + "  <li><a href=\"openings.html\">Openings</a></li>\n" + "  <li><a href=\"others.html\">Others</a></li>\n" + "</ul>");

            out.write("<hr>\n</body></html>");
            out.close();

            File dim = new File("dimensions.html");
            BufferedWriter out2 = new BufferedWriter(new FileWriter(dim));

            out2.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out2.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out2.write("<title>Dimensions:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out2.write("<ul>\n" + "  <li><a href=\"Results.html\">Home</a></li>\n" + "  <li><a href=\"limits.html\">Limits</a></li>\n" + "  <li><a href=\"openings.html\">Openings</a></li>\n" + "  <li><a href=\"others.html\">Others</a></li>\n" + "</ul>");
            out2.write("<h2>Dimensions :</h2>" + "<h4>Length : " + getComprimento() + " m<br>Height : " + getAltura() + " m<br>Width : " + getLargura() + " m<br>Total Area : " + getAreaTotal() + " m&sup3;</h4>\n");
            out2.write("<hr>\n</body></html>");
            out2.close();

            File lim = new File("limits.html");
            BufferedWriter out3 = new BufferedWriter(new FileWriter(lim));

            out3.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out3.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out3.write("<title>Limits:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out3.write("<ul>\n" + "  <li><a href=\"Results.html\">Home</a></li>\n" + "  <li><a href=\"dimensions.html\">Dimensions</a></li>\n" + "  <li><a href=\"openings.html\">Openings</a></li>\n" + "  <li><a href=\"others.html\">Others</a></li>\n" + "</ul>");

            int i = 1;
            out3.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Number</td>\n<td>Type</td>\n<td>Material</td>\n<td>Height (m)</td>\n<td>Width (m)</td>\n<td>Thickness (m)</td>\n</tr>");

            for (Limite ls : listaLim) {
                out3.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" + ls.getEspessura() + "</td></tr>");
                i++;
            }
            out3.write("</table>");

            out3.write("<hr>\n</body></html>");
            out3.close();

            File abe = new File("openings.html");
            BufferedWriter out4 = new BufferedWriter(new FileWriter(abe));

            out4.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out4.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out4.write("<title>Openings:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out4.write("<ul>\n" + "  <li><a href=\"Results.html\">Home</a></li>\n" + "  <li><a href=\"dimensions.html\">Dimensions</a></li>\n" + "  <li><a href=\"limits.html\">Limits</a></li>\n" + "  <li><a href=\"others.html\">Others</a></li>\n" + "</ul>");

            i = 1;
            out4.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Number</td>\n<td>Type</td>\n<td>Material</td>\n<td>Height (m)</td>\n<td>Width (m)</td>\n<td>Thickness(m)</td>\n</tr>");

            for (Abertu ls : listaAber) {
                out4.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
                i++;
            }
            out4.write("</table>");

            out4.write("<hr>\n</body></html>");
            out4.close();

            File outro = new File("others.html");
            BufferedWriter out5 = new BufferedWriter(new FileWriter(outro));
            out5.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out5.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out5.write("<title>Others:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<h1>Par&acirc;metros :</h1>\n" + "<hr>\n");
            out5.write("<ul>\n" + "  <li><a href=\"Results.html\">Home</a></li>\n" + "  <li><a href=\"dimensions.html\">Dimensions</a></li>\n" + "  <li><a href=\"limits.html\">Limits</a></li>\n" + "  <li><a href=\"openings.html\">Openings</a></li>\n" + "</ul>");
            out5.write("<h4>Number of People : " + getNumPessoas() + "</h4>\n");
            out5.write("<h4>Number of Devices : " + getNumAparelhos() + "</h4>\n");
            out5.write("<h4>Average Power of the Devices : " + getPotenciaMedia() + " Wh</h4>\n");
            out5.write("<h4>Outside Temperature : " + getTemperaturaEx() + " &deg;C</h4>\n");
            out5.write("<h4>Inside Temperature : " + getTemperaturaInt() + " &deg;C</h4>\n");
            out5.write("<h4>Desired Temperature : " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Error - " + e.getLocalizedMessage());
        }

    }

    public void guardarDados() {
        try {
            FileOutputStream fileOut = new FileOutputStream("dados.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(getLinguagem());
            out.writeObject(getAltura());
            out.writeObject(getLargura());
            out.writeObject(getComprimento());
            out.writeObject(getAreaTotal());

            out.writeObject(listaLim.size());
            for (Limite listaLim1 : listaLim) {
                out.writeObject(listaLim1);
            }
            out.writeObject(listaAber.size());
            for (Abertu listaAber1 : listaAber) {
                out.writeObject(listaAber1);
            }

            out.writeObject(getNumPessoas());
            out.writeObject(getNumAparelhos());
            out.writeObject(getPotenciaMedia());
            out.writeObject(getTemperaturaEx());
            out.writeObject(getTemperaturaInt());
            out.writeObject(getTemperaturaPre());

            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void introduzirDados(File f) {
        try {
            FileInputStream fileIn = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            setLinguagem((int) in.readObject());
            setAltura((float) in.readObject());
            setLargura((float) in.readObject());
            setComprimento((float) in.readObject());
            setAreaTotal((float) in.readObject());
            List<Limite> lsl = new ArrayList<>();
            int cont = (int) in.readObject();
            for (int i = 0; i < cont; i++) {
                lsl.add((Limite) (in.readObject()));
            }
            setListaLim(lsl);
            cont = (int) in.readObject();
            List<Abertu> lsa = new ArrayList<>();
            for (int i = 0; i < cont; i++) {
                lsa.add((Abertu) (in.readObject()));
            }
            setListaAber(lsa);

            setNumPessoas((int) in.readObject());
            setNumAparelhos((int) in.readObject());
            setPotenciaMedia((float) in.readObject());
            setTemperaturaEx((int) in.readObject());
            setTemperaturaInt((int) in.readObject());
            setTemperaturaPre((int) in.readObject());

            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("IOException");
        } catch (ClassNotFoundException c) {

            System.out.println("Class Not Found Exception");
        }
    }

    public void setLinguagem(int i) {
        lingua = i;
    }

    public int getLinguagem() {
        return lingua;
    }

    /**
     * @param listaLim the listaLim to set
     */
    public void setListaLim(List<Limite> listaLim) {
        this.listaLim = listaLim;
    }

    /**
     * @param listaAber the listaAber to set
     */
    public void setListaAber(List<Abertu> listaAber) {
        this.listaAber = listaAber;
    }

}
