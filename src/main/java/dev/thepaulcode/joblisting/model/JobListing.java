package dev.thepaulcode.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "JobPost")
public class JobListing {
    // Esta classe representa um documento no banco de dados com a coleção "JobPost".

    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
    // Definição dos atributos que representam os campos do documento.

    // Constructor
    public JobListing() {
        // Construtor padrão da classe.
    }

    // Getters and setters
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    // Métodos getters e setters para o atributo 'profile'.

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    // Métodos getters e setters para o atributo 'desc'.

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    // Métodos getters e setters para o atributo 'exp'.

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }
    // Métodos getters e setters para o atributo 'techs'.

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
    // Sobrescreve o método 'toString' para fornecer uma representação de string do objeto.
}

