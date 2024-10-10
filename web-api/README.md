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
### [add(PointList points)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L232)
- Ce test vérifie que l'ajout de points à une PointList directement à partir d'une autre PointList donne bien la concaténation des deux PointList originales dans le bon ordre. 
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/util/PointListTest.java#L42)
### [clone(boolean reverse)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L424)
- Ce test vérifie que la méthode clone bien tous les points de la PointList originale et respecte la propriété que tout clone de PointList est muable.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/util/PointListTest.java#L80)
### [copy(int from, int end)](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L445)
- Ce test vérifie qu'une copie fait à partir de cette méthode est une PointList contenant exactement les points entre l'index `from` et l'index `end-1` inclusivement de la PointList originale. En d'autres mots, la copie doit être un sous-ensemble strict ordonné de la PointList originale.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/util/PointListTest.java#L139)
### [hashCode()](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L484)
- Ce test vérifie que la méthode hashCode donne bien un même hash si elle est appliquée à deux PointList dont l'égalité est vraie ET vérifie aussi que la méthode donne bien un hash différent à deux PointList dont l'égalité est fausse tel que prescrit par les exigences d'implémentation de cette méthode.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/util/PointListTest.java#L112)
### [reverse()](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/PointList.java#L294)
- Ce test vérifie que l'ordre des points dans l'objet PointList est inversé correctement sur appel de reverse() en testant une liste de trois points en 2 dimensions. Il s'agit encore d'une méthode très utilisée, mais qui n'était pas testée.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/util/PointListTest.java#L17)
## Instruction 
### [setter et getter pour Distance et Time](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/main/java/com/graphhopper/util/Instruction.java#L108)
- Cette classe n'était pas couverte dans les tests. Ce test inclue la librairie java-faker, pour tester avec des valeurs au hasard. Elle teste les setters et getters de la classe.
- [lien vers le test](https://github.com/sokharasieu/graphhopper/blob/master/web-api/src/test/java/com/graphhopper/NewWebAPIUnitTests.java#L86)


