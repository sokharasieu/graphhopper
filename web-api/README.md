# Documentation des nouveaux tests


## Helper
### [parseList(String listStr)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/Helper.java#L421)
- Cette méthode était non couverte, donc on l'a choisi. Il est important de vérifier que le string donné retourne bel et bien une liste de string
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L107)

## GHPoint 
### [create(Point point)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/shapes/GHPoint.java#L40) 
- Cette méthode s'assure que le GHPoint est bien initialisé à partir de point de la librairie JTS. Elle s'assure aussi que la longitude et la lattitude est conservé durant la transformation
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L22)

## PointList
### [add(double lat, double lon)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L199)
- Cette méthode n'était pas couverte, elle s'assure que les valeurs de longitute et de lattitude sont ajouté dans le PointList initialisé. La méthode d'ajout est souvent utilisée, donc il est important de la tester
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L41)
### [add(double lat, double lon, double ele)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L205)
- Cette méthode n'était pas couverte, elle teste l'addition d'un point dans une PointList 3d. Vérifie aussi avec plusieurs point dans le pointList. La méthode d'ajout est souvent utilisée, donc il est important de la tester
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L58)
## Instruction 
### [setter et getter pour Distance et Time](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/Instruction.java#L108)
- Cette classe n'était pas couverte dans les tests. Ce test inclue la librairie java-faker, pour tester avec des valeurs au hasard. Elle teste les setters et getters de la classe.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L86)