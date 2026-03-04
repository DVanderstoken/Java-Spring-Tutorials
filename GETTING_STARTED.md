# Guide de démarrage

- [Guide de démarrage](#guide-de-démarrage)
  - [Pré-requis](#pré-requis)
  - [Hooks Git](#hooks-git)
    - [pre-push](#pre-push)

[Retour](README.md)

## Pré-requis

La contribution au dépôt GitHub FMS suppose d'utiliser un certain nombre d'outils, dont :

- [![Git](https://img.shields.io/badge/--ffffff?logo=git) Git](https://git-scm.com/)
- [![Markdown](https://img.shields.io/badge/--2f2f2f?logo=markdown) Markdown](https://daringfireball.net/projects/markdown/) plus particulièrement dans la [version spécialisée pour GitHub](https://github.github.com/gfm/)
- [![HTML](https://img.shields.io/badge/--ffffff?logo=html5) HTML](https://developer.mozilla.org/fr/docs/Web/HTML)
- [![Visual Studio Code](https://img.shields.io/badge/--5C2D91?logo=visualstudiocode) Visual Studio Code](https://code.visualstudio.com/) par exemple, ou tout autre éditeur de code prenant en charge les outils cités précédemment.


Merci de vous référer aux documentations officielles pour l'installation et l'utilisation de ces outils.

L'ensemble des outils cités fonctionnent dans les environnements :
- [![Linux](https://svgshare.com/i/Zhy.svg)](https://svgshare.com/i/Zhy.svg)
- [![macOS](https://svgshare.com/i/ZjP.svg)](https://svgshare.com/i/ZjP.svg)
- [![Windows](https://svgshare.com/i/ZhY.svg)](https://svgshare.com/i/ZhY.svg)
  
  L'utilisation de Git en environnement Windows nécessite l'utilisation de [Git Bash](https://gitforwindows.org/), notamment pour une intégration aisée des *Hooks Git*.


## Hooks Git

Pour l'instant, les règles de contribution et d'utilisation du dépôt  GitHub FMS sont en partie prises en charge par la mise en place de Hook côté client (sur votre poste de travail).

Une fois que vous avez clôner le dépôt sur votre poste de travail, vous **devez** installer les hooks manuellement dans le répertoire `.git/hooks/` du projet : 

**Important** : chaque fichier de hook doit être exécutable au sens Unix du terme.

### pre-push

Créer, à partir de la racine du projet, un fichier `./git/hooks/pre-push` dont le contenu est : 

```shell
#!/bin/bash
# Prevents force-pushing to master

BRANCH=`git rev-parse --abbrev-ref HEAD`
PROTECTED_BRANCHES="^(master|release-*)"

if [[ "$BRANCH" =~ $PROTECTED_BRANCHES ]]; then
  echo "Prevented force-push to protected branch \"$BRANCH\" by pre-push hook"
  exit 1
fi

exit 0
```

Ce *hook* vous interdit de *pusher* directement sur la branche `main`.

