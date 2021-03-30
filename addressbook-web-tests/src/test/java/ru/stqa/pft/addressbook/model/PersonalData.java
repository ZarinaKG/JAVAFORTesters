package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class PersonalData {
  private int id;
  private  String name;
  private  String surname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String address;
  private String addressSecondary;
  private String privateEmail;
  private String workEmail;
  private String hobbyEmail;

  public File getPhoto() {
    return photo;
  }

  private File photo;

  public String getPrivateEmail() {
    return privateEmail;
  }

  public String getWorkEmail() {
    return workEmail;
  }

  public String getHobbyEmail() {
    return hobbyEmail;
  }

  public String getAddressSecondary() {
    return addressSecondary;
  }
  public PersonalData withHobbyEmail(String hobbyEmail) {
    this.hobbyEmail = hobbyEmail;
    return this;
  }


  public PersonalData withPrivateEmail(String privateEmail) {
    this.privateEmail = privateEmail;
    return this;
  }

  public PersonalData withWorkEmail(String workEmail) {
    this.workEmail = workEmail;
    return this;
  }

  public PersonalData withAddressSecondary(String addressSecondary) {
    this.addressSecondary = addressSecondary;
    return this;
  }

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

  public PersonalData  withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public PersonalData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public PersonalData  withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }
  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String  getAddress() {
    return address;

  }

  public PersonalData withAddress(String address) {
    this.address = address;
    return this;
  }

  public PersonalData withPhoto(File photo) {
    this.photo = photo;
    return this;
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
