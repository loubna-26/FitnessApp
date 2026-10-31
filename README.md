# Fitness App

Aplicación Android hecha con **Kotlin** y **Jetpack Compose** para una actividad de clase.
Permite ver y editar el perfil de una persona que realiza deporte.

## Funcionalidades

- **Pantalla de perfil:** nombre, correo, edad (calculada a partir de la fecha de nacimiento), género, altura, peso, objetivo y nivel de actividad.
- **Pantalla de editar perfil:** se pueden cambiar todos los datos personales y físicos, el objetivo principal y el nivel de actividad.
- **Selector de fecha** con calendario para la fecha de nacimiento.
- **Menús desplegables** para el género, el objetivo y el nivel de actividad.
- **Iconos** en la tarjeta de datos y en las tarjetas de objetivo y nivel de actividad.

## Tecnologías

- Kotlin
- Jetpack Compose
- Android Studio

## Estructura del proyecto

com.loubna.fitnessapp
├── MainActivity.kt // Navega entre las dos pantallas y guarda los datos
└── ui/theme 
├── componentes 
│ ├── CalendarioPicker.kt // Selector de fecha 
│ └── MenuDesplegable.kt // Menú desplegable 
├── screen 
│ ├── ProfileScreen.kt // Pantalla de perfil 
│ └── EditProfileScreen.kt // Pantalla de editar perfil 
├── Color.kt, Theme.kt, Type.kt

## Abans i després

| Pantalla | Código original | Código con vista |
|---|---|---|
| **Perfil** | <img width="220" alt="Perfil original" src="https://github.com/user-attachments/assets/43b5b58e-c6ac-4018-821e-83db23e623c1" /> | <img width="363" height="535" alt="image" src="https://github.com/user-attachments/assets/f77ef961-9e66-46a5-ac3c-b677239a646f" /> |
| **Editar perfil** | <img width="220" alt="Editar perfil original" src="https://github.com/user-attachments/assets/14b0a394-3d3a-4289-a94a-8c90130f5aa4" /> | <img width="220" alt="Editar perfil nou" src="https://github.com/user-attachments/assets/dd55a2d1-d31d-45c3-a849-0157b1114973" /> |
 
## Autora

**Loubna Houta**
Estudiante de DAM.
