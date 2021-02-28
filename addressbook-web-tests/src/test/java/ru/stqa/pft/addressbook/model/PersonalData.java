package ru.stqa.pft.addressbook.model;

public class PersonalData {
  private  String name;
  private  String surname;
  private  String company;
  private  String tel;
  private  String email;
  private  String day;
  private  String month;
  private  String year;
  private  String address;

  public PersonalData(String name, String surname, String company, String tel, String email, String day, String month, String year, String address) {
    this.name = name;
    this.surname = surname;
    this.company = company;
    this.tel = tel;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCompany() {
    return company;
  }

  public String getTel() {
    return tel;
  }

  public String getEmail() {
    return email;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }

  public String getAddress() {
    return address;
  }
}
