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
public class Camada implements java.io.Serializable{

    private Material material;
    private double altura, largura, espessura;
    private SimController dc;
    private Aluminio al ;
    private Madeira ma;
    private Betao be;
    private Vidro vi;
    private Ar a;

    public Camada(Material material, double altura, double largura, double espessura,SimController d) {
        this.material = material;

        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.dc=d;
        this.al = new Aluminio(dc) ;
        this.ma = new Madeira(dc);
        this.be = new Betao(dc);
        this.vi = new Vidro(dc);
        this.a = new Ar(dc);
    }

    public Camada(SimController d) {
        this.material = new Material();
        
        this.altura = 0;
        this.largura = 0;
        this.espessura = 0;
        this.dc=d;
        this.al = new Aluminio(dc) ;
        this.ma = new Madeira(dc);
        this.be = new Betao(dc);
        this.vi = new Vidro(dc);
        this.a = new Ar(dc);
    }

    public Material getMaterial() {
        return material;
    }

    public double getEspessura() {
        return espessura;
    }


    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMaterialPeloNome(String tipo) {
        if (tipo.equals(vi.getNome())) {
            this.material = new Vidro(dc);
        } else {
            if (tipo.equals(be.getNome())) {
                this.material = new Betao(dc);
            } else {
                if (tipo.equals(al.getNome())) {
                    this.material = new Aluminio(dc);
                } else {
                    if (tipo.equals(a.getNome())) {
                        this.material = new Ar(dc);
                    } else {
                        if (tipo.equals(ma.getNome())) {
                            this.material = new Madeira(dc);
                        }
                    }
                }
            }
        }
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    @Override
    public String toString() {
        return  material.getNome() + " | "+altura  + " | "+largura +" | "+ espessura;
    }

}

