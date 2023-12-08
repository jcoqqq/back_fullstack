- Concernant la possibilité de modifier une image d'illustration, avez-vous fait une route dédiée au fait de remplacer la photo ou bien considérez-vous qu'il faille simplement appeler la route de suppression puis la route d'ajout ? 
Il vaut mieux ajouter une nouvelle route pour ne pas perturber l'utilisateur 

- Concernant le stockage des images, est-il préférable de mettre d'avoir une seule table contenant tous les IDs de toutes les images (et faire une jointure systématique donc) ou bien vaut-il mieux mettre l'ID de la photo d'illustration dans la table restaurant et ne pas mettre d'ID en DB pour l'image d'illustration d'un restaurant ?
- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner la photo systématiquement (via un lien bien sûr) ?
Non car les liens peuvent contenir des informations qu'on ne voudrait pas voir exposer 
- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner l'évaluation finale systématiquement ?
Oui, pas de problèmes ici 
- Expliquez l'implémentation que vous avez fait des tags (quelles solutions avez-vous envisagées et pourquoi avoir retenu la vôtre en particulier)
