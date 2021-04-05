package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.PersonalData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names= "-c", description="Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch(ParameterException ex) {
     jCommander.usage();
     return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<PersonalData> contacts = generateContacts(count);
    if(format.equals("csv")){
      saveAsCSV(contacts,new File(file));
    }
    else if(format.equals("xml")){
      saveAsXML(contacts,new File(file));
    }
    else if(format.equals("json")){
      saveAsJSON(contacts,new File(file));
    }
    else {
      System.out.println("Unrecognized format " +format);
    }

  }

  private void saveAsJSON(List<PersonalData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXML(List<PersonalData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(PersonalData.class);
   // xstream.alias("contact",PersonalData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCSV(List<PersonalData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for(PersonalData contact: contacts){
      writer.write(String.format("%s;%s;%s\n",contact.getName(), contact.getSurname(), contact.getHomePhone()));
    }
    writer.close();
  }

  private List<PersonalData> generateContacts(int count) {
    List<PersonalData> contacts = new ArrayList<PersonalData>();
    for(int i = 0; i<count; i++){
      contacts.add(new PersonalData().withName(String.format("contact %s",i)).withSurname(String.format("name %s",i)).withHomePhone(String.format("7878 76768 676 %s",i)));
    }
    return contacts;
  }
}
