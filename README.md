Qu’est-ce que Spring Core et à quoi sert-il dans une application Java ?

Spring Core est le cœur du framework Spring. Il fournit le conteneur d’inversion de contrôle (IoC) qui gère la création, la configuration et le cycle de vie des objets Java (appelés beans).
Grâce à lui, on délègue la gestion des dépendances au framework, ce qui rend le code plus souple et plus maintenable.

Que signifie le principe d’Inversion de Contrôle (IoC) ?

L’IoC (Inversion of Control) signifie que ce n’est plus le programme qui crée ses dépendances manuellement, mais le framework qui s’en charge.
En d’autres termes, le contrôle de l’instanciation est inversé : au lieu de faire new Service(), c’est Spring qui injecte le bon objet là où il faut.

Quelle est la différence entre IoC et Injection de Dépendances (DI) ?

L’IoC est le concept global : le framework gère le cycle de vie et la création des objets.
L’Injection de Dépendances (DI) est la manière concrète dont cet IoC est appliqué (par constructeur, par setter, ou directement sur un champ).

Qu’est-ce qu’un bean dans Spring ?

Un bean est un objet Java géré par le conteneur Spring.
Il est créé, configuré et détruit automatiquement selon la configuration définie (via XML, annotations ou classe Java).

Quel est le rôle du conteneur IoC ?

Le conteneur IoC est responsable de :

créer les beans à partir de la configuration,

résoudre et injecter les dépendances,

gérer leur cycle de vie (initialisation, destruction…).

Différence entre ApplicationContext et BeanFactory ?

BeanFactory est la version basique du conteneur IoC.
ApplicationContext en est une version plus complète, qui gère :

le cycle de vie complet des beans,

l’internationalisation,

les événements d’application,

la détection automatique des composants.

Les trois approches de configuration dans Spring

XML – La configuration traditionnelle (ancienne méthode).

Annotations – En utilisant des annotations comme @Component, @Autowired, etc.

Java Config – En définissant la configuration avec des classes Java annotées avec @Configuration.

Les annotations importantes

@Configuration : indique qu’une classe contient des méthodes de configuration pour créer des beans.

@ComponentScan : indique à Spring où chercher les composants à instancier automatiquement.

@Bean : déclare un bean à partir d’une méthode dans une classe @Configuration.

@Component, @Service, @Repository, @Controller : marquent les classes comme des composants Spring.

@Service : pour la couche métier

@Repository : pour la couche DAO

@Controller / @RestController : pour la couche web

@Autowired : injecte automatiquement une dépendance.

@Qualifier : précise quelle implémentation utiliser quand plusieurs beans du même type existent.

Comment Spring détecte et crée automatiquement les composants ?

Grâce au Component Scan, Spring parcourt les packages spécifiés et repère toutes les classes annotées avec @Component (ou ses variantes).
Il les instancie ensuite comme beans dans le conteneur.

Les étapes du cycle de vie d’un bean

Instanciation

Injection des dépendances

Appel de la méthode @PostConstruct (ou équivalent)

Utilisation du bean

Appel de la méthode @PreDestroy (avant suppression)

Différence entre les scopes de bean

singleton (par défaut) : un seul bean partagé dans toute l’application.

prototype : un nouveau bean à chaque demande.

request : un bean par requête HTTP (Web seulement).

session : un bean par session utilisateur.

application : un bean partagé dans le contexte global.

Pourquoi comprendre la configuration manuelle est important ?

Avant Spring Boot, il fallait tout configurer à la main (DataSource, transactions, DispatcherServlet, etc.).
Comprendre cela aide à comprendre ce que Spring Boot fait automatiquement et à mieux déboguer quand quelque chose ne fonctionne pas.

🗄️ SPRING DATA JPA — Persistance & Transactions
Qu’est-ce que Spring Data JPA ?

Spring Data JPA simplifie la gestion de la persistance.
Il fournit une couche d’abstraction au-dessus de JPA pour réduire le code boilerplate (DAO, requêtes SQL répétitives…).

Différence entre JPA et Hibernate ?

JPA : une spécification (ensemble de règles et d’interfaces).

Hibernate : une implémentation concrète de JPA (la plus utilisée).

