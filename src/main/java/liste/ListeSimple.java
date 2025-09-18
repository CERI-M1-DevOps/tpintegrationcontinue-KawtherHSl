package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

    /**
     * Retourne la taille actuelle de la liste
     * @return la taille de la liste
     */
    public long getSize() {
        return size;
    }

    /**
     * Ajoute un élément en tête de la liste
     * @param element L'élément à ajouter à la liste
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /** 
     * Modifie le premier élément de la liste égal à element avec nouvelleValeur.
     * @param element L'élément à rechercher dans la liste
     * @param nouvelleValeur La nouvelle valeur à remplacer pour le premier élément trouvé
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
     * @param element L'élément à rechercher dans la liste
     * @param nouvelleValeur La nouvelle valeur qui remplacera toutes les occurrences trouvées
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
     * Retourne une représentation sous forme de chaîne de caractères
     * de tous les éléments présents dans la liste.
     * @return Une chaîne de caractères listant tous les éléments de la liste
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
     * Supprime le premier élément correspondant à element dans la liste.
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
     * Supprime tous les éléments correspondant à element dans la liste.
     * @param element L'élément à supprimer
     */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }

    /**
     * Supprime tous les nœuds contenant l'élément spécifié de manière récursive.
     * @param element L'élément à supprimer dans la liste
     * @param tete Le nœud actuel de la liste (début de la sous-liste)
     * @return Le nœud de tête de la liste modifiée après suppression
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
     * Retourne le nœud avant le dernier de la liste.
     * @return Le nœud avant le dernier, ou null si la liste est vide ou ne contient qu'un seul élément
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    /**
     * Inverse l'ordre des nœuds dans la liste.
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
     * Retourne le nœud précédent celui donné en paramètre.
     * @param r Le nœud dont on cherche le prédécesseur
     * @return Le nœud précédent r, ou null si r est la tête ou n'existe pas dans la liste
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
     * Échange la position de deux nœuds dans la liste.
     * @param r1 Premier nœud à échanger
     * @param r2 Second nœud à échanger
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
