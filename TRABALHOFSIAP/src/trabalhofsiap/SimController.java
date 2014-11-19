/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
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
 * Controller do programa 
 * Os dados necessários ao funcionamento da aplicação são armazenados nesta classe
 * 
 */
public class SimController implements Serializable {

    //Medidas da sala
    private double comprimento, largura, altura, areaTotal;
    
    //Numero de pessoas e de aparelhos na sala respetivamente
    private int numPessoas;
    //Numero de pessoas e de aparelhos na sala respetivamente
    private int numAparelhos;
    
    //Temeperatura no exterior e a pretendida na sala respetivamente
    float temperaturaEx, temperaturaPre;
    
    //Lista dos limites da sala
    private List<Limite> listaLim;
    
    //Mapa da lista de materiais
    private Map<String, Material> listaMaterial;
    
    //ResourceBundle com todas as mensagens apresentadas no programa
    private transient ResourceBundle mensagens;
    
    //Inicialização da classe de cálculos
    private Calculos calc;

    /**
     * 
     * Construtor do controllador com todos os dados
     * 
     * @param comprimento
     * @param largura
     * @param altura
     * @param volume
     * @param numPessoas
     * @param temperaturaEx
     * @param temperaturaInt
     * @param temperaturaPre
     * @param numAparelhos
     * @param listaLim 
     */
    public SimController(float comprimento, double largura, double altura, double volume, int numPessoas, int temperaturaEx, int temperaturaInt, int temperaturaPre, int numAparelhos, List<Limite> listaLim) {
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.areaTotal = volume;
        this.numPessoas = numPessoas;
        this.temperaturaEx = temperaturaEx;
        this.temperaturaPre = temperaturaPre;
        this.numAparelhos = numAparelhos;
        this.listaLim = listaLim;
        listaMaterial = new HashMap<String, Material>();
        this.calc = new Calculos(this);
    }

    /**
     * 
     * Construtor vazio
     * 
     */
    public SimController() {
        this.comprimento = 0;
        this.largura = 0;
        this.altura = 0;
        this.areaTotal = 0;
        this.numPessoas = 0;
        this.temperaturaEx = 0;
        this.temperaturaPre = 0;
        this.listaLim = new ArrayList();
        listaMaterial = new HashMap<String, Material>();
        this.calc = new Calculos(this);
    }

    /**
     * 
     * Construtor cópia
     * 
     * @param dc 
     */
    public SimController(SimController dc) {
        this.comprimento = dc.comprimento;
        this.largura = dc.largura;
        this.altura = dc.largura;
        this.areaTotal = dc.areaTotal;
        this.numPessoas = dc.numPessoas;
        this.temperaturaEx = dc.temperaturaEx;
        this.temperaturaPre = dc.temperaturaPre;
        this.numAparelhos = dc.numAparelhos;
        listaMaterial = new HashMap<String, Material>();
        this.calc = new Calculos(this);
    }

    /**
     * 
     * Get do comprimento
     * 
     * @return 
     */
    public double getComprimento() {
        return comprimento;
    }

    /**
     * 
     * Get da largura
     * 
     * @return 
     */
    public double getLargura() {
        return largura;
    }

    /**
     * 
     * Get da altura
     * 
     * @return 
     */
    public double getAltura() {
        return altura;
    }

    /**
     * 
     * Get da temperatura exterior
     * 
     * @return 
     */
    public float getTemperaturaEx() {
        return temperaturaEx;
    }

    /**
     * 
     * Get da temperatura pretendida
     * 
     * @return 
     */
    public float getTemperaturaPre() {
        return temperaturaPre;
    }

    /**
     * 
     * Get da área total
     * 
     * @return 
     */
    public double getAreaTotal() {

        return areaTotal;
    }

    /**
     * 
     * Get do numero de pessoas na sala
     * 
     * @return 
     */
    public int getNumPessoas() {
        return numPessoas;
    }

    /**
     * 
     * Get do numero de aparelhos na sala
     * 
     * @return 
     */
    public int getNumAparelhos() {
        return numAparelhos;
    }

