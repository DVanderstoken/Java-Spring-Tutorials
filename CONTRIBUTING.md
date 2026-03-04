# Contribuer à la réussite de FMS en travaillant ensemble

[Retour](README.md)

<hr />

  - [Code de conduite](#code-de-conduite)
  - [Nouveaux thèmes](#nouveaux-thèmes)
  - [Vous avez trouvé une erreur](#vous-avez-trouvé-une-erreur)
  - [Evolution sur un sujet existant](#evolution-sur-un-sujet-existant)
  - [Comment contribuer sur le dépôt GitHub FMS](#comment-contribuer-sur-le-dépôt-github-FMS)
    - [Ouvrir une *Issue*](#ouvrir-une-issue)
    - [Soumettre une *Pull Request*](#soumettre-une-pull-request)
    - [Revue d'une *Pull Request*](#revue-dune-pull-request)
    - [Message de commit](#message-de-commit)
      - [en-tête d'un message de commit](#en-tête-dun-message-de-commit)
      - [corps d'un message de commit](#corps-dun-message-de-commit)
      - [pied d'un message de commit](#pied-dun-message-de-commit)

<hr />

## Code de conduite

La participation est ouverte à tous dans le respect du [Code de conduite](CODE_OF_CONDUCT.md).


## Nouveaux thèmes

Nous vous proposons d'ouvrir une [*Discussion*](https://github.com/FMS-EA/Java-Spring-Tutorials/discussions/1) pour les nouveaux thèmes à intégrer dans le dépôt FMS.

Pour les question ou les problèmes d'ordre général, nous vous invitons également à consulter les [ressources](Ressources/README.md) mises à votre disposition et / ou à consulter des sites de support tel que [Stack Overflow](https://stackoverflow.com/).

## Vous avez trouvé une erreur

Si vous avez trouvé une erreur vous pouvez ouvrir une [*Issue*](#ouvrir-une-issue), ou mieux encore, vous pouvez soumettre une *Pull Request* contenant la correction.

## Evolution sur un sujet existant

Vous pouvez ici aussi ouvrir une [*Issue*](#ouvrir-une-issue). S'il s'agit d'une évolution, merci de considérer l'ampleur de ladite évolution :
- s'il s'agit d'une évolution *majeure*, merci d'ouvrir une [*Issue*](#ouvrir-une-issue) et d'étayer votre proposition afin qu'elle puisse être débattue.
  
  **Note** : l'ajout d'une nouveau sujet ou le *refactoring* important d'un sujet existant est assimilé à une évolution majeure.

- s'il s'agit d'une évolution plus "*légère*", il est possible de la soumettre directement au travers d'une Pull Request.

## Comment contribuer sur le dépôt GitHub FMS

### Ouvrir une *Issue*

Avant d'ouvrir une *Issue*, merci de bien vouloir vérifier dans l'*Issue tracker* s'il existe une demande identique, éventuellement avec la solution associée.

S'il s'agit d'une *Issue* associée à du code source, merci d'indiquer :
- le contexte d'utilisation, et
- les conditions de reproduction de l'erreur.

### Soumettre une *Pull Request*

- Avant de soumettre une *Pull Request*, merci de vérifier s'il n'existe pas déjà une relative à la même correction et / ou évolution.
- La soumission d'une *Pull Request* est toujours associée à une *Issue*.
- Clôner le dépôt GitHub FMS.
- Toute modification sera faite dans une nouvelle branche (au sens Git du terme).
  
  `git checkout -b {scope}/{subject}`

  Où :  
    - `{scope}` correspond au type de la *Pull Request* : `feature` pour une nouvelle fonctionnalité, `fix` pour une correction.
    - `{subject}` correspond au sujet couvert par la correction ou l'évolution.

    **ex** : `git checkout -b feature/contributing-guidelines`
- Faire les modifications sur la nouvelle branche en question. S'il s'agit de code source, les tests adéquats devront y figurer.
- *Commiter* les modifications avec un message de commit explicite, conformément aux [règles de message de commit](#message-de-commit).
- Pousser votre branche sur le dépôt GitHub FMS :
  
  **ex** : `git push origin feature/contributing-guidelines`

- Dans GitHub, créer une *Pull Request*.


### Revue d'une *Pull Request*

Une *Pull Request* fera l'objet d'une revue qui pourra donner lieu à une discussion selon les [règles de bonne conduite](CODE_OF_CONDUCT.md) et à des compléments selon les cas.

Si des complèments sont demandés, 
- faire les modifications demandées sur votre branche, et
- Créer un commit dit de *fixup* et pousser sur le dépôt GitHub FMS.
  **ex** : 
  ```shell
  git commit --all --fixup HEAD
  git push
  ```

### Message de commit

L'homogénéisation des messages de commit doit suivre le format suivant :

```
<en-tête>
Une ligne vide
<corps du message>
Une ligne vide
<pied>
```

L'en-tête est **obligatoire** et doit se conformer au [format d'en-tête du message de commit](#en-tête-dun-message-de-commit).

#### en-tête d'un message de commit

Le format de l'en-tête d'un message de commit est le suivant :

```
{scope}({subject}): {résumé}
   |        |           |
   |        |           └─⫸ Une phrase courte conjuguée au présent, en minuscules
   |        |                et sans ponctuation                             
   |        |             
   |        └─⫸ Le sujet traité, peut être considéré comme un 'tag'
   |
   └─⫸ portée de la modification : doc | feat | fix | refactor
        s'il s'agit de code source, les éléments précédents complétés par build | ci | perf | test
```

#### corps d'un message de commit

Le corps du message de commit, comme pour l'entête, est conjugué au présent. Il peut être le lieu d'explication du *pourquoi* et du *comment* des changements effectués.

#### pied d'un message de commit

C'est l'espace de référencement  de l'*Issue* relative à la *Pull Request*, 
**ex** : 
`Closes #{Issue number}` ou `Fixes #{Issue number}`

C'est aussi le lieu d'indication des *Breaking Changes* ou des fonctionnalités obsolètes, **ex** : 
```
BREAKING CHANGE: <breaking change summary>
<BLANK LINE>
<breaking change description + migration instructions>
<BLANK LINE>
<BLANK LINE>
Fixes #<issue number>
```

Ou

```
DEPRECATED: <what is deprecated>
<BLANK LINE>
<deprecation description + recommended update path>
<BLANK LINE>
<BLANK LINE>
Closes #<pr number>

```

[Retour](README.md)
