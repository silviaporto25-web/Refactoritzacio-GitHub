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

			if (esMartell(article)) {
				continue;
			}
			
			if (!esFormatge(article) && !esEntrada(article)) {
				baixarQualitat(article);
			} else {
				pujarQualitat(article);
				if (esEntrada(article)) {
					if (article.diesPerVendre < 11) {
						pujarQualitat(article);
					}
					if (article.diesPerVendre < 6) {
						pujarQualitat(article);
					}
				}
			}

			article.diesPerVendre = article.diesPerVendre - 1;

			if (article.diesPerVendre < 0) {
				if (!esFormatge(article)) {

					if (!esEntrada(article)) {
						baixarQualitat(article);

					} else {
						article.qualitat = 0;
					}
				} else {
					pujarQualitat(article);
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

	private void pujarQualitat(Article article) {
		if (article.qualitat < 50) {
			article.qualitat = article.qualitat + 1;
		}
	}

	private void baixarQualitat(Article article) {
		if (article.qualitat > 0) {
			article.qualitat = article.qualitat - 1;
		}
	}

}
