package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Persons extends ForwardingSet<PersonalData> {

  private Set<PersonalData> delegate;

  public Persons(Persons persons){
    this.delegate = new HashSet<PersonalData>(persons.delegate);
  }

  public Persons(){
    this.delegate = new HashSet<PersonalData>();
  }

  @Override
  protected Set<PersonalData> delegate(){
    return delegate;
  }

  public Persons withAdded(PersonalData person){
    Persons persons = new Persons(this);
    persons.add(person);
    return persons;
  }

  public Persons without(PersonalData person){
    Persons persons = new Persons(this);
    persons.remove(person);
    return persons;
  }

}
