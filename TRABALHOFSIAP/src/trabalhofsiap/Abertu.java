/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofsiap;

/**
 *
 * @author Jecabeda
 */
public class Abertu implements java.io.Serializable{
        private Material material;
        private String tipo;
        private double altura, largura, espessura;
        
        private SimController dc;
        private Aluminio al;
        private Madeira ma;
        private Betao be;
        private Vidro vi;
        private Ar a;

public Abertu(SimController d) {
        this.altura=0;
        this.largura=0;
        this.espessura=0;
        this.material=new Material();
        this.tipo="sem tipo";
        this.dc=d;
        this.al = new Aluminio(dc) ;
        this.ma = new Madeira(dc);
        this.be = new Betao();
        this.vi = new Vidro(dc);
        this.a = new Ar();
    }

  
    public void setLargura(double la) {
        this.largura=la;
    }
    
    public void setAltura(double al) {
        this.altura=al;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }
    

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
        public void setMaterialPeloNome(String tipo) {
        if(tipo==vi.getNome())
        {
            this.material=new Vidro(dc);
        } else{
            if(tipo==be.getNome()){
                this.material= new Betao();
            } else{
            if(tipo==al.getNome()){
                this.material= new Aluminio(dc);
            } else{
            if(tipo==a.getNome()){
                this.material= new Ar();
            } else{
            if(tipo==ma.getNome()){
                this.material= new Madeira(dc);
            }
        }
        }
        }
        }
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @return the largura
     */
    public double getLargura() {
        return largura;
    }

        @Override
    public String toString(){

        return ""+this.altura+" | "+this.largura+" | "+this.material.getNome()+" | "+this.tipo+" | "+this.espessura;
    }    
    
}
