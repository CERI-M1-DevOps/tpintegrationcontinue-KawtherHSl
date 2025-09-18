package liste;

/**
 * Classe représentant un nœud dans une liste chaînée simple.
 * Chaque nœud contient un élément et un pointeur vers le nœud suivant.
 */
public class Noeud {
    private Object element;
    private Noeud suivant;

    /**
     * Crée un nouveau nœud avec l'élément donné et le nœud suivant.
     * @param e L'élément à stocker dans ce nœud
     * @param suivant Le nœud suivant dans la liste
     */
    public Noeud(int e, Noeud suivant) {
        element = e;
        this.suivant = suivant;
    }

    /**
     * Retourne l'élément contenu dans ce nœud.
     * @return L'élément du nœud
     */
    public Object getElement() {
        return element;
    }

    /**
     * Modifie l'élément contenu dans ce nœud.
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
     * Retourne une représentation en chaîne de caractères du nœud.
     * @return Une chaîne représentant l'élément du nœud
     */
    @Override
    public String toString() {
        return "Noeud(" + element + ")";
    }
}
