package domein_klassen;

public class Resultaat implements POJO_Interface {

    private int id;
    private String modulenaam;
    private float resultaat;
    private boolean voldoende;
    private int idPersoon;

    @Override
    public boolean equals(Object resultaat2) {
        if (this.getModulenaam().equals(((Resultaat) resultaat2).getModulenaam()) && this.getResultaat().equals(((Resultaat) resultaat2).getResultaat())
                && this.getIdPersoon().equals(((Resultaat) resultaat2).getIdPersoon())) {
            return true;
        } else {
            return false;
        }
    }

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

    public Float getResultaat() {
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

    public Integer getIdPersoon() {
        return idPersoon;
    }

    public void setIdPersoon(int idPersoon) {
        this.idPersoon = idPersoon;
    }
}
