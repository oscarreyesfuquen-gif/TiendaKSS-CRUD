# Sistema CRUD - Tienda KSS

¡Bienvenido/a al repositorio oficial de **Tienda KSS**, un sistema de información de escritorio de tipo CRUD (*Create, Read, Update, Delete*) desarrollado en Java y conectado a una base de datos relacional MySQL.

---

## Introducción
El proyecto expone el desarrollo de un software diseñado para centralizar y automatizar los procesos operativos esenciales de un comercio. Implementa una arquitectura limpia basada en el patrón de diseño **DAO (Data Access Object)**, logrando una separación total entre la lógica de negocio y la persistencia de datos. El sistema abarca desde la autenticación de usuarios por roles hasta el control de los eslabones clave de la cadena de valor: inventario, clientes y proveedores.

---

## Objetivos

### Objetivo General
Desarrollar e implementar un sistema de gestión relacional para la **Tienda KSS** utilizando el lenguaje Java y MySQL, que permita administrar de manera segura y eficiente la información del comercio a través de una arquitectura modular.

### Objetivos Específicos
* **Implementar un sistema de autenticación:** Diseñar un módulo de *Login* que valide las credenciales directo contra la base de datos, identificando el rol del usuario (Administrador/Vendedor).
* **Garantizar la persistencia de datos:** Estructurar las tablas relacionales aplicando restricciones de integridad en MySQL.
* **Separar responsabilidades:** Utilizar el patrón DAO para encapsular todas las sentencias SQL (`INSERT`, `SELECT`, `UPDATE`, `DELETE`) en clases independientes.
* **Asegurar el control de versiones:** Respaldar de forma estructurada el progreso en un repositorio remoto de GitHub utilizando comandos Git.

---

## Ecosistema Tecnológico y Herramientas Utilizadas

* **Visual Studio Code (VS Code):** Editor de código fuente principal.
* **Extension Pack for Java (Microsoft):** Soporte de lenguaje (Red Hat), depurador (Debugger for Java) y gestión de proyectos.
* **XAMPP:** Suite central que unifica el servidor web local Apache y el motor de base de datos **MySQL**. Configurado estratégicamente en el puerto libre **`3307`** para asegurar la conectividad sin conflictos.
* **phpMyAdmin:** Interfaz gráfica web para la administración de tablas de la base de datos `tienda_kss_db`.
* **Git & GitHub:** Herramientas para el control de versiones y el despliegue del repositorio en la nube.

---

## Estructura del Proyecto

El espacio de trabajo se organiza bajo la siguiente estructura modular de paquetes:

```text
TiendaKSS-CRUD/
├── src/
│   └── com/
│       └── tiendakss/
│           ├── conexion/
│           │   └── ConexionBD.java        <-- Conexión a MySQL (Puerto 3307)
│           ├── dao/
│           │   ├── ClienteDAO.java        <-- Persistencia de Clientes
│           │   ├── ProductoDAO.java       <-- Persistencia de Productos
│           │   ├── ProveedorDAO.java      <-- Persistencia de Proveedores
│           │   └── UsuarioDAO.java        <-- Validación de Login y Usuarios
│           ├── modelo/
│           │   ├── Cliente.java           <-- Clase / Molde de Clientes
│           │   ├── Producto.java          <-- Clase / Molde de Productos
│           │   ├── Proveedor.java         <-- Clase / Molde de Proveedores
│           │   └── Usuario.java           <-- Clase / Molde de Usuarios
│           └── vista/
│               └── App.java               <-- Menú principal e interfaz de consola
├── .gitignore
└── README.md
