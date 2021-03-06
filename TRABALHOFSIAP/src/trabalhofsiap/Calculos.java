/*
 TRABALHO DE FÍSICA
 António Pinheiro 1130339
 Cristina Lopes 1130371
 Egídio Santos 1130348
 José Cabeda 1130395
 */
package trabalhofsiap;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * CLASSE CÁLCULOS Q/t gerado = T/Rt Rtotal = 1 / Somatorio (1/Rt) Q/t desejado
 * = T/Rt P ar condicionado = Q/t gerado - Q/t desejado
 */
public class Calculos implements Serializable {

    SimController dc;

    /**
     * CONSTRUTOR
     *
     * @param dc
     */
    public Calculos(SimController dc) {
        this.dc = dc;
    }

    /**
     * Cálculo da Resistência Térmica
     *
     * @param listaLim
     * @return resistencia
     */
    public double calcularResistenciaTermica(List<Limite> listaLim) {
        if (listaLim.isEmpty()) {
            return 0;
        } else {
            double resistencia = 0;
            for (int i = 0; i < listaLim.size(); i++) {
                List<Abertu> la = listaLim.get(i).getListaAberturas();
                List<Camada> lc = listaLim.get(i).getListaCamadas();
                resistencia += calculosIntermedios(la, lc);
            }
            return 1 / resistencia;
        }
    }

    /**
     * Este método irá retornar o fluxo de calor que as pessoas e os aparelhos
     * emitem 175,8 W - Potencia das pessoas 250 W - Potencia dos aparelhos
     * eletronicos
     *
     * @return fluxo de calor
     */
    public double FluxoCalor1() {
        return (dc.getNumPessoas()) * 175.8 + (dc.getNumAparelhos()) * 250;
    }

    /**
     * Calcula o fluxo de calor que é obtido com a temperatura pretendida pelo
     * utilizador
     *
     * @return fluxo de calor com a temperatura pretendida
     */
    public double FluxoCalor2() {
        return (dc.getTemperaturaPre() - dc.getTemperaturaEx()) / calcularResistenciaTermica(dc.getListaLim());
    }

    /**
     * A Potência Final do ar condicionado que e calculada pela diferença de
     * fluxos de calor
     *
     * @return potenciaFinal
     */
    public double PotenciaFinal() {
        return FluxoCalor1() - FluxoCalor2();
    }

    /**
     * Para cada limite irá calcular a resistência das aberturas e das camadas
     * Irá evocar o metodo Resistência para o cálculo da resistência ser feito R
     * = espessura / (condutividadeMaterial x Area)
     *
     * @param la
     * @param lc
     * @return soma
     */
    public double calculosIntermedios(List<Abertu> la, List<Camada> lc) {

        if (la.isEmpty() && lc.isEmpty()) {
            return 0;
        } else {
            double soma = 0;
            double tmp = 0;
            double res;

            for (int i = 0; i < la.size(); i++) {
                res = Resistencia(la.get(i).getEspessura(), la.get(i).getArea(), la.get(i).getMaterial().getCondutibilidadeTermica());
                soma += 1 / res;
                la.get(i).setFluxoCalor(res);

            }

            for (int i = 0; i < lc.size(); i++) {
                res = Resistencia(lc.get(i).getEspessura(), lc.get(i).getArea(), lc.get(i).getMaterial().getCondutibilidadeTermica());
                soma += 1 / res;
                lc.get(i).setFluxoCalor(res);
            }

            return soma;
        }
    }

    /**
     * Retorna a resistência através da fórmula R = espessura /
     * (condutividadeMaterial x Area) onde R e a Resistência
     *
     * @param espessura
     * @param Area
     * @param condutividadeMaterial
     * @return Resistencia
     */
    public double Resistencia(double espessura, double Area, double condutividadeMaterial) {
        return (espessura / (condutividadeMaterial * Area));
    }

}
