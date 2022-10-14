﻿# GuessNumber
Este proyecto se trata de un juego codificado en java, pensado para usarse como aplicación Android en dispositivos móviles en la cual muestra debemos adivinar un número del 1 al 100 en el núemero de intentos que nosotros veamos oportuno.

##Features
* **DataBinding** - *Enlace de la vista con los datos*
* **ViewBinding** - *Enlace de la vista con el código*
* **SaveInstanceState** 

Antes de girar la pantalla la respuesta que previamente ha seleccionado
ha de ser guardada para que se mantenga la respuesta del usuario aunque
la actividad se elimine y se reanude. Para ello se utiliza el método
`onSaveInstanceState` que recibe por parámetro un objeto Bundle donde se
guardará toda la información: 

``` java
   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("answerPosition", adapter.answerPosition);

    }
```
* **AboutUs** - *En un menu, nos permite ver la información del creador de la aplicación*

## Output
![IMG_20221014_204938](https://user-images.githubusercontent.com/114143275/195919993-8e69f2cc-533e-4281-be8a-7f84268fb9a2.jpg)
![IMG_20221014_205003](https://user-images.githubusercontent.com/114143275/195920049-442ff3c9-55bd-4386-9b79-daddf5bf7fab.jpg)
![IMG_20221014_205019](https://user-images.githubusercontent.com/114143275/195920084-562546d8-f279-43e3-a3ce-ae17298d75e5.jpg)

## Comenzando 🚀
### Pre-requisitos 📋

```
Tener un disposivo móvil físico o virtual al que instalar esta aplicación
(Opcional)Disponer de Android Studio para probar la aplicación en mejor medida.
```

### Instalación 🔧

```
Asociar el dispositivo móvil al PC
Instalar el fichero apk en dicho dispositivo
```
## Construido con 🛠️


* [Android Studio](https://developer.android.com/studio?hl=es&gclid=Cj0KCQjwsrWZBhC4ARIsAGGUJurGAdx-oPvuyAU9ddQ2TA83jo1hjQ6ikda6c51NJQlYTCQwH56ulDMaAtcxEALw_wcB&gclsrc=aw.ds) - El SDK + IDE usado

## Autores ✒️

* **Fernando Escaño Martín** - *Trabajo Inicial*
* **Fernando Escaño Martín** - *Documentación*

## Licencia 📄