    /**
     * 
     * Get da lista de limites
     * 
     * @return 
     */
    public List<Limite> getListaLim() {
        return listaLim;
    }
    
    /**
     * 
     * Get da lista de aberturas de todos os limites
     * 
     * @return 
     */
    public List<Abertu> getListaAberturas() {
        List<Abertu> temp = new ArrayList();
        for (Limite lim : listaLim) {
            for (Abertu aber : lim.getListaAberturas()) {
                temp.add(aber);
            }
        }
        return temp;
    }

    /**
     * 
     * Get da lista de Camadas de todos os limites
     * 
     * @return 
     */
    public List<Camada> getListaCamadas() {
        List<Camada> temp = new ArrayList();
        for (Limite lim : listaLim) {
            for (Camada cam : lim.getListaCamadas()) {
                temp.add(cam);
            }
        }
        return temp;
    }
    
    
    /**
     * 
     * Get das mensagens do resourcebundle
     * 
     * @return the mensagens
     */
    public ResourceBundle getMensagens() {
        return mensagens;
    }



    /**
     * 
     * Get do material pelo nome
     * 
     * @return the listaMaterial
     */
    public Material getMaterialpeloNome(String tipo) {
        return listaMaterial.get(tipo);
    }


    /**
     * 
     * Set de comprimento
     * 
     * @param comprimento 
     */
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * 
     * Set da largura
     * 
     * @param largura 
     */
    public void setLargura(double largura) {
        this.largura = largura;
    }

    /**
     * 
     * Set da altura
     * 
     * @param altura 
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * 
     * Set da área total
     * 
     */
    public void setAreaTotal() {
        areaTotal = 2 * ((comprimento * largura) + (comprimento * altura) + (altura * largura));

    }

    /**
     * 
     * Set da área total
     * 
     * @param area 
     */
    public void setAreaTotal(double area) {
        this.areaTotal = area;
    }

    /**
     * 
     * Set do numero de pessoas na sala
     * 
     * @param numPessoas 
     */
    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    /**
     * 
     * Set da temperatura Exterior
     * 
     * @param temperatura 
     */
    public void setTemperaturaEx(float temperatura) {
        this.temperaturaEx = temperatura;
    }

    /**
     * 
     * Set da temperatura Pretendida na sala
     * 
     * @param temperaturaPre 
     */
    public void setTemperaturaPre(float temperaturaPre) {
        this.temperaturaPre = temperaturaPre;
    }

    /**
     * 
     * Sett do número de aparelhos na sala
     * 
     * @param numAparelhos 
     */
    public void setNumAparelhos(int numAparelhos) {
        this.numAparelhos = numAparelhos;
    }
    
        /**
     * 
     * Método para definir linguagem
     * 
     */
    public void setMensagens(Locale currentLocale) {
        this.mensagens = ResourceBundle.getBundle("MensagensBundle", currentLocale);

    }
    
    
    /**
     * 
     * Set da lista de materiais
     * 
     * @param listaLim the listaLim to set
     */
    public void setListaLim(List<Limite> listaLim) {
        this.listaLim = listaLim;
    }
    
    
    /**
     * 
     * Método para adicionar limite 
     * 
     * @param listaLim 
     */
    public void addLim(Limite listaLim) {

        (this.listaLim).add(listaLim);
    }
    
    /**
     * 
     * Método para alterar os dados de um limite
     * 
     * @param listaLim2 
     */
    public void altLim(Limite listaLim2) {
        for (Limite listaLim1 : listaLim) {
            if (listaLim1.equals(listaLim2)) {
                listaLim1.setAltura(listaLim2.getAltura());
                listaLim1.setLargura(listaLim2.getLargura());
                listaLim1.setTipo(listaLim2.getTipo());
            }
        }
    }

