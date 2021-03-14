package ru.stqa.pft.addressbook.model;

public class PersonalData {
  private  String name;
  private  String surname;
  private String group;


  public PersonalData(String name, String surname, String group) {
    this.name = name;
    this.surname = surname;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }


  public String getGroup() {
    return group;
  }
}
