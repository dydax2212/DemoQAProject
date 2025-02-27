package Pages;

import HelperMethods.ElementsMethod;
import ObjectData.PracticeFormObjectData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {
    WebDriver driver;
    ElementsMethod elementsMethod;


    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethod = new ElementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement emailField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherElement;

    @FindBy(id = "userNumber")
    WebElement numberField;

    @FindBy(id = "dateOfBirthInput")
    WebElement calendar;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement selectMonth;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement selectYear;


    @FindBy(id = "subjectsInput")
    WebElement subjectField;

    @FindBy(xpath = "//*[@for='hobbies-checkbox-1']")
    WebElement sportsCheckbox;

    @FindBy(xpath = "//*[@for='hobbies-checkbox-2']")
    WebElement readingCheckbox;

    @FindBy(xpath = "//*[@for='hobbies-checkbox-3']")
    WebElement musicCheckbox;

    @FindBy(id = "uploadPicture")
    WebElement uploadButton;

    @FindBy(id = "currentAddress")
    WebElement addressField;

    @FindBy(id = "react-select-3-input")
    WebElement stateField;

    @FindBy(id = "react-select-4-input")
    WebElement cityField;

    public void fillFirstRegion(PracticeFormObjectData data){
        elementsMethod.sendTextToTextbox(firstNameField, data.getFirstName());
        elementsMethod.sendTextToTextbox(lastNameField, data.getLastName());
        elementsMethod.sendTextToTextbox(emailField, data.getEmail());
        elementsMethod.sendTextToTextbox(numberField, data.getMobile());
    }

    public void selectGenderInPracticeForm(PracticeFormObjectData data){

        List<WebElement> genderList = new ArrayList<>();
        genderList.add(maleElement);
        genderList.add(femaleElement);
        genderList.add(otherElement);

        elementsMethod.clickOnElementByText(genderList, data.getGender());

    }

    public void setSubjects(PracticeFormObjectData data) {
        elementsMethod.enterTextInTextBoxWithSearch(subjectField, data.getSubject());
    }

    public void addAddressStateCity(PracticeFormObjectData data) {
        elementsMethod.sendTextToTextbox(addressField,data.getCurrentAddress());
        elementsMethod.selectOptionFromDropdown(stateField, data.getState());
        elementsMethod.selectOptionFromDropdown(cityField, data.getCity());
    }

    public void uploadImage (PracticeFormObjectData data) {
        File poza = new File(data.getImagePath());
        String absPath = poza.getAbsolutePath();
        uploadButton.sendKeys(absPath);
    }


    private WebElement returnDayElement (String day){
        if (Integer.parseInt(day) < 10) {
            return driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--00"+day+"']"));
        } else {
            return driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0"+day+"']"));
        }
    }

     public void setDateOfBirthInCalendar(String month, String year, String day) {
        elementsMethod.clickOnElement(calendar);
        elementsMethod.clickOnElementInDropdown(selectMonth, month);
        elementsMethod.clickOnElementInDropdown(selectYear, year);
        WebElement selectDay = returnDayElement(day);
         elementsMethod.clickOnElementInDropdown(selectDay, day);
    }

    public void selectHobbyInPracticeForm(PracticeFormObjectData data) {

        String[] numeHobbies = data.getHobby().split(",");



        List<WebElement> listaHobbies = new ArrayList<>();
        listaHobbies.add(sportsCheckbox);
        listaHobbies.add(readingCheckbox);
        listaHobbies.add(musicCheckbox);

        for (String hobby : numeHobbies){
            elementsMethod.clickOnCheckBoxByText(listaHobbies, hobby);
        }
    }



}
