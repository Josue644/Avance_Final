# 📝 Proyecto: Matrícula en Línea

> Plataforma web para el registro digital de estudiantes en instituciones educativas. Diseñada para simplificar, centralizar y agilizar el proceso de matrícula, tanto para apoderados como para el personal administrativo.

---

## 🎯 Objetivo del Proyecto

Diseñar e implementar un sistema web completo que permita a los usuarios:

- Registrar nuevos estudiantes y apoderados.
- Actualizar información de alumnos o apoderados.
- Asignar niveles, grados, turnos y sedes educativas.
- Generar y descargar constancias de matrícula.
- Gestionar docentes desde el panel administrativo.
- Visualizar un dashboard con datos consolidados de matrículas.
- Usar la plataforma en línea, con soporte para despliegue en contenedores Docker.

---

## 🛠️ Funcionalidades Implementadas

### 👨‍👩‍👧 Gestión de Matrículas
- Registro de datos del apoderado.
- Registro del estudiante vinculado.
- Asignación de datos académicos: nivel, grado, sede, turno.
- Edición y eliminación de matrículas.
- Validación básica de campos.
- Indicador visual del estado de la matrícula (`Pendiente`, `Aprobada`, etc.).

### 👨‍🏫 Gestión de Docentes
- Registro de docentes con nombre, DNI, nivel, grado, etc.
- Edición y eliminación de docentes.

### 📊 Dashboard Administrativo
- Visualización combinada de apoderado, alumno y datos académicos.
- Edición rápida desde tabla con botones modales (`Editar`, `Eliminar`, `Cambiar Estado`).

### ⚙️ Backend Spring Boot
- Controladores REST y MVC para manejar las operaciones de CRUD.
- DTOs y Servicios que encapsulan la lógica de negocio.
- Repositorios JPA conectados a MySQL.

### 🐳 Docker
- `Dockerfile` para empaquetar la app como contenedor.
- `docker-compose.yml` para correr Spring Boot + MySQL.
- Compatible con despliegue local y CI/CD.

### 📦 CI/CD (GitHub + GitLab)
- Workflows definidos en `.github/workflows/ci.yml` y `.gitlab-ci.yml`.
- Compilación con Maven usando JDK 21.
- Despliegue automático en ramas `main` y `Testing`.

---

## 🖥️ Tecnologías Utilizadas

| Categoría         | Tecnología                         |
|-------------------|------------------------------------|
| Lenguaje Backend  | Java (JDK 21)                      |
| Framework Backend | Spring Boot 3                      |
| Vista / Plantillas| Thymeleaf                          |
| Base de Datos     | MySQL                              |
| ORM               | Spring Data JPA                    |
| Autenticación     | Básica (en pruebas) / JWT (opcional) |
| Frontend          | HTML5, CSS3, JavaScript            |
| Estilos           | Bootstrap                          |
| Contenedores      | Docker, Docker Compose             |
| CI/CD             | GitHub Actions, GitLab CI          |

---

## 🧠 Lecciones Aprendidas
- Integración de múltiples capas (modelo, servicio, DTO, controlador).
- Gestión de relaciones entre entidades (Alumno – Apoderado – DatosMatricula).
- Implementación práctica de Docker en aplicaciones Java.
- Automatización con GitHub Actions y GitLab CI.
- Separación de responsabilidades y uso correcto de @ModelAttribute y @PathVariable.

<p align="center">
  <img src="https://camo.githubusercontent.com/2366b34bb903c09617990fb5fff4622f3e941349e846ddb7e73df872a9d21233/68747470733a2f2f63646e2e6472696262626c652e636f6d2f75736572732f3733303730332f73637265656e73686f74732f363538313234332f6176656e746f2e676966" />
</p>

---

## 📬 Contacto
Autor: Josue Palomino
📧 GitHub: @Josue644
🌐 GitLab: Josue_Palomino




