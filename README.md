shmup
=====

shoot-em up en JAVA avec le framework Artemis et Slick2D

## Mystery Bazooka Disaster

Pour le nom, c'est pas de moi... je l'ai généré [ici](http://videogamena.me/ "video game name generator").
C'est un simple Shoot-em up qui utilise le famework [Artemis](http://gamadu.com/artemis/ "Artemis Framework") pour la logique du jeu
et la librairie de jeu [Slick 2D](http://slick.ninjacave.com/ "slick2D") pour les graphiques.

### Mise en place de Slick2D pour Intellij

*Attention, ces étapes ne doivent être réalisée qu'après le clonage de se projet sur votre machine*
Pour faire fonctionner ce projet sur Intellij, veuillez suivre ces étapes:
 1. Télécharger [la librairie](http://slick.ninjacave.com/slick.zip "télécharger slick2D").
 2. Créez un répertoire "/libs" à la racine de votre module.
 3. Extraire la librairie précédement téléchargée dans le dossier /libs.
 4. Mettre à jour les dépendences Maven.
 5. Dans le menu "Run" -> "Edit Configurations" -> "Configurations" -> "Vm Options" ajoutez la ligne suivante: `-Djava.library.path=MysteryBazookaDisaster/libs`

Le projet devrait maintenant pouvoir fonctionner sur vos machine.
