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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
    private Map<String, Material> listaMaterial;
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
        listaMaterial= new HashMap<String,Material>(); 
        mensagens = ResourceBundle.getBundle("MensagensBundle", new Locale("pt", "PT"));
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
listaMaterial= new HashMap<String,Material>(); 
        mensagens = ResourceBundle.getBundle("MensagensBundle", new Locale("pt", "PT"));
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
        listaMaterial= new HashMap<String,Material>(); 
        mensagens = ResourceBundle.getBundle("MensagensBundle", new Locale("pt", "PT"));

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

    public List<Abertu> getListaAberturas() {
        List<Abertu> temp = new ArrayList();
        for (Limite lim : listaLim) {
            for (Abertu aber : lim.getListaAberturas()) {
                temp.add(aber);
            }
        }
        return temp;
    }

    public List<Camada> getListaCamadas() {
        List<Camada> temp = new ArrayList();
        for (Limite lim : listaLim) {
            for (Camada cam : lim.getListaCamadas()) {
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

        return mensagens.getString("comprimento") + ":" + comprimento + ", " + mensagens.getString("largura") + ":" + largura + ", " + mensagens.getString("altura") + ":"
                + altura + ", " + mensagens.getString("areaTotal") + ":" + areaTotal + ", " + mensagens.getString("potenciaMedia") + ":"
                + +potenciaMedia + ", " + mensagens.getString("numPessoas") + ":" + numPessoas + ", " + mensagens.getString("temperatura") + ":"
                + temperaturaEx + ", " + mensagens.getString("numAparelhos") + ":" + numAparelhos;
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

    public void criarFicheiroHTML(String f) throws IOException {

        try {
            File fich = new File(f + "\\" + mensagens.getString("resultados") + ".html");
            BufferedWriter out = new BufferedWriter(new FileWriter(fich));
            out.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles(1).php\">\n");
            out.write("<title>" + mensagens.getString("resultados") + ":" + "</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h1>" + mensagens.getString("parametros") + ":" + "</h1>\n");
            out.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("dimTitulo") + ".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("limites") + ".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("aberturas") + ".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("outros") + ".html\">" + mensagens.getString("outros") + "</a></li>\n" + "</ul>");

            out.write("<hr>\n</body></html>");
            out.close();

            File dim = new File(f + "\\" + mensagens.getString("dimTitulo") + ".html");
            BufferedWriter out2 = new BufferedWriter(new FileWriter(dim));

            out2.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out2.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles(1).php\">\n");
            out2.write("<title>" + mensagens.getString("dimTitulo") + ":</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out2.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("resultados") + ".html\">" + mensagens.getString("home") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("limites") + ".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("aberturas") + ".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("outros") + ".html\">" + mensagens.getString("outros") + "</a></li>\n" + "</ul>");
            out2.write("<h2>" + mensagens.getString("dimTitulo") + ":</h2>" + "<h4>" + mensagens.getString("comprimento") + ": " + getComprimento() + " m<br>" + mensagens.getString("altura") + ": " + getAltura() + " m<br>" + mensagens.getString("largura") + ": " + getLargura() + " m<br>" + mensagens.getString("areaTotal") + ": " + getAreaTotal() + " m&sup3;</h4>\n");
            out2.write("<hr>\n</body></html>");
            out2.close();

            File lim = new File(f + "\\" + mensagens.getString("limites") + ".html");
            BufferedWriter out3 = new BufferedWriter(new FileWriter(lim));

            out3.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out3.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles(1).php\">\n");
            out3.write("<title>" + mensagens.getString("limites") + ":</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out3.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("resultados") + ".html\">" + mensagens.getString("home") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("dimTitulo") + ".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("aberturas") + ".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("outros") + ".html\">" + mensagens.getString("outros") + "</a></li>\n" + "</ul>");

            int i = 1;
            out3.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>" + mensagens.getString("numero") + "</td>\n<td>" + mensagens.getString("limite") + "</td>\n<td>" + mensagens.getString("material") + "</td>\n<td>" + mensagens.getString("altura") + " (m)</td>\n<td>" + mensagens.getString("largura") + " (m)</td>\n<td>" + mensagens.getString("espessura") + " (m)</td>\n</tr>");

            for (Limite temp : listaLim) {
                for (Camada ls : temp.getListaCamadas()) {
                    out3.write("<tr>\n<td>" + i + "</td>\n<td>" +ls.getLimite().getTipo()+ "</td>\n<td>" +ls.getMaterial().getNome()+ "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" +ls.getEspessura()+ "</td></tr>");
                    i++;
                }
            }
            out3.write("</table>");

            out3.write("<hr>\n</body></html>");
            out3.close();

            File abe = new File(f + "\\" + mensagens.getString("aberturas") + ".html");
            BufferedWriter out4 = new BufferedWriter(new FileWriter(abe));

            out4.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out4.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles(1).php\">\n");
            out4.write("<title>" + mensagens.getString("aberturas") + ":</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n");
            out4.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("resultados") + ".html\">" + mensagens.getString("home") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("dimTitulo") + ".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("limites") + ".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("outros") + ".html\">" + mensagens.getString("outros") + "</a></li>\n" + "</ul>");

            i = 1;
            out4.write("<table border=\"2\" style=\"width:50%\">\n<tr><td>" + mensagens.getString("numero") + "</td>\n<td>" + mensagens.getString("limite") + "</td>\n<td>" + mensagens.getString("material") + "</td>\n<td>" + mensagens.getString("altura") + " (m)</td>\n<td>" + mensagens.getString("largura") + " (m)</td>\n<td>" + mensagens.getString("espessura") + " (m)</td>\n</tr>");

            for (Limite temp : listaLim) {
                for (Abertu ls : temp.getListaAberturas()) {
                    out4.write("<tr>\n<td>" + i + "</td>\n<td>" +ls.getLimite().getTipo()+ "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
                    i++;
                }
            }
            out4.write("</table>");

            out4.write("<hr>\n</body></html>");
            out4.close();

            File outro = new File(f + "\\" + mensagens.getString("outros") + ".html");
            BufferedWriter out5 = new BufferedWriter(new FileWriter(outro));
            out5.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out5.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "/styles(1).php\">\n");
            out5.write("<title>" + mensagens.getString("resultados") + ":</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h1>" + mensagens.getString("parametros") + ":</h1>\n");
            out5.write("<ul>\n" + "  <li><a href=\""+mensagens.getString("resultados")+".html\">" + mensagens.getString("home") + "</a></li>\n" + "  <li><a href=\""+mensagens.getString("dimTitulo")+".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\""+mensagens.getString("limites")+".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\""+mensagens.getString("aberturas")+".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "</ul>");
            out5.write("<h4>" + mensagens.getString("numPessoas") + " : " + getNumPessoas() + "</h4>\n");
            out5.write("<h4>" + mensagens.getString("numAparelhos") + " : " + getNumAparelhos() + "</h4>\n");
            out5.write("<h4>" + mensagens.getString("potenciaMedia") + " : " + getPotenciaMedia() + " Wh</h4>\n");
            out5.write("<h4>" + mensagens.getString("temperaturaExt") + " : " + getTemperaturaEx() + " &deg;C</h4>\n");
            out5.write("<h4>" + mensagens.getString("temperaturadesej") + ": " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Erro - " + e.getLocalizedMessage());
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
        this.mensagens = ResourceBundle.getBundle("MensagensBundle", currentLocale);
        
    }

    /**
     * @return the listaMaterial
     */
    public Material getMaterialpeloNome(String tipo) {
        return listaMaterial.get(tipo);
    }

    /**
     * @param listaMaterial the listaMaterial to set
     */
    public void criarListaMaterial() {
        listaMaterial.put(mensagens.getString("aluminio"),new Aluminio(this));
        listaMaterial.put(mensagens.getString("ar"), new Ar(this));
        listaMaterial.put(mensagens.getString("betao"), new Betao(this));
        listaMaterial.put(mensagens.getString("cimento"), new Cimento(this));
        listaMaterial.put(mensagens.getString("madeira"), new Madeira(this));
        listaMaterial.put(mensagens.getString("tijolo"), new Tijolo(this));
        listaMaterial.put(mensagens.getString("vidro"), new Vidro(this));
    }

}
