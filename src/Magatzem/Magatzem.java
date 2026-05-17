package Magatzem;

public class Magatzem {
	Article[] articles;
	
	private static final String FORMATGE = "Formatge Gidurat";
	private static final String ENTRADES = "Entrades per al Concert del Trobador";
	private static final String MARTELL = "Martell de Thor (Llegendari)";

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
    	
        for (int i = 0; i < articles.length; i++) {
        	
        	Article article = articles[i];
        	
            if (!esFormatge(article) && !esEntrada(article)) {
                if (article.qualitat > 0) {
                    if (!esMartell(article)) {
                        article.qualitat = article.qualitat - 1;
                    }
                }
            } else {
                if (article.qualitat < 50) {
                    article.qualitat = article.qualitat + 1;

                    if (esEntrada(article)) {
                        if (article.diesPerVendre < 11) {
                            if (article.qualitat < 50) {
                                article.qualitat = article.qualitat + 1;
                            }
                        }

                        if (article.diesPerVendre < 6) {
                            if (article.qualitat < 50) {
                                article.qualitat = article.qualitat + 1;
                            }
                        }
                    }
                }
            }

            if (!esMartell(article)) {
                article.diesPerVendre = article.diesPerVendre - 1;
            }

            if (article.diesPerVendre < 0) {
                if (!esFormatge(article)) {
                    if (!esEntrada(article)) {
                        if (article.qualitat > 0) {
                            if (!esMartell(article)) {
                                article.qualitat = article.qualitat - 1;
                            }
                        }
                    } else {
                        article.qualitat = article.qualitat - article.qualitat;
                    }
                } else {
                    if (article.qualitat < 50) {
                        article.qualitat = article.qualitat + 1;
                    }
                }
            }
        }
    }
    
    private boolean esFormatge(Article article) {
        return article.nom.equals(FORMATGE);
    }

    private boolean esEntrada(Article article) {
        return article.nom.equals(ENTRADES);
    }

    private boolean esMartell(Article article) {
        return article.nom.equals(MARTELL);
    }

}
