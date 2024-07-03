package com.nttdata.steps;

import com.nttdata.screens.MdaScreen;
import org.junit.Assert;

public class MdaStep {
    MdaScreen mdaScreen;

    public void validacionCargaProductos() {
        Assert.assertTrue("No se encontraron productos en la galería", mdaScreen.validarCargaProductos() > 0);
        mdaScreen.cantidadProductos();
    }
    public void agregarUnidadesDelProducto(String producto, int unidades) {
        mdaScreen.seleccionarYAumentarCantidadProducto(producto,unidades);
        mdaScreen.clickagregarcarrito();
    }
    public void validacionProductocarrito() {
        mdaScreen.clickIrAlCarrito();
        Assert.assertTrue("No se encontraron productos en el carrito", mdaScreen.validarProductoAgregadoCarrito() > 0);
        mdaScreen.validarcantidadCarrito();
        mdaScreen.cantidadCarro();
    }




}
