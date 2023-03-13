package steps;

import pages.SearchResultPage;

public class SearchResultsSteps {

    private SearchResultPage searchResultPage = new SearchResultPage();

    /*Детализацию тесов выбираем на своё усмотрение
    * В этом случае в двух шагах-методах выполняются две проверки*/

    /*Эти два шага будем использовать на слое уровня тестов*/
    public SearchResultsSteps verifyThatTopResultContainsCorrectText(String text){
          searchResultPage.
          assertThatTopResultContainsCorrectText(text);
          //шагов больше нет, остаёмся на этой же странице
          return this;
    }

    public SearchResultsSteps verifyThatTopResultContainsProperAttributeText(String text){
        searchResultPage.
                assertThatTopResultContainsProperAttributeText(text);
        //шагов больше нет, остаёмся на этой же странице
        return this;
    }


}
