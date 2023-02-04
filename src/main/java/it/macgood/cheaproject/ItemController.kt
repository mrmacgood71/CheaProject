package it.macgood.cheaproject

import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/item")
class ItemController{

    init {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/static/chromedriver.exe")
    }

    @GetMapping
    fun getItem(): Item {

        val driver: WebDriver = ChromeDriver()
//        val url: String = "https://www.citilink.ru/product/smartfon-infinix-hot-20i-x665e-64gb-4gb-chernyi-3g-4g-2sim-6-6-ips-720-1851634/"
        val url: String = "https://www.dns-shop.ru/product/3f06b85d6c4f3330/holodilnik-side-by-side-dexp-sbs510m-serebristyj/"

        driver[url]
        var item = Item(0, "", "")
        try {
            var price: WebElement = driver.findElement(By.cssSelector(".product-buy__price"))
            val name = driver.findElement(By.cssSelector(".product-card-top__name"))


            item = Item(1, name = name.text, price = price.text)

        } catch (e: NoSuchElementException) {
            Thread.sleep(5000)
            val price = driver.findElement(By.cssSelector(".product-buy__price"))
            val name = driver.findElement(By.cssSelector(".product-card-top__name"))
            item = Item(1, name = name.text, price = price.text)
        }




        driver.quit()

        return item
    }
}
