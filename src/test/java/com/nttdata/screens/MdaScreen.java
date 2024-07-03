package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MdaScreen extends PageObject {
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")
    private List<WebElement> lista;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")
    private WebElement producto1;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bolt T-Shirt\"]")
    private WebElement producto2;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bike Light\"]")
    private WebElement producto3;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement aumentarCantidadBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAgregarcarrito;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement btnIrAlCarrito;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")
    private List<WebElement> validarCarrito;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")
    private WebElement cantidaCarro;


    public void cantidadProductos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")));
        System.out.println("Cantidad de productos: " + lista.size());
    }
    public int validarCargaProductos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")));
        return lista.size();
    }

    public void esperarCargaProductos() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(lista));
    }
    public void seleccionarYAumentarCantidadProducto(String nombreProducto, int cantidad) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);

        WebElement producto = null;
        switch (nombreProducto) {
            case "Sauce Labs Backpack":
                producto = producto1;
                break;
            case "Sauce Labs Bolt - T-Shirt":
                producto = producto2;
                break;
            case "Sauce Labs Bike Light":
                producto = producto3;
                break;
            default:
                throw new IllegalArgumentException("Producto no encontrado: " + nombreProducto);
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(producto));
            producto.click();

            wait.until(ExpectedConditions.visibilityOf(aumentarCantidadBtn));
            for (int i = 1; i < cantidad; i++) {
                aumentarCantidadBtn.click();
            }

        }catch (Exception e){
            System.out.println("Error al seleccionar el producto " + nombreProducto + ": " + e.getMessage());
        }

    }

    public void clickagregarcarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(btnAgregarcarrito));
        btnAgregarcarrito.click();
    }

    public void clickIrAlCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(btnIrAlCarrito));
        btnIrAlCarrito.click();
    }


    public int validarcantidadCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")));
        return validarCarrito.size();
    }
    public int validarProductoAgregadoCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")));
        return validarCarrito.size();
    }

    public void cantidadCarro(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")));
        System.out.println("Se agregaron: " + cantidaCarro.getText());
    }



}
