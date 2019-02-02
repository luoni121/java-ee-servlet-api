package chyshka.domain.entities;

import javax.persistence.*;

@Entity
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Type type;

    public Product() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
