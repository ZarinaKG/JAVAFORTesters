package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class PersonalData {
  private int id;
  private  String name;
  private  String surname;
  private String group;

  public PersonalData() {
  }

  public PersonalData(String name, String surname, String group) {
    this.name = name;
    this.surname = surname;
    this.group = group;
  }

  public PersonalData(int id, String name, String surname, String group) {
    this.name = name;
    this.surname = surname;
    this.group = group;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public PersonalData withId(int id) {
    this.id = id;
    return this;
  }

  public int getId() {
    return id;
  }

  public PersonalData withName(String name) {
    this.name = name;
    return this;
  }

  public PersonalData withSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public PersonalData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonalData that = (PersonalData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname);
  }

  @Override
  public String toString() {
    return "PersonalData{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }
}