Qu’est-ce qu’une entité JPA ?

Une entité JPA est une classe Java mappée à une table de base de données, généralement annotée avec @Entity.

À quoi sert le DataSource ?

DataSource définit la connexion physique à la base de données : URL, utilisateur, mot de passe, driver JDBC, etc.

Que fait l’EntityManager ?

L’EntityManager gère les opérations CRUD sur les entités : persister, mettre à jour, supprimer, interroger.

Rôle du TransactionManager

Il gère les transactions : début, commit, rollback en cas d’erreur.
Il garantit que les opérations sont cohérentes.

À quoi sert @EnableJpaRepositories ?

Cette annotation indique à Spring où chercher les interfaces Repository et configure automatiquement leur implémentation.

Qu’est-ce qu’un repository Spring Data ?

C’est une interface qui hérite de JpaRepository (ou CrudRepository).
Spring crée automatiquement l’implémentation correspondante.

Méthodes génériques de JpaRepository

findAll(), findById(), save(), delete(), count(), etc.

Gérer les transactions avec Spring

On utilise @Transactional pour indiquer qu’une méthode ou une classe doit être exécutée dans une transaction.
Spring s’occupe de la propagation, du commit et du rollback automatiques.

Pourquoi définir manuellement la connexion avant Spring Boot ?

Parce qu’avant Spring Boot, il n’y avait pas de configuration automatique.
On devait déclarer manuellement le DataSource, l’EntityManagerFactory et le TransactionManager.

Configuration de persistance complète

Elle contient :

le DataSource,

l’EntityManagerFactory,

le TransactionManager,

les packages contenant les entités et repositories.

Validation de contrainte

Spring peut valider les entités via javax.validation (ex : @NotNull, @Email, @Size, etc.).
On peut aussi créer des validations personnalisées (ex : email unique).

Différence entre suppression logique et physique

Physique : la donnée est réellement supprimée de la base.

Logique (soft delete) : la donnée reste, mais est marquée comme supprimée (ex : champ deleted = true).

🌐 SPRING MVC — Contrôleurs & Couche Web
Que signifie MVC ?

Model-View-Controller sépare la logique métier (Model), la présentation (View) et le contrôle (Controller).
Cela rend le code plus organisé et testable.

Rôle du DispatcherServlet

Le DispatcherServlet est le point d’entrée des requêtes web.
Il reçoit la requête, la transmet au bon contrôleur, puis renvoie la réponse appropriée.

Différence entre Controller et RestController

@Controller : renvoie une vue (HTML, JSP…).

@RestController : renvoie directement des données (JSON, XML…).

Fonctions des annotations principales

@RequestMapping : associe une URL à une méthode.

@GetMapping, @PostMapping, @PutMapping, @DeleteMapping : variantes spécifiques selon le type de requête HTTP.

@Valid : valide les données d’entrée selon les contraintes définies.

@RequestBody : lit le corps JSON de la requête et le convertit en objet Java.

@PathVariable : récupère une variable depuis l’URL.

Traitement d’une requête HTTP par le DispatcherServlet

Le DispatcherServlet reçoit la requête.

Il cherche le contrôleur correspondant.

Le contrôleur traite la logique métier.

Le résultat est renvoyé (vue ou JSON).

Le DispatcherServlet renvoie la réponse au client.

Qu’est-ce que la classe WebConfig ?

C’est la classe Java de configuration qui remplace le web.xml.
Elle définit les mappings, les vues, les interceptors, etc.

Pourquoi initialiser le DispatcherServlet manuellement avant Spring Boot ?

Avant Spring Boot, il fallait enregistrer le DispatcherServlet dans le web.xml ou via un WebAppInitializer pour le faire démarrer au lancement de l’application.

Qu’est-ce qu’un WebAppInitializer ?

C’est une classe qui implémente WebApplicationInitializer et remplace le web.xml.
Elle configure le contexte Spring et initialise le DispatcherServlet.

Étapes de traitement d’une requête REST

Requête HTTP reçue

Mappage du contrôleur via les annotations

Traitement métier

Conversion de l’objet Java en JSON (sérialisation)

Réponse HTTP envoyée
