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
public class Limite {

    private String tipo;
    private Material material;
    private double altura, largura, espessura;
    private Aluminio al ;
    private Madeira ma;
    private Betao be;
    private Vidro vi;
    private Ar a;

    public Limite(Material material, String tipo, double altura, double largura, double espessura) {
        this.material = material;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.espessura = espessura;
        this.al = new Aluminio() ;
        this.ma = new Madeira();
        this.be = new Betao();
        this.vi = new Vidro();
        this.a = new Ar();
    }

    public Limite() {
        this.material = new Material();
        this.tipo = "sem tipo";
        this.altura = 0;
        this.largura = 0;
        this.espessura = 0;
        this.al = new Aluminio() ;
        this.ma = new Madeira();
        this.be = new Betao();
        this.vi = new Vidro();
        this.a = new Ar();
    }

    public Material getMaterial() {
        return material;
    }

    public double getEspessura() {
        return espessura;
    }

    public String getTipo() {
        return tipo;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMaterialPeloNome(String tipo) {
        if (tipo.equals(vi.getNome())) {
            this.material = new Vidro();
        } else {
            if (tipo.equals(be.getNome())) {
                this.material = new Betao();
            } else {
                if (tipo.equals(al.getNome())) {
                    this.material = new Aluminio();
                } else {
                    if (tipo.equals(a.getNome())) {
                        this.material = new Ar();
                    } else {
                        if (tipo.equals(ma.getNome())) {
                            this.material = new Madeira();
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
        return  material.getNome() + "/"+tipo + "/"+altura  + "/"+largura +"/"+ espessura;
    }

}
