package liste;

/**
 * Représente une liste chaînée simple.
 */
public class ListeSimple {
    private long size;
    private Noeud tete;

    /**
     * Retourne la taille actuelle de la liste.
     * @return la taille de la liste
     */
    public long getSize() {
        return size;
    }

    /**
     * Ajoute un élément en tête de la liste.
     * @param element L'élément à ajouter
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /**
     * Modifie le premier élément de la liste égal à element avec nouvelleValeur.
     * @param element L'élément à rechercher dans la liste
     * @param nouvelleValeur La nouvelle valeur à remplacer
     */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    /**
     * Modifie toutes les occurrences d'un élément dans la liste.
     * @param element L'élément à rechercher
     * @param nouvelleValeur La nouvelle valeur à appliquer
     */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    /**
     * Retourne tous les éléments de la liste sous forme de chaîne.
     * @return Chaîne représentant tous les éléments de la liste
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Supprime le premier élément correspondant à element.
     * @param element L'élément à supprimer
     */
    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    /**
     * Supprime tous les éléments correspondant à element.
     * @param element L'élément à supprimer
     */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }

    /**
     * Supprime tous les nœuds contenant l'élément spécifié de manière récursive.
     * @param element L'élément à supprimer
     * @param tete Le nœud courant de la liste
     * @return Le nouveau nœud tête après suppression
     */
    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }

    /**
     * Retourne le nœud avant le dernier.
     * @return Le nœud avant le dernier, ou null si vide ou un seul élément
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        Noeud courant = tete;
        Noeud suivant = courant.getSuivant();
        while (suivant.getSuivant() != null) {
            courant = suivant;
            suivant = suivant.getSuivant();
        }
        return courant;
    }

    /**
     * Inverse l'ordre des nœuds.
     */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    /**
     * Retourne le nœud précédent celui donné.
     * @param r Le nœud dont on cherche le prédécesseur
     * @return Le nœud précédent ou null si r est la tête
     */
    public Noeud getPrecedent(Noeud r) {
        if (r == tete) return null;
        Noeud courant = tete;
        while (courant != null && courant.getSuivant() != r) {
            courant = courant.getSuivant();
        }
        return courant; 
    }

    /**
     * Échange la position de deux nœuds.
     * @param r1 Premier nœud
     * @param r2 Second nœud
     */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2) return;
        Noeud precedentR1 = (r1 == tete) ? null : getPrecedent(r1);
        Noeud precedentR2 = (r2 == tete) ? null : getPrecedent(r2);

        if (precedentR1 != null) precedentR1.setSuivant(r2);
        else tete = r2;

        if (precedentR2 != null) precedentR2.setSuivant(r1);
        else tete = r1;

        Noeud temp = r1.getSuivant();
        r1.setSuivant(r2.getSuivant());
        r2.setSuivant(temp);
    }
}
