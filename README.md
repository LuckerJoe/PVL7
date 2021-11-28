Aufgabe

Implementieren Sie einen ungewichteten, ungerichteten Graphen. Ein Graph sei dabei ein Tupel von Knoten
V und Kanten E : G=(V,E). Der Graph soll dabei N Knoten besitzen, indiziert von 0 bis N-1. Eine Kante
soll eine beidseitig nutzbare Verbindung zwischen paarweise disjunkten Knoten sein.
Implementieren Sie folgende Methoden, um einen ungewichteten, ungerichteten Graphen zu realisieren:

newNode ()
Welche einen neuen Knoten dem Graphen hinzufügt und dessen Nummer zurückgibt.

setEdge(int from , int to)
Welche eine Kante zwischen den Knoten from und to erstellt. Geben Sie ”true” zurück, sollte die Kante
erfolgreich erstellt worden sein, andernfalls geben Sie ”false” zurück.

getEdges ()
Welche eine Liste von Listen aus Knoten (Integer) zurückgibt. Dabei soll es eine Liste aus Integern für jeden
Knoten geben. Die i-te Integer-Liste soll dabei repräsentieren, welche Knoten vom Knoten i aus erreichbar
sind.

getNGons(int n)
Welche eine Liste von Listen aus Knoten (Integer) zurückgibt. Speichern Sie in der Liste aus Listen alle
paarweise disjunkten n-Gons. Dabei sei ein n-Gon eine Struktur im Graphen, welche dadurch entsteht,
dass man von einem Startknoten ausgehend n-1 paarweise disjunkte Knoten durch die vorhandenen Kanten
aufsucht und zum Schluss wieder am Startknoten endet. Speichern Sie das n-Gon so, dass benachbarte
Knoten in der Liste eine Kante haben, die für das n-Gon genutzt worden ist. Ebenso soll dies für das Paar
des ersten und letzten Knotens in der Liste gelten.

hasFullCircle ()
Welche den booleschen Wert ”true” zurückgibt, falls es einen Kreis gibt, der alle Knoten des Graphen genau
einmal enthält. Ansonsten geben Sie ”false” zurück.
