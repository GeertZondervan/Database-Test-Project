
package domein_klassen;

public class Resultaat implements POJO_Interface {
    private int id;
    private String modulenaam;
    private float resultaat;
    private boolean voldoende;
    private int idPersoon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModulenaam() {
        return modulenaam;
    }

    public void setModulenaam(String modulenaam) {
        this.modulenaam = modulenaam;
    }

    public float getResultaat() {
        return resultaat;
    }

    public void setResultaat(float resultaat) {
        this.resultaat = resultaat;
    }

    public boolean isVoldoende() {
        return voldoende;
    }

    public void setVoldoende(boolean voldoende) {
        this.voldoende = voldoende;
    }
    
    public int getIdPersoon() {
        return idPersoon;
    }

    public void setIdPersoon(int idPersoon) {
        this.idPersoon = idPersoon;
    }
}
