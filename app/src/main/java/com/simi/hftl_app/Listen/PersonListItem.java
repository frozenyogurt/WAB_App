package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Model.Person;

/**
 * Created by student on 11.02.2016.
 */
public class PersonListItem
{
    private String name;
    private Person person;
    private String description;

    public PersonListItem(String name, Person person, String description)
    {
        this.name = name;
        this.description = description;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
