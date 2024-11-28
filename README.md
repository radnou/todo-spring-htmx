# Todo List App avec Spring Boot et HTMX

Ce projet est une application simple de liste de tâches à faire construite avec Spring Boot et HTMX. Elle permet aux utilisateurs d'ajouter, de supprimer et de visualiser des tâches, le tout sans rechargement complet de la page grâce à HTMX.

## Fonctionnalités

* **Ajouter des tâches**
* **Supprimer des tâches**
* **Visualiser la liste des tâches**
* **Interface utilisateur sans rechargement de page (grâce à HTMX)**

## Technologies utilisées

* **Spring Boot**
* **HTMX**
* **Thymeleaf**

## Comment exécuter l'application

1. **Cloner le dépôt**
2. **Exécuter l'application avec Maven**: `mvn spring-boot:run`
3. **Ouvrir l'application dans votre navigateur**: `http://localhost:8080/todos`

## Structure du projet

* **`src/main/java/com/rmoss/demohtmx`**: Contient le code source Java, notamment les contrôleurs et la configuration de l'application.
* **`src/main/resources/templates`**: Contient les fichiers de template Thymeleaf pour l'interface utilisateur.
* **`src/test/java/com/rmoss/demohtmx`**: Contient les tests unitaires pour l'application.

## Points d'amélioration possibles

* **Persistance des données**: Actuellement, les tâches sont stockées en mémoire et seront perdues au redémarrage de l'application. Il serait possible d'ajouter une base de données pour la persistance.
* **Fonctionnalités supplémentaires**:  Ajouter des fonctionnalités comme la modification des tâches, le marquage comme terminé, etc.
* **Amélioration de l'interface utilisateur**:  Améliorer le design et l'ergonomie de l'interface.

## Contribution

Les contributions sont les bienvenues ! N'hésitez pas à ouvrir une issue ou une pull request si vous avez des suggestions d'amélioration.
