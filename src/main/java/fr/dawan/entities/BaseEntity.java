package fr.dawan.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BaseEntity(Long id, Integer version) {
        this.id = id;
        this.version = version;
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity() {
    }

}
