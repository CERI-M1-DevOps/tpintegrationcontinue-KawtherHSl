package liste;

/**
 * Classe représentant un nœud d'une liste chaînée simple.
 * Chaque nœud contient un élément et une référence au nœud suivant.
 */
public class Noeud {
    private Object element;
    private Noeud suivant;

    /**
     * Crée un nouveau nœud.
     * @param element L'élément à stocker dans le nœud
     * @param suivant Le nœud suivant dans la liste
     */
    public Noeud(Object element, Noeud suivant) {
        this.element = element;
        this.suivant = suivant;
    }

    /**
     * Retourne l'élément stocké dans le nœud.
     * @return L'élément du nœud
     */
    public Object getElement() {
        return element;
    }

    /**
     * Modifie l'élément stocké dans le nœud.
     * @param element Le nouvel élément à stocker
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Retourne le nœud suivant.
     * @return Le nœud suivant
     */
    public Noeud getSuivant() {
        return suivant;
    }

    /**
     * Définit le nœud suivant.
     * @param suivant Le nouveau nœud suivant
     */
    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    /**
     * Représentation sous forme de chaîne du nœud.
     * @return Une chaîne représentant le nœud
     */
    @Override
    public String toString() {
        return "Noeud(" + element + ")";
    }
}
