/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teepiik.SpringNews.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author teepiik
 */
@Entity
public class Item extends AbstractPersistable<Long>{
    private String king;

    public String getKing() {
        return king;
    }

    public void setKing(String king) {
        this.king = king;
    }
}
