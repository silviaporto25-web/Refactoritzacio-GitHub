package Magatzem;

public class Magatzem {
	Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
        	
        	Article article = articles[i];
        	
            if (!article.nom.equals("Formatge Gidurat")
                    && !article.nom.equals("Entrades per al Concert del Trobador")) {
                if (article.qualitat > 0) {
                    if (!article.nom.equals("Martell de Thor (Llegendari)")) {
                        article.qualitat = article.qualitat - 1;
                    }
                }
            } else {
                if (article.qualitat < 50) {
                    article.qualitat = article.qualitat + 1;

                    if (article.nom.equals("Entrades per al Concert del Trobador")) {
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

            if (!article.nom.equals("Martell de Thor (Llegendari)")) {
                article.diesPerVendre = article.diesPerVendre - 1;
            }

            if (article.diesPerVendre < 0) {
                if (!article.nom.equals("Formatge Gidurat")) {
                    if (!article.nom.equals("Entrades per al Concert del Trobador")) {
                        if (article.qualitat > 0) {
                            if (!article.nom.equals("Martell de Thor (Llegendari)")) {
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

}
