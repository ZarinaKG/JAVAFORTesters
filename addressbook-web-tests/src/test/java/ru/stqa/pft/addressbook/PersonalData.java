package ru.stqa.pft.addressbook;

public class PersonalData {
  private final String name;
  private final String surname;
  private final String company;
  private final String tel;
  private final String email;
  private final String day;
  private final String month;
  private final String year;
  private final String address;

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
