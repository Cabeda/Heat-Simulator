/*
TRABALHO DE FÍSICA
António Pinheiro 1130339
Cristina Lopes 1130371
Egídio Santos 1130348
José Cabeda 1130395
 */
package trabalhofsiap;

import java.util.List;

/**
 * CLASSE EM MANUTENÇÃO
 */
public class Calculos {
    
    SimController dc;
    
    /**
     * CONSTRUTOR
     * @param dc 
     */
    public Calculos(SimController dc){
        this.dc = dc;
        PotenciaFinal();
    }
   
    /**
     * Cálculo da Resistência Térmica
     * @param listaLim
     * @return resistencia
     */
public double calcularResistenciaTermica(List<Limite> listaLim){
    
    double resistencia = 0;
    for (int i = 0; i < listaLim.size(); i++){
    List<Abertu> la = listaLim.get(i).getListaAberturas();
    List<Camada> lc = listaLim.get(i).getListaCamadas();
    resistencia += calculosIntermedios(la, lc);
    }
        return resistencia;
}

/**
 * Este método irá retornar a energia que as pessoas e os aparelhos emitem
 * @param numPessoas numero de pessoas existentes no ambiente
 * @param numAparelhos numero de aparelhos existentes no ambiente
 * @return fluxo de calor
 */
public double PessoasEAparelhos (int numPessoas, int numAparelhos){
    return (numPessoas+numAparelhos)*175.8;
}

/**
 * Cálculo da temperatura Interior do ambiente 
 * @return temperatura interior
 */
public double temperaturaInterior(){
    return dc.getTemperaturaEx() + calcularResistenciaTermica(dc.getListaLim())*PessoasEAparelhos(dc.numPessoas, dc.numAparelhos);
}

/**
 * Calcula o fluxo de calor que é obtido com a temperatura pretendida pelo utilizador
 * @return fluxo de calor com a temperatura pretendida
 */
public double FluxoCalor1(){
    return (dc.getTemperaturaPre()-dc.getTemperaturaEx())/calcularResistenciaTermica(dc.getListaLim());
}

/**
 * Calcula o fluxo de calor que existia na sala evocando o método temperatura interior
 * @return fluxo de calor que existia na sala
 */
public double FluxoCalor2(){
    return (temperaturaInterior()-dc.getTemperaturaEx())/calcularResistenciaTermica(dc.getListaLim());
}

/**
 * A Potência Final do ar condicionado que e calculada por Q2/T2 - Q2/T2
 * @return potenciaFinal
 */
public double PotenciaFinal(){
    return FluxoCalor2()-FluxoCalor1();
}

/**
 * Para cada limite irá calcular a resistência das aberturas e das camadas
 * Irá evocar o metodo Resistência para o cálculo da resistência ser feito R = espessura / (condutividadeMaterial x Area)
 * @param la
 * @param lc
 * @return soma
 */
public double calculosIntermedios(List<Abertu> la, List<Camada> lc){
    
    double soma = 0;
    
    for (int i = 0; i < la.size(); i++){
        soma += Resistencia (la.get(i).getEspessura(), la.get(i).getArea(), la.get(i).getMaterial().getCondutibilidadeTermica());
    }
    
    for (int i = 0; i < lc.size(); i++){
        soma += Resistencia (lc.get(i).getEspessura(), lc.get(i).getArea(), lc.get(i).getMaterial().getCondutibilidadeTermica());
    }
    
    return soma;
}

/**
 * Retorna a resistência através da fórmula R = espessura / (condutividadeMaterial x Area) onde R e a Resistência
 * @param espessura
 * @param Area
 * @param condutividadeMaterial
 * @return Resistencia
 */
public double Resistencia(double espessura, double Area, double condutividadeMaterial){
    
    return (espessura / (condutividadeMaterial*Area));
}

}



