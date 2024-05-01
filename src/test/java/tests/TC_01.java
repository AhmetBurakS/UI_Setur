package tests;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;


public class TC_01 extends HomePage {

    @BeforeTest
    public void URL(){ Driver.getDriver().get(ConfigReader.getProperty("URL")); }


    @Test
    public void testSeturURL() {
        //1. https://www.setur.com.tr/ sayfasına gidilir.
        //2. setur url’nin geldiği kontrol edilir.
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://www.setur.com.tr/";
        Assert.assertEquals(expectedURL,actualURL);
    }


    @Test
    public void testOtelTab() {
        //3. Ana sayfada Otel tabının default geldiği kontrol edilir.
        Assert.assertTrue(otelTab.isDisplayed());
    }


    @Test
    public void testAntalya() {
        ReusableMethods.wait(10);
        rejectCookies.click();
        ReusableMethods.wait(5);


        //4. “Nereye Gideceksiniz?” alanına csv dosyasından “Antalya” yazılır ve en üsteki Antalya seçeneğine tıklanılır.
        otelNerede.sendKeys("Antalya");
        otelNerede.click();
        ReusableMethods.wait(5);
        antalya.click();


        //5. Tarih alanında Mayıs’ın ilk haftası için bir haftalık aralık seçilir.
        girisCikisTarihleri.click();
        girisTarihi.click();
        cikisTarihi.click();


        //6. Yetişkin sayısı 1 artırılır ve Yetişkin sayısının değiştiği kontrol edilir.
        konaklayacakKisiSayisiButonu.click();
        String oncekiYetiskinSayisi = defaultYetiskinSayisi.getText();
        System.out.println(oncekiYetiskinSayisi);
        yetiskinSayisiniArtirButonu.click();
        ReusableMethods.wait(5);
        String yeniYetiskinSayisi = defaultYetiskinSayisi.getText();
        System.out.println(yeniYetiskinSayisi);
        ReusableMethods.wait(5);
        Assert.assertNotEquals(oncekiYetiskinSayisi, yeniYetiskinSayisi);


        //7. “Ara” butonu’nun görünürlüğü kontrol edilir ve tıklanılır.
        araButonu.isDisplayed();
        araButonu.click();


        //8. Açılan url içinde “antalya” kelimesini içerdiği kontrol edilir.
        String pageSource = Driver.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("antalya"));


        //9. “Diğer Bölgeleri Göster” alanında rastgele tıklama metotu kullanılarak bir seçim yapılır ve “()“
        //içerisinde bulunan sayı kaydedilir.
        digerBolgeleriGosterButonu.isDisplayed();
        Random random = new Random();
        int randomIndex = random.nextInt(3); // 0 ile 5 arası rastgele bir indeks oluştur
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(checkboxInputs.get(randomIndex)).click().build().perform();
        System.out.println("checkboxList" + checkboxInputs.get(randomIndex));
        String elementText = checkboxInputs.get(randomIndex).getText();
        System.out.println("elementtext" + elementText);
        String numberInParentheses = elementText.replaceAll("[^\\d]", ""); // Sayıyı al
        int number = Integer.parseInt(numberInParentheses); // String'i integer'a çevir
        System.out.println("Kaydedilen sayı: " + number);



        /* 10. Sayfanın altında bulunan “Antalya Otelleri ve En Uygun Antalya Otel Fiyatları “ alanına
          kadar ekranda kaydırma yapılır, kaydedilen değerin 9. adımda kaydedilen değerle eşit olduğu
          kontrol edilir.
         */
        System.out.println("Oteller size : " + otellerListesi.size());
        if (number<=20) {
            Assert.assertEquals(number, otellerListesi.size());
        }else {
            Assert.assertEquals(number+"",otelList.getText());
        }

    }
}
