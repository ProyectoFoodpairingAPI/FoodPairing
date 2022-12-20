package space.harbour.countries.domain;

public class Food {
    String id;
    String name;
    String marca;
    String categoria;

    public Food(String id, String name, String marca, String categoria) {
        this.id = id;
        this.name = name;
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }


}
