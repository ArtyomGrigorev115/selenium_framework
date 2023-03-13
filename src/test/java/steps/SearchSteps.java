package steps;

import pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    /*Шаг состоит из действий
    * Выполнит действие "поиск по ключевому слову на странице SearchPage"
    * после этого тест переходит на следующю страницу SearchResultPage.
    * В свою очередб взаимодействие с страницей SearchResultPage описано в шаге
    * SearchResultsSteps.
    * Возвращаем новый инстанс этого класса для того, что бы автоматически перенаправится
    * к странице SearchResultPage и выполнить шаг SearchResultsSteps*/
    public SearchResultsSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchPage.fillSearchField(keyword);
        searchPage.pressEnter();
        Thread.sleep(3000);
        return new SearchResultsSteps();
    }

}