    /**
     * 
     * Método para escrever a toString da classe
     * 
     * @return 
     */
    @Override
    public String toString() {

        return mensagens.getString("comprimento") + ":" + comprimento + ", " + mensagens.getString("largura") + ":" + largura + ", " + mensagens.getString("altura") + ":"
                + altura + ", " + mensagens.getString("areaTotal") + ":" + areaTotal + ", " + mensagens.getString("potenciaMedia") + ":"
                + ", " + mensagens.getString("numPessoas") + ":" + getNumPessoas() + ", " + mensagens.getString("temperatura") + ":"
                + temperaturaEx + ", " + mensagens.getString("numAparelhos") + ":" + getNumAparelhos();
    }


    /**
     * 
     * Método para criar ficheiro HTML com os dados introduzidos e respetivo resultado 
     * 
     * @param f
     * @throws IOException 
     */
    public void criarFicheiroHTML(String f) throws IOException {

        try {
            File fich = new File(f + "\\" + mensagens.getString("resultados") + ".html");
            BufferedWriter out = new BufferedWriter(new FileWriter(fich));
            out.write("<!DOCTYPE html PUBLIC " + "\"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + "\n");
            out.write("<script type=\"text/javascript\" src=\"./" + mensagens.getString("resultados") + "_files/ufo.js\"></script>\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles.php\">\n" + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./" + mensagens.getString("resultados") + "_files/styles(1).php\">\n");
            out.write("<title>" + mensagens.getString("resultados") + ":" + "</title>\n" + "<link rel=\"icon\" type=\"image/ico\" href=\"http://www.isep.ipp.pt/favicon.ico\">\n" + "</head>\n" + "<body>\n" + "<div>\n" + "<img src=\"http://www.dei.isep.ipp.pt/images/topo_index.png\" alt=\"Logotipo ISEP\">\n"
                    + "</div>\n" + "<hr>\n" + "<h2>" + mensagens.getString("parametros") + ":" + "</h2>\n");
            out.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("dimTitulo") + ".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("limites") + ".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("aberturas") + ".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("outros") + ".html\">" + mensagens.getString("outros") + "</a></li>\n" + "</ul>");
            out.write("<h1>" + mensagens.getString("resultados") + ":" + "</h1>\n");
            out.write("<h4>" + mensagens.getString("fluxoCalor1") + " : " + calc.FluxoCalor1() + " W/m&sup2</h4>\n");
            out.write("<h4>" + mensagens.getString("fluxoCalor2") + " : " + calc.FluxoCalor2() +  " W/m&sup2</h4>\n");
            out.write("<h4>" + mensagens.getString("potenciaRecomendada") + " : " + calc.PotenciaFinal() + " W</h4>\n");
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
                    out3.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getLimite().getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "</td>\n<td>" + ls.getEspessura() + "</td></tr>");
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
                    out4.write("<tr>\n<td>" + i + "</td>\n<td>" + ls.getLimite().getTipo() + "</td>\n<td>" + ls.getMaterial().getNome() + "</td>\n<td>" + ls.getAltura() + "</td>\n<td>" + ls.getLargura() + "\n<td>" + ls.getEspessura() + "</td></tr>");
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
            out5.write("<ul>\n" + "  <li><a href=\"" + mensagens.getString("resultados") + ".html\">" + mensagens.getString("home") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("dimTitulo") + ".html\">" + mensagens.getString("dimTitulo") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("limites") + ".html\">" + mensagens.getString("limites") + "</a></li>\n" + "  <li><a href=\"" + mensagens.getString("aberturas") + ".html\">" + mensagens.getString("aberturas") + "</a></li>\n" + "</ul>");
            out5.write("<h4>" + mensagens.getString("numPessoas") + " : " + getNumPessoas() + "</h4>\n");
            out5.write("<h4>" + mensagens.getString("numAparelhos") + " : " + getNumAparelhos() + "</h4>\n");
            out5.write("<h4>" + mensagens.getString("temperaturaExt") + " : " + getTemperaturaEx() + " &deg;C</h4>\n");
            out5.write("<h4>" + mensagens.getString("temperaturadesej") + ": " + getTemperaturaPre() + " &deg;C</h4>\n");

            out5.write("<hr>\n</body></html>");
            out5.close();

            Desktop.getDesktop().browse(fich.toURI());

        } catch (IOException e) {
            System.out.println("Erro - " + e.getLocalizedMessage());
        }

    }

    /**
     * 
     * Método para guardar os resultados num ficheiro binário
     * 
     * @param f 
     */
    public void guardarDados(String f) {
        try {
            FileOutputStream fileOut = new FileOutputStream(f + "\\" + f + ".bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);


            out.writeObject(getAltura());
            out.writeObject(getLargura());
            out.writeObject(getComprimento());
            out.writeObject(getAreaTotal());

            out.writeObject(listaLim.size());
            for (Limite temp : listaLim) {
                out.writeObject(temp);
            }

            out.writeObject(getNumPessoas());
            out.writeObject(getNumAparelhos());
            out.writeObject(getTemperaturaEx());
            out.writeObject(getTemperaturaPre());

            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * 
     * Método para ler um ficheiro binário com os dados introduzidos anteriormente
     * 
     * @param f 
     */
    public void introduzirDados(File f) {
        try {
            FileInputStream fileIn = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fileIn);


            setAltura((double) in.readObject());
            setLargura((double) in.readObject());
            setComprimento((double) in.readObject());
            setAreaTotal((double) in.readObject());
            
            

            List<Limite> lsl = new ArrayList<>();
            int cont = (int) in.readObject();
            for (int i = 0; i < cont; i++) {
                lsl.add((Limite) (in.readObject()));
            }
            setListaLim(lsl);

            setNumPessoas((int) in.readObject());
            setNumAparelhos((int) in.readObject());
            setTemperaturaEx((float) in.readObject());
            setTemperaturaPre((float) in.readObject());

            in.close();
            fileIn.close();
        
        Aluminio al = (Aluminio) getMaterialpeloNome(mensagens.getString("aluminio"));
        al.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("aluminio"),al);
        Madeira ma = (Madeira) getMaterialpeloNome(mensagens.getString("madeira"));
        ma.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("madeira"),ma);
        Vidro vi = (Vidro) getMaterialpeloNome(mensagens.getString("vidro"));
        vi.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("vidro"),vi);
        Ar ar = (Ar) getMaterialpeloNome(mensagens.getString("ar"));
        ar.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("ar"),ar);
        Betao be  = (Betao)getMaterialpeloNome(mensagens.getString("betao"));
        be.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("betao"),be);
        Cimento ci  = (Cimento)getMaterialpeloNome(mensagens.getString("cimento"));
        ci.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("cimento"),ci);
        Tijolo ti  = (Tijolo) getMaterialpeloNome(mensagens.getString("tijolo"));
        ti.setMensagens(mensagens);
        listaMaterial.replace(mensagens.getString("tijolo"),ti);
        
        for (Limite l : listaLim)
        {
            l.setMensagens(mensagens);
            for(Camada c : l.getListaCamadas())
            {
                c.getMaterial().setMensagens(mensagens);
            }
            for(Abertu a: l.getListaAberturas())
            {
                a.getMaterial().setMensagens(mensagens);
            }
        }
        
        } catch (IOException i) {
            System.out.println("IOException");
        } catch (ClassNotFoundException c) {

            System.out.println("Class Not Found Exception");
        }
    }

    /**
     * 
     * Método para criar lista de materiais
     * 
     */
    public void criarListaMaterial() {
        listaMaterial.put(mensagens.getString("aluminio"), new Aluminio(this.getMensagens()));
        listaMaterial.put(mensagens.getString("ar"), new Ar(this.getMensagens()));
        listaMaterial.put(mensagens.getString("betao"), new Betao(this.getMensagens()));
        listaMaterial.put(mensagens.getString("cimento"), new Cimento(this.getMensagens()));
        listaMaterial.put(mensagens.getString("madeira"), new Madeira(this.getMensagens()));
        listaMaterial.put(mensagens.getString("tijolo"), new Tijolo(this.getMensagens()));
        listaMaterial.put(mensagens.getString("vidro"), new Vidro(this.getMensagens()));
    }

}
