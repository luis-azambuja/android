package app.com.aula01;

/**
 * Created by sala01 on 09/05/2017.
 */

public class Usr {

    private String name;
    private String description;

    public Usr(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
