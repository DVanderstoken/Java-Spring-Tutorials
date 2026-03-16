[![Java CI with Maven](https://github.com/DVanderstoken/Java-Spring-Tutorials/actions/workflows/maven.yml/badge.svg)](https://github.com/DVanderstoken/Java-Spring-Tutorials/actions/workflows/maven.yml)

# Auditing & SoftDelete


## Définitions

### Auditing

*Spring Data offre une prise en charge avancée permettant de suivre de manière transparente qui a créé ou modifié une entité, ainsi que le moment où la modification a eu lieu.*

### Soft Delete

*Il arrive parfois que l’on ait besoin de ne jamais supprimer physiquement des lignes de la base de données, mais plutôt d’effectuer une « suppression logique » (soft delete), consistant à mettre à jour une colonne afin d’indiquer que la ligne n’est plus active.*

## Rappels

### Articulation Spring Data (JPA) / JPA / Hibernate

![Figure 1 : articulation Spring Data / Jpa / Hibernate](../src/main/resources/ArticulationSpringDataJpaHibernate.png)

*Spring data JPA* est bati par dessus la spécificatiopn JPA. 

L'ORM *Hibernate* est l'implémentation - de référence - de *Java Persistence API (JPA)*, et est utilisé par défaut lorsque vous utilisez *Spring Data JPA*. Mais il existe d'autres ORM...

Les connecteurs *Java DataBase Connectivity (JDBC)* et *Reactive Relational DataBase Connectivity (R2DBC)* font le lien entre les applications Java et les bases de données.

### Références

- Java persistence API [![Generic badge](https://img.shields.io/badge/eBook-PDF-red.svg)](https://jakarta.ee/specifications/persistence/3.2/jakarta-persistence-spec-3.2.pdf) [![Generic badge](https://img.shields.io/badge/Online-HTML-blue.svg)](https://jakarta.ee/specifications/persistence/3.2/jakarta-persistence-spec-3.2)

- Hibernate pour Spring Boot v3.5 [![Generic badge](https://img.shields.io/badge/Online-HTML-blue.svg)](https://docs.hibernate.org/orm//6.6//userguide/html_single/)

- Spring Data JPA pour Spring Boot v3.5 [![Generic badge](https://img.shields.io/badge/Online-HTML-blue.svg)](https://docs.spring.io/spring-data/jpa/reference/3.5/)

## Mise en oeuvre

La mise en oeuvre proposée ici porte uniquement sur le *"Quand ?"* et toutes les *@Entity* doivent porter :

- la date de création,

- la date de - dernière - modification, et

- la date de suppression.

Cette dernière règle indique que les opérations de suppression sont des **suppressions logiques** et non des suppressions physiques.


### Hibernate

- @CreationTimestamp
- @UpdateTimestamp

### Spring Data Jpa

- @CreatedDate
- @LastModifiedDate

### Suppression logique

La suppression logique est portée par la framework Hibernate (implémentation utilisée par défaut dans Spring Data JPA) via l'annotation *@SoftDelete*

Elle est configurable via trois options : 

- **obligatoire** - la stratégie appliquée à l'indicateur de suppression logique,

- **obligatoire** - le nom de la colonne qui contient l'indicateur

- **facultatif** - le convertisseur à utiliser

En ce qui concerne le convertisseur, les valeurs gérées par défaut sont des valeurs booléennes. Il faut donc, pour gérer une date, appliquer une conversion du type *Boolean* vers le type attendu, ici une date.

Cf. [Notre convertisseur](./src/main/java/com/fms/tutotrials/jpa/auditing/utils/SoftDeleteInstantConverter.java)
