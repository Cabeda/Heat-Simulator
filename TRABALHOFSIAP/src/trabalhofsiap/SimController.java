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
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Jecabeda
 */
public class SimController implements Serializable {

    private float comprimento, largura, altura, areaTotal, potenciaMedia;
    int numPessoas, numAparelhos;
    float temperaturaEx, temperaturaPre;
    private List<Limite> listaLim;
    private int cint, cint2, lingua;
    ResourceBundle mensagens;

    public SimController(float comprimento, float largura, float altura, float volume, float potenciaMedia, int numPessoas, int temperaturaEx, int temperaturaInt, int temperaturaPre, int numAparelhos, List<Limite> listaLim) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.areaTotal = volume;
        this.potenciaMedia = potenciaMedia;
        this.numPessoas = numPessoas;
        this.temperaturaEx = temperaturaEx;
        this.temperaturaPre = temperaturaPre;
        this.numAparelhos = numAparelhos;
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
        this.temperaturaPre = 0;
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
        this.temperaturaPre = dc.temperaturaPre;
        this.numAparelhos = dc.numAparelhos;
        this.potenciaMedia = dc.potenciaMedia;

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

    public float getTemperaturaEx() {
        return temperaturaEx;
    }

    public float getTemperaturaPre() {
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

    public void setTemperaturaEx(float temperatura) {
        this.temperaturaEx = temperatura;
    }

    public void setTemperaturaPre(float temperaturaPre) {
        this.temperaturaPre = temperaturaPre;
    }

    public void setNumAparelhos(int numAparelhos) {
        this.numAparelhos = numAparelhos;
    }

    public void addLim(Limite listaLim) {

        (this.listaLim).add(listaLim);
        cint++;
    }

    public List<Abertu> getListaAberturas(){
        List<Abertu> temp = new ArrayList();
        for(Limite lim: listaLim){
            for(Abertu aber : lim.getListaAberturas())
            {
                temp.add(aber);
            }
        }
        return temp;
    }
    public List<Camada> getListaCamadas(){
        List<Camada> temp = new ArrayList();
        for(Limite lim: listaLim){
            for(Camada cam : lim.getListaCamadas())
            {
                temp.add(cam);
            }
        }
        return temp;
    }
    public void altLim(Limite listaLim2) {
        for (Limite listaLim1 : listaLim) {
            if (listaLim1.equals(listaLim2)) {
                listaLim1.setAltura(listaLim2.getAltura());
                listaLim1.setLargura(listaLim2.getLargura());
                listaLim1.setTipo(listaLim2.getTipo());
            }
        }

    }

    @Override
    public String toString() {

        return "Comprimento:" + comprimento + ", Largura:" + largura + ", Altura:"
                + "" + altura + ", Volume:" + areaTotal + ", Potencia Media: "
                + potenciaMedia + ", Numero de Pessoas:" + numPessoas + ", Temperatura:"
                + "" + temperaturaEx + ", Numero de Aparelhos:" + numAparelhos;
    }

    public String calcular() {
        String x = "";
        double resultado = 0;

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

    public void criarFicheiroHTMLPt(String f) throws IOException {

        try {
            File fich = new File(f + "\\Resultados.html");
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

            File dim = new File(f + "\\dimensoes.html");
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

            File lim = new File(f + "\\limites.html");
            BufferedWriter out3 = new BufferedWriter(new FileWriter(lim));

            out3.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out3.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out3.write("<title>Limites:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out3.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"aberturas.html\">Aberturas</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");

            int i = 1;
            out3.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Numero</td>\n<td>Tipo</td>\n<td>Material</td>\n<td>Altura (m)</td>\n<td>Largura (m)</td>\n<td>Espessura (m)</td>\n</tr>");

            for (Limite temp : listaLim) {
                for (Camada ls : temp.getListaCamadas()) {
                    out3.write("<tr>\n<td>" + i + "</td>\n<td>" + "</td>\n<td>" + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" + "</td></tr>");
                    i++;
                }
            }
            out3.write("</table>");

            out3.write("<hr>\n</body></html>");
            out3.close();

            File abe = new File(f + "\\aberturas.html");
            BufferedWriter out4 = new BufferedWriter(new FileWriter(abe));

            out4.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out4.write("<script type=\"text/javascript\" src=\"./Resultados_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./Resultados_files/styles(1).php\">\n");
            out4.write("<title>Aberturas:</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out4.write("<ul>\n" + "  <li><a href=\"Resultados.html\">Home</a></li>\n" + "  <li><a href=\"dimensoes.html\">Dimens&otilde;es</a></li>\n" + "  <li><a href=\"limites.html\">Limites</a></li>\n" + "  <li><a href=\"outros.html\">Outros</a></li>\n" + "</ul>");

            i = 1;
            out4.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>Numero</td>\n<td>Tipo</td>\n<td>Material</td>\n<td>Altura (m)</td>\n<td>Largura (m)</td>\n<td>Espessura (m)</td>\n</tr>");

            for (Limite temp : listaLim) {
                for (Abertu ls : temp.getListaAberturas()) {
                    out4.write("<tr>\n<td>" + i + "</td>\n<td>" + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
                    i++;
                }
            }
            out4.write("</table>");

            out4.write("<hr>\n</body></html>");
            out4.close();

            File outro = new File(f + "\\outros.html");
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
            out5.write("<h4>Temperatura pretendida : " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Erro - " + e.getLocalizedMessage());
        }

    }

    public void criarFicheiroHTMLEn(String f) throws IOException {

        try {
            File fich = new File(f + "\\Results.html");
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

            File dim = new File(f + "\\dimensions.html");
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

            File lim = new File(f + "\\limits.html");
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
            for (Limite temp : listaLim) {
                for (Camada ls : temp.getListaCamadas()) {
                    out3.write("<tr>\n<td>" + i + "</td>\n<td>" + "</td>\n<td>" + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" + "</td></tr>");
                    i++;
                }
            }
            out3.write("</table>");

            out3.write("<hr>\n</body></html>");
            out3.close();

            File abe = new File(f + "\\openings.html");
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
            for (Limite temp : listaLim) {
                for (Abertu ls : temp.getListaAberturas()) {
                    out4.write("<tr>\n<td>" + i + "</td>\n<td>" + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
                    i++;
                }
            }
            out4.write("</table>");

            out4.write("<hr>\n</body></html>");
            out4.close();

            File outro = new File(f + "\\others.html");
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
            out5.write("<h4>Desired Temperature : " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Error - " + e.getLocalizedMessage());
        }

    }

    public void guardarDados(String f) {
        try {
            FileOutputStream fileOut = new FileOutputStream(f + "\\" + f + ".bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(getLinguagem());
            out.writeObject(getAltura());
            out.writeObject(getLargura());
            out.writeObject(getComprimento());
            out.writeObject(getAreaTotal());

            for (Limite temp : listaLim) {
                out.writeObject(temp.getListaCamadas().size());
                for (Camada listaCam1 : temp.getListaCamadas()) {
                    out.writeObject(listaCam1);
                }
            }
            for (Limite temp : listaLim) {
                out.writeObject(temp.getListaAberturas().size());
                for (Abertu listaAber1 : temp.getListaAberturas()) {
                    out.writeObject(listaAber1);
                }
            }
            out.writeObject(getNumPessoas());
            out.writeObject(getNumAparelhos());
            out.writeObject(getPotenciaMedia());
            out.writeObject(getTemperaturaEx());
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

            setNumPessoas((int) in.readObject());
            setNumAparelhos((int) in.readObject());
            setPotenciaMedia((float) in.readObject());
            setTemperaturaEx((int) in.readObject());
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
     * @return the mensagens
     */
    public ResourceBundle getMensagens() {
        return mensagens;
    }

    /**
     * @param mensagens the mensagens to set
     */
    public void setMensagens(Locale currentLocale) {
        this.mensagens = ResourceBundle.getBundle("MensagensBundle",currentLocale);
    }

}
