package com.api.challenge.invoicesynchronizer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CursorEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cursor_pointer", unique = true)
    private Long cursor;

    public CursorEntity() {

    }

    public CursorEntity(Long cursor) {
        this.cursor = cursor;
    }

    public CursorEntity(Long id, Long cursor) {
        this.id = id;
        this.cursor = cursor;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursor() {
        return cursor;
    }
    public void setCursor(Long cursor) {
        this.cursor = cursor;
    }
}
