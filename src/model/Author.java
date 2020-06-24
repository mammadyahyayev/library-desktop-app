package model;

import java.sql.Blob;
import java.util.Date;

public class Author extends AbstractModel {

    private String name;
    private String surname;
    private Date birthDate;
    private Date deathDate;
    private String advanceInfo;
    private Blob img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getAdvanceInfo() {
        return advanceInfo;
    }

    public void setAdvanceInfo(String advanceInfo) {
        this.advanceInfo = advanceInfo;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

}
