# Laboratorio 10 - DataStore Preferences

Se utiliza el proyecto del laboratorio 9 sin modificar sus ViewModels y pantallas de carga/error.

- `SesionDataStore.kt`: guarda, consulta y elimina `name` de DataStore Preferences.
- `MainActivity.kt`: ruta de inicio intermedia que consulta el nombre al abrir la app, y espera a guardar/eliminar el dato antes de navegar.
- `PantallaLogin.kt`: campo Nombre y botón habilitado únicamente si se ha introducido un nombre.
- `PantallaPerfil.kt`: enseña el nombre guardado, no un nombre constante.
- `PantallaPrincipal.kt`: observa el nombre almacenado y cierra la Activity al pulsar Back desde el listado de personajes.
- `Destinos.kt`: añade la ruta de inicio.
- `app/build.gradle.kts`: dependencia de DataStore.

## Pruebas sugeridas
1. Borrar los datos de la aplicación, abrir y escribir un nombre. Verificar que se abre el listado.
2. Abrir Perfil: verificar nombre. Cerrar/reabrir app: debe continuar autenticada y preservar el nombre.
3. Presionar Back desde la lista principal: debe salir de la app.
4. Cerrar sesión desde Perfil; comprobar que regresa a Login; Back no debe regresar a personajes.
5. Reiniciar app: debe pedir el nombre de nuevo.

En Android Studio: sincronizar Gradle y compilar APK mediante Build > Build Bundle(s) / APK(s) > Build APK(s).
