package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class HomePage {

    public HomePage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//span[@class='sc-fd984615-0 cQdZdF']")
    public WebElement otelTab;

    @FindBy(xpath = "//input[@aria-label='search-input']")
    public WebElement otelNerede;

    @FindBy(xpath = "(//a[@class='CybotCookiebotDialogBodyButton'])[3]")
    public WebElement rejectCookies;

    @FindBy(xpath = "(//div[@class='sc-7e3ac4c4-5 fuFNbC'])[1]")
    public WebElement antalya;

    @FindBy(xpath = "(//span[@class='sc-fd984615-0 cdgkri'])[2]")
    public WebElement girisCikisTarihleri;

    @FindBy(xpath = "(//span[text()='6'])[2]")
    public WebElement girisTarihi;

    @FindBy(xpath = "(//span[text()='11'])[2]")
    public WebElement cikisTarihi;

    @FindBy(xpath = "//span[@class='sc-fd984615-0 fXJEIW']")
    public WebElement konaklayacakKisiSayisiButonu;

    @FindBy(xpath = "(//span[@class='sc-fd984615-0 cIwqwF'])[2]")
    public WebElement yetiskinSayisiniArtirButonu;

    @FindBy(xpath = "//span[@data-testid='count-label'][1]")
    public WebElement defaultYetiskinSayisi;

    @FindBy(xpath = "//button[@class='sc-8de9de7b-0 cnUA-Dx']")
    public WebElement araButonu;

    @FindBy(xpath = "//span[@class='sc-fd984615-0 gjlio']")
    public WebElement digerBolgeleriGosterButonu;

    @FindBy(xpath="(//span[@class='sc-b01e5b98-3 llBFwW'])[1]")
    public WebElement otelList;

    @FindBy(xpath = "//div[@class='sc-e4b3cd20-0 ihtOYP']")
    public List<WebElement> checkboxInputs;

    @FindBy(xpath = "//div[@class='sc-8b3f244d-8 eJwjxo']")
    public List<WebElement> otellerListesi;

}
