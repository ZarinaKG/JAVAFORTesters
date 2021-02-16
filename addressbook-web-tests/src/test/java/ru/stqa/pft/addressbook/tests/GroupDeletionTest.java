package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
  private WebDriver wd;

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
