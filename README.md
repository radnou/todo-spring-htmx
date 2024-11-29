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

## Fonctionnalités supplémentaires (Roadmap)

**Lot 1: Fonctionnalités de base**

* **Marquer une tâche comme terminée**:  Ajouter une case à cocher pour marquer une tâche comme terminée. 
    *   On pourrait modifier le style des tâches terminées (barrées, grisées, etc.).
* **Modifier une tâche**:  Permettre aux utilisateurs de modifier le texte d'une tâche existante.

**Lot 2: Organisation et gestion des tâches**

* **Catégoriser les tâches**:  Permettre aux utilisateurs d'assigner des catégories ou des étiquettes à leurs tâches (travail, personnel, urgent, etc.).
    *   On pourrait ensuite filtrer ou trier les tâches par catégorie.
* **Prioriser les tâches**:  Permettre aux utilisateurs de définir des niveaux de priorité pour leurs tâches (haut, moyen, bas).
    *   On pourrait ensuite trier les tâches par priorité.
* **Dates d'échéance**:  Permettre aux utilisateurs d'ajouter des dates d'échéance à leurs tâches.
    *   On pourrait ensuite trier les tâches par date d'échéance et afficher les tâches en retard.

**Lot 3: Fonctionnalités avancées**

* **Sous-tâches**:  Permettre aux utilisateurs de créer des sous-tâches pour décomposer des tâches complexes en étapes plus petites.
* **Rappels**:  Envoyer des rappels aux utilisateurs pour les tâches avec des dates d'échéance.
* **Collaboration**:  Permettre à plusieurs utilisateurs de partager une liste de tâches et de collaborer dessus.

**Lot 4: Interface utilisateur et expérience utilisateur**

* **Améliorer le design**:  Utiliser un framework CSS (comme Bootstrap ou Tailwind CSS) pour améliorer l'apparence de l'application.
* **Drag and drop**:  Permettre aux utilisateurs de réorganiser les tâches dans la liste par glisser-déposer.
* **Mode sombre**:  Ajouter un mode sombre pour une meilleure expérience utilisateur dans des environnements peu éclairés.