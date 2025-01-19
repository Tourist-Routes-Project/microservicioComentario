# Microservicio de Comentarios

## Descripción del Proyecto
Este microservicio está diseñado para gestionar los comentarios asociados a rutas turísticas. Permite a los usuarios escribir, actualizar y eliminar comentarios sobre rutas específicas, para proporcionar feedback o detalles adicionales sobre sus experiencias.

El sistema implementa un CRUD completo para los comentarios, con validaciones y manejo de excepciones. Además, cada comentario está vinculado a un usuario específico.

## Características Principales
- **Crear Comentarios:** Los usuarios pueden añadir comentarios asociados a rutas específicas.
- **Actualizar Comentarios:** Modificar comentarios existentes.
- **Eliminar Comentarios:** Borrar comentarios.
- **Validaciones:** Se asegura que los datos proporcionados sean correctos y válidos.
- **Manejo de Excepciones:** Control de errores.

## Endpoints Expuestos
### Base URL: `/api/v1`

- **POST** `/comment`: Crear un nuevo comentario.
- **PUT** `/comment/{id}`: Actualizar un comentario existente por su ID.
- **DELETE** `/comment/{id}`: Eliminar un comentario existente por su ID.

## Autores
Este microservicio ha sido desarrollado por **Miguel Ángel Reyes**.

